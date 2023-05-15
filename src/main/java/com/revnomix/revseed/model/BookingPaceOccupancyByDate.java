package com.revnomix.revseed.model;

import com.revnomix.revseed.wrapper.OccupancyByDateDto;
import com.revnomix.revseed.wrapper.OtaPerformanceDto;
import com.revnomix.revseed.wrapper.RPDADRDto;
import com.revnomix.revseed.wrapper.analysis.AdrByDOW;
import com.revnomix.revseed.wrapper.analysis.PercentileDto;
import com.revnomix.revseed.wrapper.analysis.SoldDto;
import com.revnomix.revseed.wrapper.analysis.TrendByOtaDtoAndDate;
import com.revnomix.revseed.wrapper.dashboard.PickupDto;
import com.revnomix.revseed.wrapper.dashboard.PickupTrendDto;
import com.revnomix.revseed.wrapper.dashboard.TrendByOtaDto;

import javax.persistence.*;
import java.util.Date;



@NamedNativeQueries({
        @NamedNativeQuery(name =
                "BookingPaceOccupancyByDate.findNewPickupByClientIdAndOccupancyDateAndSystemTodayAndStatus",
                query = " SELECT DATE_FORMAT(occupancy_date, '%Y-%m-%d') AS occupancyDate , COALESCE(SUM(no_of_rooms),0) AS pickup, ota_name  FROM (\n" +
                        "                                        SELECT occupancy_date,o.booking_id,o.no_of_rooms, ot.name as ota_name FROM bookings b  JOIN booking_pace_occupancy_by_date o ON b.id= o.booking_id "+
                        "                                        INNER JOIN ota_mappings otm ON (otm.id=o.ota_id) \n"+
                        "                                        INNER JOIN otas ot ON otm.ota_id=ot.id  \n" +
                        "                                        WHERE booking_datetime >  DATE_ADD(:systemToday , INTERVAL -1 second)  \n" +
                        "                                        AND booking_datetime < DATE_ADD( :systemToday , INTERVAL 1 DAY) \n" +
                        "                                        AND checkin_date <= occupancy_date AND checkout_date > occupancy_date \n" +
                        "                                        AND occupancy_date >=  :startDate AND  occupancy_date <= :endDate  and b.client_id= :clientId    \n" +
                        "                                        GROUP BY occupancy_date,o.booking_id,o.no_of_rooms,ot.name) AS A GROUP BY  occupancy_date,ota_name",

                resultClass = PickupDto.class,
                resultSetMapping = "pickupDtoMapping"
        ),
        @NamedNativeQuery(name =
                "BookingPaceOccupancyByDate.findCancelPickupByClientIdAndOccupancyDateAndSystemTodayAndStatus",
                query = " SELECT DATE_FORMAT(occupancy_date, '%Y-%m-%d') AS occupancyDate , COALESCE(SUM(no_of_rooms),0) AS pickup, ota_name  FROM (\n" +
                        "                                        SELECT occupancy_date,o.booking_id,o.no_of_rooms, ot.name as ota_name FROM bookings b  JOIN booking_pace_occupancy_by_date o ON b.id= o.booking_id\n" +
                        "                                        INNER JOIN ota_mappings otm ON (otm.id=o.ota_id) \n"+
                        "                                        INNER JOIN otas ot ON otm.ota_id=ot.id  \n" +
                        "                                        WHERE mod_datetime >  DATE_ADD(:systemToday , INTERVAL -1 second)  \n" +
                        "                                        AND mod_datetime < DATE_ADD( :systemToday , INTERVAL 1 DAY) \n" +
                        "                                        AND checkin_date <= occupancy_date AND checkout_date > occupancy_date  AND cm_status in (:status) \n" +
                        "                                        AND occupancy_date >=  :startDate AND  occupancy_date <= :endDate  and b.client_id= :clientId    \n" +
                        "                                        GROUP BY occupancy_date,o.booking_id,o.no_of_rooms,ot.name) AS A GROUP BY  occupancy_date,ota_name",

                resultClass = PickupDto.class,
                resultSetMapping = "pickupDtoMapping"
        ),
        @NamedNativeQuery(name =
                "BookingPaceOccupancyByDate.getSumOfOtaPerformance",
                query = " SELECT SUM(obd.no_of_rooms) AS Sold,ROUND(SUM(rpd)) AS Revenue, SUM(rpd)/SUM(obd.no_of_rooms) AS ADR   \n" +
                        "                                        FROM booking_pace_occupancy_by_date obd INNER JOIN bookings b ON (obd.booking_id=b.id)  \n" +
                        "                                        WHERE obd.client_id= :clientId AND cm_status not in ('B', 'cancel', 'Cancelled', 'NoShow','Pending') \n" +
                        "                                        AND  occupancy_date >= :startDate AND  occupancy_date <= :endDate  ",
                resultClass = OtaPerformanceDto.class,
                resultSetMapping = "getSumOfOtaPerformanceMapping"
        ),
        @NamedNativeQuery(name =
		        "BookingPaceOccupancyByDate.getSumOfOtaPerformancebyOTA",
		        query = " SELECT SUM(obd.no_of_rooms) AS Sold,ROUND(SUM(rpd)) AS Revenue, SUM(rpd)/SUM(obd.no_of_rooms) AS ADR   \n" +
		                "                                        FROM booking_pace_occupancy_by_date obd INNER JOIN bookings b ON (obd.booking_id=b.id)  \n" +
		                "                                        WHERE obd.client_id= :clientId AND cm_status not in ('B', 'cancel', 'Cancelled', 'NoShow','Pending') \n" +
		                "                                        AND  occupancy_date >= :startDate AND  occupancy_date <= :endDate AND obd.ota_id=:otaId ",
		        resultClass = OtaPerformanceDto.class,
		        resultSetMapping = "getSumOfOtaPerformanceMapping"
        		),
        @NamedNativeQuery(name =
        "BookingPaceOccupancyByDate.getSumOfOtaGrossPerformancebyOTA",
        query = "SELECT COALESCE(SUM(b.no_of_rooms*DATEDIFF(checkout_date, checkin_date)),0) AS pickup , \n"+
        		"SUM(b.no_of_rooms) AS Sold,ROUND(SUM(b.total_amount)) AS Revenue, ROUND(SUM(b.total_amount/b.los))/SUM(b.no_of_rooms) AS ADR \n"+
        		"FROM bookings b  WHERE booking_datetime > DATE_ADD( :startDate , INTERVAL -1 SECOND) \n"+
        		"AND booking_datetime <  DATE_ADD( :endDate , INTERVAL 1 DAY) AND b.client_id= :clientId AND ota_id=:otaId",
        resultClass = OtaPerformanceDto.class,
        resultSetMapping = "getSumOfOtaPerformanceMappingGraph"
		),
        @NamedNativeQuery(name =
        "BookingPaceOccupancyByDate.getSumOfOtaGrossPerformancebyOTAPickup",
        query = "select a.ota_id as otaId, (a.rms_a - COALESCE(b.rms_b,0)) as pickup, round((a.rev_a - COALESCE(b.rev_b,0))) as Revenue \n"
        		+ "from \n"
        		+ "(SELECT obd.ota_id, sum(obd.no_of_rooms) AS rms_a, sum(obd.rpd) as rev_a \n"
        		+ "FROM bookings b\r\n"
        		+ "INNER JOIN booking_pace_occupancy_by_date obd ON obd.booking_id=b.id \n"
        		+ "WHERE booking_datetime > DATE_ADD( :startDate , INTERVAL -1 SECOND) \n"
        		+ "AND booking_datetime <  DATE_ADD( :endDate , INTERVAL 1 DAY) AND b.client_id= :clientId \n"
        		+ "group by obd.ota_id) as a \n"
        		+ "left join \n"
        		+ "(SELECT obd.ota_id, sum(obd.no_of_rooms) AS rms_b, sum(obd.rpd) as rev_b \n"
        		+ "FROM bookings b \n"
        		+ "INNER JOIN booking_pace_occupancy_by_date obd ON obd.booking_id=b.id \n"
        		+ "WHERE booking_datetime > DATE_ADD( :startDate , INTERVAL -1 SECOND) \n"
        		+ "AND booking_datetime <  DATE_ADD( :endDate , INTERVAL 1 DAY) AND b.client_id= :clientId \n"
        		+ "AND cm_status in ('B', 'cancel', 'Cancelled', 'NoShow','Pending') \n"
        		+ "group by obd.ota_id) as b \n"
        		+ "on a.ota_id = b.ota_id;",
        resultClass = OtaPerformanceDto.class,
        resultSetMapping = "getSumOfOtaPerformanceMappingGraphOta"
		),
        @NamedNativeQuery(name =
                "BookingPaceOccupancyByDate.findCurrentTrend",
                query = " SELECT DATE_FORMAT(occupancy_date, '%Y-%m-%d') as occupancy_date,ROUND(SUM(rpd)) AS revenue ,SUM(o.no_of_rooms) AS rooms " +
                        " FROM booking_pace_occupancy_by_date o INNER JOIN bookings b ON (o.booking_id=b.id) " +
                        " WHERE o.client_id = :clientId AND occupancy_date >= :startDate  AND  occupancy_date <= :endDate  AND cm_status  not in ('B', 'cancel', 'Cancelled', 'NoShow')" +
                        " GROUP BY DATE_FORMAT(occupancy_date, '%Y-%m-%d') " +
                        " ORDER BY occupancy_date ",
                resultClass = PickupTrendDto.class,
                resultSetMapping = "currentTrendDtoMapping"
        ),
        @NamedNativeQuery(name =
        "BookingPaceOccupancyByDate.findCurrentPerformanceTrend",
        query = " SELECT DATE_FORMAT(occupancy_date, '%Y-%m-%d') as occupancy_date,ROUND(SUM(rpd)) AS revenue ,SUM(o.no_of_rooms) AS rooms , COALESCE( ROUND(SUM(rpd)/SUM(o.no_of_rooms)),0) AS adr , SUM( ct.capacity ) AS capacity" +
                " FROM booking_pace_occupancy_by_date o INNER JOIN bookings b ON (o.booking_id=b.id) " +
        		" JOIN clients ct ON b.client_id=ct.id "+
                " WHERE o.client_id = :clientId AND occupancy_date >= :startDate  AND  occupancy_date <= :endDate  AND cm_status  not in ('B', 'cancel', 'Cancelled', 'NoShow')" +
                " GROUP BY DATE_FORMAT(occupancy_date, '%Y-%m-%d') " +
                " ORDER BY occupancy_date ",
        resultClass = PickupTrendDto.class,
        resultSetMapping = "currentPerformanceTrendDtoMapping"
        ),
        @NamedNativeQuery(name =
        "BookingPaceOccupancyByDate.findSTLYCurrentPerformanceTrend",
        query = " SELECT DATE_FORMAT(occupancy_date, '%Y-%m-%d') as occupancy_date,ROUND(SUM(rpd)) AS revenue ,SUM(o.no_of_rooms) AS rooms , COALESCE( ROUND(SUM(rpd)/SUM(o.no_of_rooms)),0) AS adr , SUM( ct.capacity ) AS capacity" +
                " FROM booking_pace_occupancy_by_date o INNER JOIN bookings b ON (o.booking_id=b.id) " +
        		" JOIN clients ct ON b.client_id=ct.id "+
                " WHERE o.client_id = :clientId AND b.booking_datetime <= :monthDate  AND  occupancy_date >= :startDate  AND  occupancy_date <= :endDate  AND cm_status  not in ('B', 'cancel', 'Cancelled', 'NoShow')" +
                " GROUP BY DATE_FORMAT(occupancy_date, '%Y-%m-%d') " +
                " ORDER BY occupancy_date ",
        resultClass = PickupTrendDto.class,
        resultSetMapping = "currentPerformanceTrendDtoMapping"
        ),
        @NamedNativeQuery(name =
                "BookingPaceOccupancyByDate.findCountOfBookingInGivenAdrRangeAndOccupancyDate",
                query = " SELECT COALESCE(SUM(no_of_rooms),0) as sold FROM (SELECT o.no_of_rooms, rpd/o.no_of_rooms AS adr  FROM `booking_pace_occupancy_by_date`" +
                        "    o INNER JOIN bookings b ON (o.booking_id=b.id)                         WHERE o.client_id= :clientId AND cm_status not in ('B', 'cancel', 'Cancelled', 'NoShow','Pending') AND occupancy_date " +
                        "                            BETWEEN :startDate  AND :endDate) AS A WHERE adr BETWEEN :lowAdr AND :highAdr  ",
                resultClass = SoldDto.class,
                resultSetMapping = "soldDtoMapping"
        ),
        @NamedNativeQuery(name =
                "BookingPaceOccupancyByDate.findCountOfBookingInGivenAdrRangeAndOccupancyDateAndOtas",
                query = " SELECT COALESCE(SUM(no_of_rooms),0) as sold FROM (SELECT o.no_of_rooms, rpd/o.no_of_rooms AS adr,o.ota_id  FROM `booking_pace_occupancy_by_date`" +
                        "  o INNER JOIN bookings b ON (o.booking_id=b.id)    WHERE o.client_id= :clientId AND cm_status  not in ('B', 'cancel', 'Cancelled', 'NoShow','Pending') AND occupancy_date " +
                        "                            BETWEEN :startDate  AND :endDate) AS A WHERE adr BETWEEN :lowAdr AND :highAdr and ota_id in (SELECT id FROM `ota_mappings` WHERE ota_id IN (:otas)) ",
                resultClass = SoldDto.class,
                resultSetMapping = "soldDtoMapping"
        ),
        @NamedNativeQuery(name =
                "BookingPaceOccupancyByDate.findCountOfBookingGtrThanGivenAdrAndOccupancyDateAndOtas",
                query = " SELECT COALESCE(SUM(no_of_rooms),0) as sold FROM (SELECT o.no_of_rooms, rpd/o.no_of_rooms AS adr,o.ota_id  FROM `booking_pace_occupancy_by_date`" +
                        "              o INNER JOIN bookings b ON (o.booking_id=b.id)     WHERE o.client_id= :clientId AND cm_status not in ('B', 'cancel', 'Cancelled', 'NoShow','Pending') AND occupancy_date " +
                        "                            BETWEEN :startDate  AND :endDate) AS A WHERE adr > :lowAdr and ota_id in (SELECT id FROM `ota_mappings` WHERE ota_id IN (:otas) ) ",
                resultClass = SoldDto.class,
                resultSetMapping = "soldDtoMapping"
        ),
        @NamedNativeQuery(name =
                "BookingPaceOccupancyByDate.findCountOfBookingGtrThanGivenAdrAndOccupancyDate",
                query = " SELECT COALESCE(SUM(no_of_rooms),0) as sold FROM (SELECT o.no_of_rooms, rpd/o.no_of_rooms AS adr  FROM `booking_pace_occupancy_by_date`" +
                        "   o INNER JOIN bookings b ON (o.booking_id=b.id)  WHERE o.client_id= :clientId AND cm_status not in ('B', 'cancel', 'Cancelled', 'NoShow','Pending') AND occupancy_date " +
                        "                            BETWEEN :startDate  AND :endDate) AS A WHERE adr > :lowAdr",
                resultClass = SoldDto.class,
                resultSetMapping = "soldDtoMapping"
        ),
        @NamedNativeQuery(name =
                "BookingPaceOccupancyByDate.findCountOfBookingLessThanGivenAdrAndOccupancyDateAndOtas",
                query = " SELECT COALESCE(SUM(no_of_rooms),0) as sold FROM (SELECT o.no_of_rooms, rpd/o.no_of_rooms AS adr,o.ota_id  FROM `booking_pace_occupancy_by_date`" +
                        "      o INNER JOIN bookings b ON (o.booking_id=b.id)  WHERE o.client_id= :clientId AND cm_status not in ('B', 'cancel', 'Cancelled', 'NoShow','Pending') " +
                        "         AND occupancy_date   BETWEEN :startDate  AND :endDate) AS A WHERE adr < :lowAdr and ota_id in (SELECT id FROM `ota_mappings` WHERE ota_id IN (:otas) )  ",
                resultClass = SoldDto.class,
                resultSetMapping = "soldDtoMapping"
        ),
        @NamedNativeQuery(name =
                "BookingPaceOccupancyByDate.findCountOfBookingLessThanGivenAdrAndOccupancyDate",
                query = " SELECT COALESCE(SUM(no_of_rooms),0) as sold FROM (SELECT o.no_of_rooms, rpd/o.no_of_rooms AS adr  FROM `booking_pace_occupancy_by_date`" +
                        "  o INNER JOIN bookings b ON (o.booking_id=b.id)  WHERE o.client_id= :clientId AND cm_status not in ('B', 'cancel', 'Cancelled', 'NoShow','Pending') " +
                        "     AND occupancy_date  BETWEEN :startDate  AND :endDate) AS A WHERE adr < :lowAdr",
                resultClass = SoldDto.class,
                resultSetMapping = "soldDtoMapping"
        ),
        @NamedNativeQuery(name = "BookingPaceOccupancyByDate.getMinMaxByDOW",
                query = "select dowNumber, dow, \n" +
                        "coalesce(min, least(p5,lowerQuartile,median,upperQuartile,avg), least(lowerQuartile,median,upperQuartile,avg) )as min,\n" +
                        "coalesce(p5, least(lowerQuartile,median,upperQuartile,avg)) as p5,\n" +
                        "lowerQuartile, median,upperQuartile,\n" +
                        "coalesce(p95, greatest(lowerQuartile,median,upperQuartile)) as p95,\n" +
                        "coalesce(max, greatest(lowerQuartile,median,upperQuartile,p95), greatest(lowerQuartile,median,upperQuartile)) as max,\n" +
                        "avg\n" +
                        "from (\n" +
                        "SELECT DISTINCT dowNumber, dow,\n" +
                        "SUM(CASE WHEN prank = 0 THEN adr ELSE null END) AS min,\n" +
                        "SUM(CASE WHEN prank = 0.05 THEN adr ELSE null END) AS p5,\n" +
                        "SUM(CASE WHEN prank = 0.25 THEN adr ELSE null END) AS lowerQuartile,\n" +
                        "SUM(CASE WHEN prank = 0.5 THEN adr ELSE null END) AS median,\n" +
                        "SUM(CASE WHEN prank = 0.75 THEN adr ELSE null END) AS upperQuartile,\n" +
                        "SUM(CASE WHEN prank = 0.95 THEN adr ELSE null END) AS p95,\n" +
                        "SUM(CASE WHEN prank = 1 THEN adr ELSE null END) AS max,\n" +
                        "ROUND(SUM(rpd)/SUM(rms),0) AS avg\n" +
                        "FROM\n" +
                        "(SELECT dowNumber, dow, MIN(adr) adr, prank, SUM(rpd) AS rpd, SUM(no_of_rooms) AS rms\n" +
                        "FROM \n" +
                        "(SELECT DISTINCT DATE_FORMAT(occupancy_date, '%w') AS dowNumber,\n" +
                        "DATE_FORMAT(occupancy_date, '%a') AS dow,\n" +
                        "ROUND(rpd/obd.no_of_rooms,0) AS adr,\n" +
                        "(CASE WHEN ROUND(PERCENT_RANK() OVER (ORDER BY ROUND(rpd/obd.no_of_rooms, 2) ASC), 2) <0.05 THEN 0\n" +
                        "WHEN ROUND(PERCENT_RANK() OVER (ORDER BY ROUND(rpd/obd.no_of_rooms, 2) ASC), 2) BETWEEN 0.05 AND 0.20 THEN 0.05\n" +
                        "WHEN ROUND(PERCENT_RANK() OVER (ORDER BY ROUND(rpd/obd.no_of_rooms, 2) ASC), 2) BETWEEN 0.20 AND 0.4 THEN 0.25\n" +
                        "WHEN ROUND(PERCENT_RANK() OVER (ORDER BY ROUND(rpd/obd.no_of_rooms, 2) ASC), 2) BETWEEN 0.4 AND 0.70 THEN 0.5\n" +
                        "WHEN ROUND(PERCENT_RANK() OVER (ORDER BY ROUND(rpd/obd.no_of_rooms, 2) ASC), 2) BETWEEN 0.70 AND 0.90 THEN 0.75\n" +
                        "WHEN ROUND(PERCENT_RANK() OVER (ORDER BY ROUND(rpd/obd.no_of_rooms, 2) ASC), 2) BETWEEN 0.90 AND 0.95 THEN 0.95\n" +
                        "WHEN ROUND(PERCENT_RANK() OVER (ORDER BY ROUND(rpd/obd.no_of_rooms, 2) ASC), 2) >= 0.95 THEN 1\n" +
                        "ELSE ROUND(PERCENT_RANK() OVER (ORDER BY ROUND(rpd/obd.no_of_rooms, 2) ASC), 2) END) AS prank,\n" +
                        "rpd, no_of_rooms\n" +
                        "FROM booking_pace_occupancy_by_date  obd\n" +
                        "WHERE obd.client_id= :clientId AND occupancy_date \n" +
                        "BETWEEN :startDate AND :endDate AND rpd  > 0\n" +
                        "ORDER BY 1, 4) AS t\n" +
                        "GROUP BY dowNumber, dow, prank) AS t1\n" +
                        "GROUP BY dowNumber, dow) as t2\n" +
                        "GROUP BY dowNumber, dow;",
                resultClass = AdrByDOW.class,
                resultSetMapping = "minMaxByDOWMapping"
        ),
        @NamedNativeQuery(name = "BookingPaceOccupancyByDate.getMinMaxByDOWAndOtas",
                query = "select dowNumber, dow, \n" +
                        "coalesce(min, least(p5,lowerQuartile,median,upperQuartile,avg), least(lowerQuartile,median,upperQuartile,avg) )as min,\n" +
                        "coalesce(p5, least(lowerQuartile,median,upperQuartile,avg)) as p5,\n" +
                        "lowerQuartile, median,upperQuartile,\n" +
                        "coalesce(p95, greatest(lowerQuartile,median,upperQuartile)) as p95,\n" +
                        "coalesce(max, greatest(lowerQuartile,median,upperQuartile,p95), greatest(lowerQuartile,median,upperQuartile)) as max,\n" +
                        "avg\n" +
                        "from (\n" +
                        "SELECT DISTINCT dowNumber, dow,\n" +
                        "SUM(CASE WHEN prank = 0 THEN adr ELSE null END) AS min,\n" +
                        "SUM(CASE WHEN prank = 0.05 THEN adr ELSE null END) AS p5,\n" +
                        "SUM(CASE WHEN prank = 0.25 THEN adr ELSE null END) AS lowerQuartile,\n" +
                        "SUM(CASE WHEN prank = 0.5 THEN adr ELSE null END) AS median,\n" +
                        "SUM(CASE WHEN prank = 0.75 THEN adr ELSE null END) AS upperQuartile,\n" +
                        "SUM(CASE WHEN prank = 0.95 THEN adr ELSE null END) AS p95,\n" +
                        "SUM(CASE WHEN prank = 1 THEN adr ELSE null END) AS max,\n" +
                        "ROUND(SUM(rpd)/SUM(rms),0) AS avg\n" +
                        "FROM\n" +
                        "(SELECT dowNumber, dow, MIN(adr) adr, prank, SUM(rpd) AS rpd, SUM(no_of_rooms) AS rms\n" +
                        "FROM \n" +
                        "(SELECT DISTINCT DATE_FORMAT(occupancy_date, '%w') AS dowNumber,\n" +
                        "DATE_FORMAT(occupancy_date, '%a') AS dow,\n" +
                        "ROUND(rpd/obd.no_of_rooms,0) AS adr,\n" +
                        "(CASE WHEN ROUND(PERCENT_RANK() OVER (ORDER BY ROUND(rpd/obd.no_of_rooms, 2) ASC), 2) <0.05 THEN 0\n" +
                        "WHEN ROUND(PERCENT_RANK() OVER (ORDER BY ROUND(rpd/obd.no_of_rooms, 2) ASC), 2) BETWEEN 0.05 AND 0.20 THEN 0.05\n" +
                        "WHEN ROUND(PERCENT_RANK() OVER (ORDER BY ROUND(rpd/obd.no_of_rooms, 2) ASC), 2) BETWEEN 0.20 AND 0.4 THEN 0.25\n" +
                        "WHEN ROUND(PERCENT_RANK() OVER (ORDER BY ROUND(rpd/obd.no_of_rooms, 2) ASC), 2) BETWEEN 0.4 AND 0.70 THEN 0.5\n" +
                        "WHEN ROUND(PERCENT_RANK() OVER (ORDER BY ROUND(rpd/obd.no_of_rooms, 2) ASC), 2) BETWEEN 0.70 AND 0.90 THEN 0.75\n" +
                        "WHEN ROUND(PERCENT_RANK() OVER (ORDER BY ROUND(rpd/obd.no_of_rooms, 2) ASC), 2) BETWEEN 0.90 AND 0.95 THEN 0.95\n" +
                        "WHEN ROUND(PERCENT_RANK() OVER (ORDER BY ROUND(rpd/obd.no_of_rooms, 2) ASC), 2) >= 0.95 THEN 1\n" +
                        "ELSE ROUND(PERCENT_RANK() OVER (ORDER BY ROUND(rpd/obd.no_of_rooms, 2) ASC), 2) END) AS prank,\n" +
                        "rpd, no_of_rooms\n" +
                        "FROM booking_pace_occupancy_by_date  obd\n" +
                        "WHERE obd.client_id= :clientId AND occupancy_date \n" +
                        "BETWEEN :startDate AND :endDate AND obd.ota_id IN (SELECT id FROM `ota_mappings` WHERE ota_id IN (:otas)) AND rpd  > 0\n" +
                        "ORDER BY 1, 4) AS t\n" +
                        "GROUP BY dowNumber, dow, prank) AS t1\n" +
                        "GROUP BY dowNumber, dow) as t2\n" +
                        "GROUP BY dowNumber, dow;",
                resultClass = AdrByDOW.class,
                resultSetMapping = "minMaxByDOWMapping"
        ),
        @NamedNativeQuery(name = "BookingPaceOccupancyByDate.findSumByDayToArrival",
                query = "SELECT SUM(CASE WHEN ISNULL(sold) THEN 0 ELSE sold END) as sold FROM   (SELECT pace,SUM(o.no_of_rooms) AS sold FROM booking_pace_occupancy_by_date o INNER JOIN bookings b ON (o.booking_id=b.id)  WHERE o.client_id= :clientId AND cm_status IN ('BOOKED', 'C', 'Confirmed', 'New', 'Reserved', 'M', 'Modified', 'Modify') \n" +
                        "                                 AND occupancy_date BETWEEN :startDate AND :endDate  \n" +
                        "                                 GROUP BY pace ORDER BY pace ) AS s\n" +
                        "                                 RIGHT JOIN (SELECT ones.0 + 10*tens.0 AS num  \n" +
                        "                                 FROM (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9) ones,  \n" +
                        "                                 (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9) tens  \n" +
                        "                                 ORDER BY 1\n" +
                        "                                 ) r ON s.pace = r.num\n" +
                        " GROUP BY num ORDER BY num",
                resultClass = SoldDto.class,
                resultSetMapping = "soldDtoMapping"
        ),
		/*
		 * @NamedNativeQuery(name =
		 * "BookingPaceOccupancyByDate.findAllOtaPerformanceByClientIdAndOccupancyDate",
		 * query =
		 * "                             SELECT db_date AS occupancyDate,dow,availableCapacity,capacity,sold,revenue,adr FROM (SELECT DATE_FORMAT(A.occupancyDate, '%Y-%m-%d') AS occupancyDate,DATE_FORMAT(A.occupancyDate, '%a') AS dow,availableCapacity,capacity,sold,revenue,adr FROM (    \n"
		 * +
		 * "                                                                SELECT inv_date AS occupancyDate ,SUM(availability) AS availableCapacity  FROM staah_inventory si WHERE si.client_id= :clientId  "
		 * +
		 * "                                                                AND  inv_date >= :startDate    AND  inv_date <= :endDate  GROUP BY inv_date ) AS A   "
		 * +
		 * "                                                                LEFT JOIN  (    "
		 * +
		 * "                                                                             SELECT occupancy_date AS occupancyDate,c.capacity,SUM(o.no_of_rooms) AS sold,ROUND(SUM(rpd),0) AS revenue,ROUND(SUM(rpd)/SUM(o.no_of_rooms),0) AS adr FROM booking_pace_occupancy_by_date o  \n"
		 * +
		 * "                                                                            INNER JOIN `bookings` b ON (o.booking_id=b.id)  \n"
		 * +
		 * "                                                                            INNER JOIN clients c ON (b.client_id=c.id)  \n"
		 * +
		 * "                                                                            WHERE o.client_id= :clientId AND occupancy_date >= :startDate  AND  occupancy_date <= :endDate   "
		 * +
		 * "                                                                            AND b.cm_status<>'B'    "
		 * +
		 * "                                                                            GROUP BY occupancy_date,capacity) AS B                                                  "
		 * +
		 * "                                                                            ON (A.occupancyDate=B.occupancyDate) ) C "
		 * +
		 * "                                                                            LEFT JOIN time_dimension t ON (C.occupancyDate= t.db_date) "
		 * +
		 * "                                                                            WHERE db_date >= :startDate  AND  db_date <= :endDate   "
		 * +
		 * "                                                                            ORDER BY db_date ASC "
		 * , resultClass = OtaPerformanceDto.class, resultSetMapping =
		 * "otaPerformanceMapping" ),
		 */
        @NamedNativeQuery(name =
        "BookingPaceOccupancyByDate.findAllOtaPerformanceByClientIdAndOccupancyDate",
        query = " SELECT t.*, coalesce(availableCapacity,0) AS availableCapacity, coalesce(sold,0) AS sold, coalesce(revenue,0) AS revenue, coalesce(adr,0) AS adr \n"
        		+ "from (SELECT td.db_date AS occupancyDate, DATE_FORMAT(td.db_date, '%a') AS dow, coalesce(ct.capacity,0) AS capacity \n"
        		+ "from time_dimension td, (select capacity from clients WHERE id= :clientId) as ct \n"
        		+ "            WHERE td.db_date >= :startDate  AND  td.db_date<= :endDate \n"
        		+ "ORDER BY td.db_date ASC) t \n"
        		+ "LEFT JOIN (SELECT occupancy_date AS occupancyDate, \n"
        		+ "SUM(o.no_of_rooms) AS sold, ROUND(SUM(rpd),0) AS revenue, ROUND(SUM(rpd)/SUM(o.no_of_rooms),0) AS adr \n"
        		+ "FROM booking_pace_occupancy_by_date o  \n"
        		+ "INNER JOIN `bookings` b ON (o.booking_id=b.id)  \n"
        		+ "WHERE o.client_id= :clientId AND occupancy_date >= :startDate  AND  occupancy_date <= :endDate \n"
        		+ "AND b.cm_status not in ('B', 'cancel', 'Cancelled', 'NoShow') \n"
        		+ "GROUP BY occupancy_date) AS B ON (B.occupancyDate= t.occupancyDate) \n"
        		+ "LEFT JOIN  (SELECT inv_date AS occupancyDate, SUM(availability) AS availableCapacity \n"
        		+ "FROM staah_inventory si WHERE si.client_id= :clientId \n"
        		+ "AND  inv_date >= :startDate AND  inv_date <= :endDate  GROUP BY inv_date ) AS A \n"
        		+ "ON (A.occupancyDate = t.occupancyDate) ORDER BY occupancyDate ASC \n",
        resultClass = OtaPerformanceDto.class,
        resultSetMapping = "otaPerformanceMapping"
        ),
        @NamedNativeQuery(name = "BookingPaceOccupancyByDate.findSumByDayToArrivalforOTA",
                query = "SELECT SUM(CASE WHEN ISNULL(sold) THEN 0 ELSE sold END) as sold  FROM   (SELECT pace,SUM(o.no_of_rooms) AS sold FROM booking_pace_occupancy_by_date o INNER JOIN bookings b ON (o.booking_id=b.id)  WHERE o.client_id= :clientId AND cm_status IN ('BOOKED', 'C', 'Confirmed', 'New', 'Reserved', 'M', 'Modified', 'Modify') \n" +
                        "                                and  occupancy_date BETWEEN :startDate AND :endDate  AND o.ota_id in (SELECT id FROM `ota_mappings` WHERE ota_id IN (:otas) ) \n" +
                        "                                 GROUP BY pace ORDER BY pace ) AS s\n" +
                        "                                 RIGHT JOIN (SELECT ones.0 + 10*tens.0 AS num  \n" +
                        "                                 FROM (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9) ones,  \n" +
                        "                                 (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9) tens  \n" +
                        "                                 ORDER BY 1\n" +
                        "                                 ) r ON s.pace = r.num\n" +
                        " GROUP BY num ORDER BY num",
                resultClass = SoldDto.class,
                resultSetMapping = "soldDtoMapping"
        ),
        //////


        @NamedNativeQuery(name =
                "BookingPaceOccupancyByDate.findTrendByOta",
                query = " SELECT ots.name,CASE WHEN revenue IS NULL THEN 0 ELSE revenue END AS revenue,CASE WHEN rooms IS NULL THEN 0 ELSE rooms END AS rooms FROM (  " +
                        "SELECT otm.ota_id ,ROUND(SUM(rpd)) AS revenue,SUM(obd.no_of_rooms) AS rooms  \n" +
                        "                         FROM booking_pace_occupancy_by_date obd INNER JOIN bookings b ON (obd.booking_id=b.id)  \n" +
                        "                         INNER JOIN ota_mappings otm  ON (otm.id=obd.ota_id)  \n" +
                        "                         WHERE obd.client_id = :clientId AND occupancy_date >= :startDate  AND  occupancy_date <= :endDate AND cm_status not in ('B', 'cancel', 'Cancelled', 'NoShow') \n" +
                        "                         GROUP BY otm.ota_id )  A " +
                        "                          RIGHT JOIN (SELECT ot.* FROM  `ota_mappings`otm  RIGHT JOIN otas ot ON (otm.ota_id=ot.id) WHERE client_id=:clientId) AS ots ON (A.ota_id=ots.id) ORDER BY ots.name    ",
                resultClass = TrendByOtaDto.class,
                resultSetMapping = "trendByOtaDtoMapping"
        ),
        @NamedNativeQuery(name =
        "BookingPaceOccupancyByDate.findPerformanceTrendByOta",
        query = " SELECT ots.name,CASE WHEN revenue IS NULL THEN 0 ELSE revenue END AS revenue,CASE WHEN rooms IS NULL THEN 0 ELSE rooms END AS rooms, CASE WHEN adr IS NULL THEN 0 ELSE adr END AS adr, CASE WHEN capacity IS NULL THEN 0 ELSE capacity END AS capacity FROM (  " +
                "SELECT otm.ota_id ,ROUND(SUM(rpd)) AS revenue,SUM(obd.no_of_rooms) AS rooms , COALESCE( ROUND(SUM(rpd)/SUM(obd.no_of_rooms)),0) AS adr , SUM(ct.capacity) AS capacity \n" +
                "                         FROM booking_pace_occupancy_by_date obd INNER JOIN bookings b ON (obd.booking_id=b.id)  \n" +
                "						  JOIN clients ct ON b.client_id=ct.id"+
                "                         INNER JOIN ota_mappings otm  ON (otm.id=obd.ota_id)  \n" +
                "                         WHERE obd.client_id = :clientId AND occupancy_date >= :startDate  AND  occupancy_date <= :endDate AND cm_status not in ('B', 'cancel', 'Cancelled', 'NoShow','Pending') \n" +
                "                         GROUP BY otm.ota_id )  A " +
                "                          RIGHT JOIN (SELECT ot.* FROM  `ota_mappings`otm  RIGHT JOIN otas ot ON (otm.ota_id=ot.id) WHERE client_id=:clientId) AS ots ON (A.ota_id=ots.id) ORDER BY ots.name    ",
        resultClass = TrendByOtaDto.class,
        resultSetMapping = "trendPerformanceByOtaDtoMapping"
        ),
        @NamedNativeQuery(name =
        "BookingPaceOccupancyByDate.findSTLYPerformanceTrendByOta",
        query = " SELECT ots.name,CASE WHEN revenue IS NULL THEN 0 ELSE revenue END AS revenue,CASE WHEN rooms IS NULL THEN 0 ELSE rooms END AS rooms, CASE WHEN adr IS NULL THEN 0 ELSE adr END AS adr, CASE WHEN capacity IS NULL THEN 0 ELSE capacity END AS capacity FROM (  " +
                "SELECT otm.ota_id ,ROUND(SUM(rpd)) AS revenue,SUM(obd.no_of_rooms) AS rooms , COALESCE( ROUND(SUM(rpd)/SUM(obd.no_of_rooms)),0) AS adr , SUM(ct.capacity) AS capacity \n" +
                "                         FROM booking_pace_occupancy_by_date obd INNER JOIN bookings b ON (obd.booking_id=b.id)  \n" +
                "						  JOIN clients ct ON b.client_id=ct.id"+
                "                         INNER JOIN ota_mappings otm  ON (otm.id=obd.ota_id)  \n" +
                "                         WHERE obd.client_id = :clientId  AND b.booking_datetime <= :monthDate AND occupancy_date >= :startDate  AND  occupancy_date <= :endDate AND cm_status not in ('B', 'cancel', 'Cancelled', 'NoShow','Pending') \n" +
                "                         GROUP BY otm.ota_id )  A " +
                "                          RIGHT JOIN (SELECT ot.* FROM  `ota_mappings`otm  RIGHT JOIN otas ot ON (otm.ota_id=ot.id) WHERE client_id=:clientId) AS ots ON (A.ota_id=ots.id) ORDER BY ots.name    ",
        resultClass = TrendByOtaDto.class,
        resultSetMapping = "trendPerformanceByOtaDtoMapping"
        ),
        @NamedNativeQuery(name =
                "BookingPaceOccupancyByDate.findTrendByOtaAndDate",
                query = " SELECT DATE_FORMAT(db_date,'%b %Y') AS days,DATE_FORMAT(db_date,'%y%m') as daysOrder,NAME,CASE WHEN SUM(revenue) IS NULL THEN 0 ELSE SUM(revenue) END AS revenue \n" +
                        "                        ,CASE WHEN SUM(rooms) IS NULL THEN 0 ELSE SUM(rooms) END AS rooms  FROM ( SELECT occupancy_date,NAME,  \n" +
                        "                                                                            ROUND(SUM(rpd)) AS revenue,  \n" +
                        "                                                                            SUM(obd.no_of_rooms) AS rooms FROM   \n" +
                        "                                                                           `booking_pace_occupancy_by_date` obd  INNER JOIN bookings b ON (obd.booking_id=b.id) \n" +
                        "                                                                            INNER JOIN ota_mappings otm  ON (otm.id=obd.ota_id)   \n" +
                        "                                                                            INNER JOIN otas  ON (otas.id=otm.ota_id)  \n" +
                        "                                                                           WHERE obd.client_id = :clientId AND occupancy_date >= :startDate  AND  occupancy_date <= :endDate  AND cm_status not in ('B', 'cancel', 'Cancelled', 'NoShow','Pending') \n" +
                        "                                                                           GROUP BY  occupancy_date,NAME ) A  \n" +
                        "                         RIGHT JOIN time_dimension td ON (td.db_date=A.occupancy_date) \n" +
                        "                         WHERE   db_date >= :startDate  AND  db_date <= :endDate\n" +
                        "                         GROUP BY  DATE_FORMAT(db_date,'%b %Y'),NAME,DATE_FORMAT(db_date,'%y%m')                                            \n" +
                        "                         ORDER BY daysOrder ,NAME ",
                resultClass = TrendByOtaDtoAndDate.class,
                resultSetMapping = "trendByOtaAndDateMapping"
        ),
        @NamedNativeQuery(name =
                "BookingPaceOccupancyByDate.findByOtaAndDate",
                query = "SELECT db_date AS days,CASE WHEN SUM(revenue) IS NULL THEN 0 ELSE SUM(revenue) END AS revenue " +
                        ",CASE WHEN SUM(rooms) IS NULL THEN 0 ELSE SUM(rooms) END AS rooms  FROM ( SELECT occupancy_date, ROUND(SUM(rpd)) AS revenue, " +
                        "SUM(obd.no_of_rooms) AS rooms FROM " +
                        "booking_pace_occupancy_by_date obd  INNER JOIN bookings b ON (obd.booking_id=b.id) " +
                        "INNER JOIN ota_mappings otm  ON (otm.id=obd.ota_id) " +
                        "INNER JOIN otas  ON (otas.id=otm.ota_id) " +
                        "WHERE obd.client_id = :clientId AND occupancy_date >= :startDate AND  occupancy_date <= :endDate AND cm_status not in ('B', 'cancel', 'Cancelled', 'NoShow','Pending') " +
                        "GROUP BY  occupancy_date,NAME ) A " +
                        "RIGHT JOIN time_dimension td ON (td.db_date=A.occupancy_date) " +
                        "WHERE db_date >= :startDate AND  db_date <= :endDate " +
                        "GROUP BY db_date " +
                        "ORDER BY db_date;",
                resultClass = TrendByOtaDtoAndDate.class,
                resultSetMapping = "otaAndDateMapping"
        ),
        @NamedNativeQuery(name = "BookingPaceOccupancyByDate.findTotalArrivals",
                query = "SELECT DISTINCT DOW, ROUND(SUM(arrivals)/COUNT(*),0) AS APD FROM \n" +
                        "(SELECT occupancy_date, DATE_FORMAT(occupancy_date, '%w') AS DOW, SUM(rpd) AS total_amount,\n" +
                        "SUM(a.no_of_rooms) AS no_of_rooms, SUM(arrival) AS arrivals \n" +
                        "FROM `booking_pace_occupancy_by_date` AS a INNER JOIN bookings b ON (a.booking_id=b.id) \n" +
                        "WHERE occupancy_date BETWEEN :startDate AND :endDate AND a.client_id = :clientId \n" +
                        "AND cm_status IN ('BOOKED', 'C', 'Confirmed', 'New', 'Reserved', 'M', 'Modified', 'Modify') \n" +
                        "GROUP BY occupancy_date) AS b GROUP BY DOW ORDER BY DOW ;",
                resultClass = Integer.class,
                resultSetMapping = "totalArrivalsMapping"
        ),
        @NamedNativeQuery(name = "BookingPaceOccupancyByDate.getPercentile",
                query = "SELECT MAX(p05) adr, MAX(p95) prank\n" +
                        "FROM (SELECT  adr,FIRST_VALUE(adr) OVER (ORDER BY CASE WHEN prank <= 0.05 THEN prank ELSE 0 END DESC) p05,\n" +
                        "FIRST_VALUE(adr) OVER (ORDER BY CASE WHEN prank <= 0.95 THEN prank ELSE 0 END DESC) p95,\n" +
                        "ROUND(DENSE_RANK() OVER (ORDER BY adr ASC), 2)-1 AS rrank        \n" +
                        "FROM (SELECT  ROUND(rpd/obd.no_of_rooms,2) AS adr,\n" +
                        "ROUND(PERCENT_RANK() OVER (ORDER BY ROUND(rpd/obd.no_of_rooms,2) ASC), 2) AS prank\n" +
                        "FROM booking_pace_occupancy_by_date  obd\n" +
                        "WHERE obd.client_id= :clientId AND occupancy_date\n" +
                        "BETWEEN :startDate AND :endDate AND rpd  > 0) p2\n" +
                        ") t\n" +
                        "WHERE rrank = 0\n" +
                        "GROUP BY adr\n" +
                        "ORDER BY adr",
                resultClass = PercentileDto.class,
                resultSetMapping = "getPercentile"
        ),

        @NamedNativeQuery(name = "BookingPaceOccupancyByDate.findTotalArrivalsForOTA",
                query = "SELECT DISTINCT DOW, ROUND(SUM(arrivals)/COUNT(*),0) AS APD FROM \n" +
                        "(SELECT occupancy_date, DATE_FORMAT(occupancy_date, '%w') AS DOW, SUM(rpd) AS total_amount,\n" +
                        "SUM(a.no_of_rooms) AS no_of_rooms, SUM(arrival) AS arrivals \n" +
                        "FROM `booking_pace_occupancy_by_date` AS a INNER JOIN bookings b ON (a.booking_id=b.id) \n" +
                        "WHERE occupancy_date BETWEEN :startDate AND :endDate AND a.client_id = :clientId \n" +
                        "AND cm_status IN ('BOOKED', 'C', 'Confirmed', 'New', 'Reserved', 'M', 'Modified', 'Modify') \n" +
                        "and a.ota_id in (SELECT om.id FROM `ota_mappings` om WHERE om.ota_id IN (:otas) ) \n" +
                        "GROUP BY occupancy_date) AS b GROUP BY DOW ORDER BY DOW ;",
                resultClass = Integer.class,
                resultSetMapping = "totalArrivalsMapping"
        ),
        @NamedNativeQuery(name = "BookingPaceOccupancyByDate.findRPDADR",
                query = "SELECT DISTINCT DOW, ROUND(SUM(total_amount),0) AS total, SUM(no_of_rooms) AS Nights, ROUND(SUM(no_of_rooms)/COUNT(*),0) AS RPD, \n" +
                        "ROUND(SUM(total_amount)/SUM(no_of_rooms),0) AS ADR, ROUND(SUM(arrivals)/COUNT(*),0) AS APD, COUNT(*) \n" +
                        "AS days FROM \n" +
                        "(SELECT occupancy_date, DATE_FORMAT(occupancy_date, '%w') AS DOW, SUM(rpd) AS total_amount, \n" +
                        "SUM(a.no_of_rooms) AS no_of_rooms, SUM(arrival) AS arrivals \n" +
                        "FROM `booking_pace_occupancy_by_date` AS a INNER JOIN bookings b ON (a.booking_id=b.id) \n" +
                        "WHERE occupancy_date BETWEEN :startDate AND :endDate AND a.client_id =:clientId \n" +
                        "AND cm_status IN ('BOOKED', 'C', 'Confirmed', 'New', 'Reserved', 'M', 'Modified', 'Modify') \n" +
                        "GROUP BY occupancy_date) AS b GROUP BY DOW ORDER BY DOW ;",
                resultClass = RPDADRDto.class,
                resultSetMapping = "findRPDADRMapping"
        ),
        @NamedNativeQuery(name = "BookingPaceOccupancyByDate.findRPDADRForOTA",
                query = "SELECT DISTINCT DOW, ROUND(SUM(total_amount),0) AS total, SUM(no_of_rooms) AS Nights, ROUND(SUM(no_of_rooms)/COUNT(*),0) AS RPD, \n" +
                        "ROUND(SUM(total_amount)/SUM(no_of_rooms),0) AS ADR, ROUND(SUM(arrivals)/COUNT(*),0) AS APD, COUNT(*) AS days FROM \n" +
                        "(SELECT occupancy_date, DATE_FORMAT(occupancy_date, '%w') AS DOW, SUM(rpd) AS total_amount,\n" +
                        "SUM(a.no_of_rooms) AS no_of_rooms, SUM(arrival) AS arrivals \n" +
                        "FROM `booking_pace_occupancy_by_date` AS a INNER JOIN bookings b ON (a.booking_id=b.id) \n" +
                        "WHERE occupancy_date BETWEEN :startDate AND :endDate AND a.client_id =:clientId \n" +
                        "AND cm_status IN ('New','C','M','Modify','Reserved') AND a.ota_id in \n" +
                        "( SELECT id FROM ota_mappings WHERE ota_id IN (:otas) ) \n" +
                        "GROUP BY occupancy_date) AS b GROUP BY DOW ORDER BY DOW ;",
                resultClass = RPDADRDto.class,
                resultSetMapping = "findRPDADRMapping"
        ),
        @NamedNativeQuery(name = "BookingPaceOccupancyByDate.findRoomSoldByOta",
                query = " SELECT o.occupancy_date, ot.name, SUM(o.no_of_rooms) AS rooms, ROUND(SUM(o.rpd),0) AS revenue,  COALESCE(ROUND(SUM(o.rpd)/SUM(o.no_of_rooms),0),0) AS adr  \n" +
                        "                         FROM booking_pace_occupancy_by_date o                                        " +
                        "                        INNER JOIN bookings b ON (b.id=o.booking_id) " +
                        "                         INNER JOIN ota_mappings otm ON (otm.id=o.ota_id)\n" +
                        "                         INNER JOIN otas ot ON otm.ota_id=ot.id  \n" +
                        "                         WHERE o.client_id = :clientId AND  occupancy_date >= :startDate AND  occupancy_date <= :endDate AND b.cm_status not in ('B', 'cancel', 'Cancelled', 'NoShow') \n" +
                        "                         GROUP BY o.occupancy_date, ot.id" ,
                resultClass = OccupancyByDateDto.class,
                resultSetMapping = "findRPDADRDMapping"
        ),
        @NamedNativeQuery(name = "BookingPaceOccupancyByDate.findByClientIdAndOccupancyDateAndCmStatus",
        query = "SELECT arrival  AS prank ,departure AS adr \n"
        		+ "FROM `booking_pace_occupancy_by_date` AS a INNER JOIN bookings b ON (a.booking_id=b.id) \n"
        		+ "WHERE occupancy_date = :occupancyDate AND a.client_id = :clientId \n"
        		+ "AND cm_status IN ('New','C','M','Modify','Modified','Reserved')",
        resultClass = PercentileDto.class,
        resultSetMapping = "getPercentile"
        ),
        @NamedNativeQuery(name =
        "BookingPaceOccupancyByDate.getSumOfOtaGrossPerformancebyOTAPickupforOTA",
        query = "select a.name as otaName, (a.rms_a - COALESCE(b.rms_b,0)) as pickup, round((a.rev_a - COALESCE(b.rev_b,0))) as Revenue \n"
        		+ "from  \n"
        		+ "(SELECT ot.name, sum(obd.no_of_rooms) AS rms_a, sum(obd.rpd) as rev_a \n"
        		+ "FROM bookings b \n"
        		+ "INNER JOIN booking_pace_occupancy_by_date obd ON obd.booking_id=b.id \n"
        		+ "JOIN ota_mappings otm ON otm.id = obd.ota_id \n"
        		+ "JOIN otas ot ON ot.id = otm.ota_id \n"
        		+ "WHERE occupancy_date > DATE_ADD( :startDate , INTERVAL -1 SECOND) \n"
        		+ "AND occupancy_date <  DATE_ADD( :endDate , INTERVAL 1 DAY) AND b.client_id= :clientId \n"
        		+ "AND booking_datetime >= :fromDate \n"
        		+ "AND booking_datetime <= :toDate \n"
        		+ "AND ot.id in (:otas) \n"
        		+ "group by ot.name) as a \n"
        		+ "left join \n"
        		+ "(SELECT ot.name, sum(obd.no_of_rooms) AS rms_b, sum(obd.rpd) as rev_b \n"
        		+ "FROM bookings b \n"
        		+ "INNER JOIN booking_pace_occupancy_by_date obd ON obd.booking_id=b.id  \n"
        		+ "JOIN ota_mappings otm ON otm.id = obd.ota_id \n"
        		+ "JOIN otas ot ON ot.id = otm.ota_id \n"
        		+ "WHERE occupancy_date > DATE_ADD( :startDate , INTERVAL -1 SECOND) \n"
        		+ "AND occupancy_date <  DATE_ADD( :endDate , INTERVAL 1 DAY) AND b.client_id= :clientId \n"
        		+ "AND booking_datetime >= :fromDate \n"
        		+ "AND booking_datetime <= :toDate \n"
        		+ "AND cm_status in ('B', 'cancel', 'Cancelled', 'NoShow','Pending')  \n"
        		+ "AND ot.id in (:otas) \n"
        		+ "group by ot.name) as b  \n"
        		+ "on a.name = b.name",
        resultClass = OtaPerformanceDto.class,
        resultSetMapping = "getSumOfOtaPerformanceMappingGraphOtaName"
		),
        @NamedNativeQuery(name =
        "BookingPaceOccupancyByDate.getSumOfOtaGrossPerformancebyOTAPickupPieChartforOTA",
        query = "select a.name as otaName, (a.rms_a - COALESCE(b.rms_b,0)) as pickup, round((a.rev_a - COALESCE(b.rev_b,0))) as Revenue \n"
        		+ "from  \n"
        		+ "(SELECT ot.name, sum(obd.no_of_rooms) AS rms_a, sum(obd.rpd) as rev_a \n"
        		+ "FROM bookings b \n"
        		+ "INNER JOIN booking_pace_occupancy_by_date obd ON obd.booking_id=b.id \n"
        		+ "JOIN ota_mappings otm ON otm.id = obd.ota_id \n"
        		+ "JOIN otas ot ON ot.id = otm.ota_id \n"
        		+ "WHERE booking_datetime > DATE_ADD( :startDate , INTERVAL -1 SECOND) \n"
        		+ "AND booking_datetime <  DATE_ADD( :endDate , INTERVAL 1 DAY) AND b.client_id= :clientId \n"
        		+ "AND ot.id in (:otas) \n"
        		+ "group by ot.name) as a \n"
        		+ "left join \n"
        		+ "(SELECT ot.name, sum(obd.no_of_rooms) AS rms_b, sum(obd.rpd) as rev_b \n"
        		+ "FROM bookings b \n"
        		+ "INNER JOIN booking_pace_occupancy_by_date obd ON obd.booking_id=b.id  \n"
        		+ "JOIN ota_mappings otm ON otm.id = obd.ota_id \n"
        		+ "JOIN otas ot ON ot.id = otm.ota_id \n"
        		+ "WHERE booking_datetime > DATE_ADD( :startDate , INTERVAL -1 SECOND) \n"
        		+ "AND booking_datetime <  DATE_ADD( :endDate , INTERVAL 1 DAY) AND b.client_id= :clientId \n"
        		+ "AND cm_status in ('B', 'cancel', 'Cancelled', 'NoShow','Pending')  \n"
        		+ "AND ot.id in (:otas) \n"
        		+ "group by ot.name) as b  \n"
        		+ "on a.name = b.name",
        resultClass = OtaPerformanceDto.class,
        resultSetMapping = "getSumOfOtaPerformanceMappingGraphOtaName"
		),/*,
        @NamedNativeQuery(name = "BookingPaceOccupancyByDate.findRoomAndRevenueById",
                query = "SELECT sum(no_of_rooms) as room, sum(rpd) as revenue FROM booking_pace_occupancy_by_date where booking_id in :bookingIds" ,
                resultClass = PerformanceDto.class,
                resultSetMapping = "performanceDtoMapping"
        )*/

})

@SqlResultSetMappings({
        /*@SqlResultSetMapping(
                name = "performanceDtoMapping",
                classes = {
                        @ConstructorResult(
                                targetClass = PerformanceDto.class,
                                columns = {
                                        @ColumnResult(name = "room", type = Integer.class),
                                        @ColumnResult(name = "revenue", type = BigDecimal.class)
                                }
                        )
                }
        ),*/
        @SqlResultSetMapping(
                name = "soldDtoMapping",
                classes = {
                        @ConstructorResult(
                                targetClass = SoldDto.class,
                                columns = {
                                        @ColumnResult(name = "sold", type = Integer.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "otaPerformanceMapping",
                classes = {
                        @ConstructorResult(
                                targetClass = OtaPerformanceDto.class,
                                columns = {
                                        @ColumnResult(name = "occupancyDate", type = Date.class),
                                        @ColumnResult(name = "dow", type = String.class),
                                        @ColumnResult(name = "availableCapacity", type = Integer.class),
                                        @ColumnResult(name = "capacity", type = Integer.class),
                                        @ColumnResult(name = "sold", type = Integer.class),
                                        @ColumnResult(name = "revenue", type = Double.class),
                                        @ColumnResult(name = "adr", type = Double.class),
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "pickupDtoMapping",
                classes = {
                        @ConstructorResult(
                                targetClass = PickupDto.class,
                                columns = {
                                        @ColumnResult(name = "occupancyDate", type = Date.class),
                                        @ColumnResult(name = "pickup", type = Integer.class),
                                        @ColumnResult(name = "ota_name", type = String.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "minMaxByDOWMapping",
                classes = {
                        @ConstructorResult(
                                targetClass = AdrByDOW.class,
                                columns = {
                                        @ColumnResult(name = "dow", type = String.class),
                                        @ColumnResult(name = "min", type = Integer.class),
                                        @ColumnResult(name = "p5", type = Integer.class),
                                        @ColumnResult(name = "lowerQuartile", type = Integer.class),
                                        @ColumnResult(name = "median", type = Integer.class),
                                        @ColumnResult(name = "upperQuartile", type = Integer.class),
                                        @ColumnResult(name = "p95", type = Integer.class),
                                        @ColumnResult(name = "max", type = Integer.class),
                                        @ColumnResult(name = "avg", type = Integer.class)
                                }
                        )
                }
        ),

        @SqlResultSetMapping(
                name = "getSumOfOtaPerformanceMapping",
                classes = {
                        @ConstructorResult(
                                targetClass = OtaPerformanceDto.class,
                                columns = {
                                        @ColumnResult(name = "sold", type = Integer.class),
                                        @ColumnResult(name = "revenue", type = Double.class),
                                        @ColumnResult(name = "adr", type = Double.class),
                                }
                        )
                }
        ),

        @SqlResultSetMapping(
                name = "getSumOfOtaPerformanceMappingGraph",
                classes = {
                        @ConstructorResult(
                                targetClass = OtaPerformanceDto.class,
                                columns = {
                                        @ColumnResult(name = "sold", type = Integer.class),
                                        @ColumnResult(name = "revenue", type = Double.class),
                                        @ColumnResult(name = "adr", type = Double.class),
                                        @ColumnResult(name = "pickup", type = Integer.class)
                                }
                        )
                }
        ),
        
        @SqlResultSetMapping(
                name = "getSumOfOtaPerformanceMappingGraphOta",
                classes = {
                        @ConstructorResult(
                                targetClass = OtaPerformanceDto.class,
                                columns = {
                                        @ColumnResult(name = "revenue", type = Double.class),
                                        @ColumnResult(name = "pickup", type = Integer.class),
                                        @ColumnResult(name = "otaId", type = Integer.class)
                                }
                        )
                }
        ),
        
        @SqlResultSetMapping(
                name = "getSumOfOtaPerformanceMappingGraphOtaName",
                classes = {
                        @ConstructorResult(
                                targetClass = OtaPerformanceDto.class,
                                columns = {
                                        @ColumnResult(name = "revenue", type = Double.class),
                                        @ColumnResult(name = "pickup", type = Integer.class),
                                        @ColumnResult(name = "otaName", type = String.class)
                                }
                        )
                }
        ),

        @SqlResultSetMapping(
                name = "currentTrendDtoMapping",
                classes = {
                        @ConstructorResult(
                                targetClass = PickupTrendDto.class,
                                columns = {
                                        @ColumnResult(name = "occupancy_date", type = Date.class),
                                        @ColumnResult(name = "revenue", type = Double.class),
                                        @ColumnResult(name = "rooms", type = Integer.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "currentPerformanceTrendDtoMapping",
                classes = {
                        @ConstructorResult(
                                targetClass = PickupTrendDto.class,
                                columns = {
                                        @ColumnResult(name = "occupancy_date", type = Date.class),
                                        @ColumnResult(name = "revenue", type = Double.class),
                                        @ColumnResult(name = "rooms", type = Integer.class),
                                        @ColumnResult(name = "adr", type = Double.class),
                                        @ColumnResult(name = "capacity", type = Integer.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "trendByOtaDtoMapping",
                classes = {
                        @ConstructorResult(
                                targetClass = TrendByOtaDto.class,
                                columns = {
                                        @ColumnResult(name = "name", type = String.class),
                                        @ColumnResult(name = "revenue", type = Double.class),
                                        @ColumnResult(name = "rooms", type = Integer.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "trendPerformanceByOtaDtoMapping",
                classes = {
                        @ConstructorResult(
                                targetClass = TrendByOtaDto.class,
                                columns = {
                                        @ColumnResult(name = "name", type = String.class),
                                        @ColumnResult(name = "revenue", type = Double.class),
                                        @ColumnResult(name = "rooms", type = Integer.class),
                                        @ColumnResult(name = "adr", type = Double.class),
                                        @ColumnResult(name = "capacity", type = Integer.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "trendByOtaAndDateMapping",
                classes = {
                        @ConstructorResult(
                                targetClass = TrendByOtaDtoAndDate.class,
                                columns = {
                                        @ColumnResult(name = "days", type = String.class),
                                        @ColumnResult(name = "name", type = String.class),
                                        @ColumnResult(name = "revenue", type = Double.class),
                                        @ColumnResult(name = "rooms", type = Integer.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "otaAndDateMapping",
                classes = {
                        @ConstructorResult(
                                targetClass = TrendByOtaDtoAndDate.class,
                                columns = {
                                        @ColumnResult(name = "days", type = String.class),
                                        @ColumnResult(name = "revenue", type = Double.class),
                                        @ColumnResult(name = "rooms", type = Integer.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "totalArrivalsMapping",
                classes = {
                        @ConstructorResult(
                                targetClass = Integer.class,
                                columns = {
                                        @ColumnResult(name = "APD", type = Integer.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "getPercentile",
                classes = {
                        @ConstructorResult(
                                targetClass = PercentileDto.class,
                                columns = {
                                        @ColumnResult(name = "prank", type = Integer.class),
                                        @ColumnResult(name = "adr", type = Integer.class)
                                }
                        )
                }
        ),

        @SqlResultSetMapping(name = "findRPDADRMapping",
                classes = {
                        @ConstructorResult(
                                targetClass = RPDADRDto.class,
                                columns = {
                                        @ColumnResult(name = "DOW", type = Integer.class),
                                        @ColumnResult(name = "total", type = Integer.class),
                                        @ColumnResult(name = "Nights", type = Integer.class),
                                        @ColumnResult(name = "RPD", type = Integer.class),
                                        @ColumnResult(name = "ADR", type = Integer.class),
                                        @ColumnResult(name = "APD", type = Integer.class),
                                        @ColumnResult(name = "days", type = Integer.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(name = "findRPDADRDMapping",
                classes = {
                        @ConstructorResult(
                                targetClass = OccupancyByDateDto.class,
                                columns = {
                                        @ColumnResult(name = "occupancy_date", type = Date.class),
                                        @ColumnResult(name = "name", type = String.class),
                                        @ColumnResult(name = "rooms", type = Integer.class),
                                        @ColumnResult(name = "adr", type = float.class),
                                        @ColumnResult(name = "revenue", type = float.class)
                                }
                        )
                }
        )
})

@Entity
public class BookingPaceOccupancyByDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer clientId;
    private Integer bookingId;
    private Date occupancyDate;
    private Integer noOfRooms;
    private Double rpd;
    private Long pace;
    private Integer arrival;
    private Integer departure;
    private Integer status;
    private Integer otaId;


    public Integer getArrival() {
        return arrival;
    }

    public void setArrival(Integer arrival) {
        this.arrival = arrival;
    }

    public Integer getDeparture() {
        return departure;
    }

    public void setDeparture(Integer departure) {
        this.departure = departure;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(Integer noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public Double getRpd() {
        return rpd;
    }

    public void setRpd(Double rpd) {
        this.rpd = rpd;
    }

    public Long getPace() {
        return pace;
    }

    public void setPace(Long pace) {
        this.pace = pace;
    }

    public Date getOccupancyDate() {
        return occupancyDate;
    }

    public void setOccupancyDate(Date occupancyDate) {
        this.occupancyDate = occupancyDate;
    }

    public Integer getOtaId() {
        return otaId;
    }

    public void setOtaId(Integer otaId) {
        this.otaId = otaId;
    }
}
