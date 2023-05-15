package com.revnomix.revseed.model;

import com.revnomix.revseed.wrapper.BookingsDto;
import com.revnomix.revseed.wrapper.OtaDowSumDto;
import com.revnomix.revseed.wrapper.OtaPerformanceDto;
import com.revnomix.revseed.wrapper.PerformanceDto;
import com.revnomix.revseed.wrapper.dashboard.PickupTrendDto;
import com.revnomix.revseed.wrapper.dashboard.PickupValueDto;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@NamedNativeQueries(

        {
                @NamedNativeQuery(name =
                        "Bookings.findRevenuePickup",
                        query = "SELECT DATE_FORMAT(b.booking_datetime, '%Y-%m-%d') as booking_datetime,SUM(obd.rpd) as revenue,SUM(obd.no_of_rooms) as rooms FROM bookings b \n"
                        		+ "INNER JOIN booking_pace_occupancy_by_date obd ON obd.booking_id=b.id \n"
                        		+ "WHERE b.client_id=:clientId AND b.booking_datetime > DATE_ADD( :startDate , INTERVAL -1 SECOND) \n"
                        		+ "AND  b.booking_datetime < DATE_ADD( :endDate , INTERVAL 1 DAY) \n"
                        		+ "AND  b.cm_status not in ('B', 'cancel', 'Cancelled', 'NoShow','Pending') \n"
                        		+ "GROUP BY DATE_FORMAT(b.booking_datetime, '%Y-%m-%d') order by booking_datetime",
                        resultClass = PickupTrendDto.class,
                        resultSetMapping = "revenueTrendDtoMapping"
                ),
                @NamedNativeQuery(name =
                        "Bookings.findNewPickupForDuration",
                        query = " SELECT SUM(pickup) as pickup FROM (\n" +
                                " SELECT b.no_of_rooms*DATEDIFF(checkout_date, checkin_date)AS pickup FROM bookings b                                                                \n" +
                                "                                                                WHERE booking_datetime > DATE_ADD( :startDate , INTERVAL -1 SECOND)   \n" +
                                "                                                                AND booking_datetime <  DATE_ADD( :endDate , INTERVAL 1 DAY)   \n" +
                                "                                                                AND b.client_id= :clientId ) AS A ",
                        resultClass = PickupValueDto.class,
                        resultSetMapping = "findPickupForDurationMapping"
                ),
                @NamedNativeQuery(name =
                        "Bookings.findCancelPickupForDuration",
                        query = " SELECT SUM(pickup) as pickup FROM (\n" +
                                " SELECT b.no_of_rooms*DATEDIFF(checkout_date, checkin_date)AS pickup FROM bookings b                                                                \n" +
                                "                                                                WHERE mod_datetime > DATE_ADD( :startDate , INTERVAL -1 SECOND)   \n" +
                                "                                                                AND mod_datetime <  DATE_ADD( :endDate , INTERVAL 1 DAY)   \n" +
                                "                                                                AND cm_status in (:status) \n" +
                                "                                                                AND b.client_id= :clientId ) AS A ",
                        resultClass = PickupValueDto.class,
                        resultSetMapping = "findPickupForDurationMapping"
                ),
                @NamedNativeQuery(name =
                "Bookings.findPickupDuration",
                query = "SELECT  (SELECT COALESCE(SUM(pickup),0) as picka \n"+
                		"FROM ( SELECT b.no_of_rooms*DATEDIFF(checkout_date, checkin_date)AS pickup \n"+
                		"FROM bookings b WHERE booking_datetime > DATE_ADD( :startDate , INTERVAL -1 SECOND) \n"+
                		"AND booking_datetime <  DATE_ADD( :endDate , INTERVAL 1 DAY) AND b.client_id= :clientId )  as A) \n"+
                		"- (SELECT COALESCE(SUM(pickup),0) as pickb \n"+
                		"FROM (SELECT b.no_of_rooms*DATEDIFF(checkout_date, checkin_date)AS pickup \n"+
                		"FROM bookings b WHERE mod_datetime > DATE_ADD( :startDate , INTERVAL -1 SECOND) \n"+
                		"AND mod_datetime <  DATE_ADD( :endDate , INTERVAL 1 DAY) \n"+
                		"AND cm_status in (:status) AND b.client_id= :clientId ) AS B) as pickup",
                resultClass = PickupValueDto.class,
                resultSetMapping = "findPickupForDurationMapping"
                ),
                @NamedNativeQuery(name =
                "Bookings.findPickupDurationByOta",
                query = "SELECT COALESCE(SUM(pickup),0) as pickup \n"
                		+ "FROM ( SELECT b.no_of_rooms*DATEDIFF(checkout_date, checkin_date)AS pickup \n"
                		+ "FROM bookings b WHERE booking_datetime > DATE_ADD( :startDate , INTERVAL -1 SECOND) \n"
                		+ "AND booking_datetime <  DATE_ADD( :endDate , INTERVAL 1 DAY) AND b.client_id= :clientId AND ota_id=:otaId) as picka",
                		
                resultClass = PickupValueDto.class,
                resultSetMapping = "findPickupForDurationMapping"
                ),
                @NamedNativeQuery(
                        name="Bookings.findLOS",
                        query = "SELECT ROUND(AVG(los),2) AS los FROM bookings \n" +
                                "WHERE client_id=:clientId AND cm_status IN ('New','C','M', 'Modify','Reserved') AND \n" +
                                "checkin_date BETWEEN :startDate AND :endDate  \n" +
                                "GROUP BY DAYOFWEEK(checkin_date) ORDER BY DAYOFWEEK(checkin_date) ",
                        resultClass = Double.class,
                        resultSetMapping = "losMapping"

                ),
                @NamedNativeQuery(
                        name="Bookings.findLOSforOTA",
                        query = "SELECT ROUND(AVG(los),2) AS los FROM bookings \n" +
                                "WHERE client_id=:clientId AND cm_status IN ('New','C','M', 'Modify','Reserved') AND \n" +
                                "checkin_date BETWEEN :startDate AND :endDate \n" +
                                "and ota_id in (SELECT id FROM `ota_mappings` WHERE TYPE='STAAH' AND ota_id IN (:otas) ) \n" +
                                "GROUP BY DAYOFWEEK(checkin_date) ORDER BY DAYOFWEEK(checkin_date) ",
                        resultClass = Double.class,
                        resultSetMapping = "losMapping"

                ),
                @NamedNativeQuery(name="Bookings.findSumByOta",
                        query = "SELECT " +
                                "SUM(CASE WHEN DAYOFWEEK(booking_datetime) =1 THEN net_amount/los ELSE 0 END) AS total_1, " +
                                "SUM(CASE WHEN DAYOFWEEK(booking_datetime) =2 THEN net_amount/los ELSE 0 END) AS total_2, " +
                                "SUM(CASE WHEN DAYOFWEEK(booking_datetime) =3 THEN net_amount/los ELSE 0 END) AS total_3, " +
                                "SUM(CASE WHEN DAYOFWEEK(booking_datetime) =4 THEN net_amount/los ELSE 0 END) AS total_4, " +
                                "SUM(CASE WHEN DAYOFWEEK(booking_datetime) =5 THEN net_amount/los ELSE 0 END) AS total_5, " +
                                "SUM(CASE WHEN DAYOFWEEK(booking_datetime) =6 THEN net_amount/los ELSE 0 END) AS total_6, " +
                                "SUM(CASE WHEN DAYOFWEEK(booking_datetime) =7 THEN net_amount/los ELSE 0 END) AS total_7," +
                                "SUM(CASE WHEN NOT ISNULL(ota_id) THEN 1 ELSE 0 END) AS count,AVG(net_amount/los) AS avg_rate " +
                                "FROM bookings RIGHT OUTER JOIN otas ON otas.id= ota_id AND client_id=:clientId AND cm_status IN ('New','C','M', 'Modify','Reserved') " +
                                "AND otas.STATUS ='active' AND booking_datetime >= :startDate AND  booking_datetime<= :endDate WHERE otas.id = :otasId ",
                        resultClass = OtaDowSumDto.class,
                        resultSetMapping = "dowMapping"
                ),
                @NamedNativeQuery(name="Bookings.findSumByDow",
                        query = "SELECT " +
                                "SUM(CASE WHEN DAYOFWEEK(booking_datetime) =1 THEN net_amount/los ELSE 0 END) AS total_1, " +
                                "SUM(CASE WHEN DAYOFWEEK(booking_datetime) =2 THEN net_amount/los ELSE 0 END) AS total_2, " +
                                "SUM(CASE WHEN DAYOFWEEK(booking_datetime) =3 THEN net_amount/los ELSE 0 END) AS total_3, " +
                                "SUM(CASE WHEN DAYOFWEEK(booking_datetime) =4 THEN net_amount/los ELSE 0 END) AS total_4, " +
                                "SUM(CASE WHEN DAYOFWEEK(booking_datetime) =5 THEN net_amount/los ELSE 0 END) AS total_5, " +
                                "SUM(CASE WHEN DAYOFWEEK(booking_datetime) =6 THEN net_amount/los ELSE 0 END) AS total_6, " +
                                "SUM(CASE WHEN DAYOFWEEK(booking_datetime) =7 THEN net_amount/los ELSE 0 END) AS total_7, " +
                                "SUM(CASE WHEN NOT ISNULL(ota_id) THEN 1 ELSE 0 END) AS count,AVG(net_amount/los) AS avg_rate " +
                                "FROM bookings RIGHT OUTER JOIN otas ON otas.id= ota_id AND client_id=:clientId AND cm_status IN ('New','C','M', 'Modify','Reserved') " +
                                "AND otas.STATUS ='active' AND booking_datetime >= :startDate AND  booking_datetime<= :endDate",
                        resultClass = OtaDowSumDto.class,
                        resultSetMapping = "dowMapping"
                ),
                @NamedNativeQuery(name="Bookings.findSumByDayToArrival",
                    query="SELECT SUM(CASE WHEN ISNULL(id) THEN 0 ELSE 1 END) AS los FROM bookings RIGHT JOIN " +
                        " (SELECT ones.0 + 10*tens.0 AS num " +
                        " FROM (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9) ones, " +
                        " (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9) tens " +
                        " ORDER BY 1)r ON DATEDIFF(checkin_date,booking_datetime) = num AND " +
                        " cm_status IN ('New','C','M', 'Modify','Reserved') AND checkin_date BETWEEN :startDate AND :endDate AND client_id=:clientId GROUP BY num ORDER BY num ",
                        resultClass = Double.class,
                        resultSetMapping = "losMapping"
                ),
                @NamedNativeQuery(name="Bookings.findSumByDayToArrivalforOTA",
                        query="SELECT SUM(CASE WHEN ISNULL(id) THEN 0 ELSE 1 END) AS los FROM bookings RIGHT JOIN " +
                                " (SELECT ones.0 + 10*tens.0 AS num " +
                                " FROM (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9) ones, " +
                                " (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9) tens " +
                                " ORDER BY 1)r ON DATEDIFF(checkin_date,booking_datetime) = num AND " +
                                " cm_status IN ('New','C','M','Modify','Reserved') AND checkin_date BETWEEN :startDate AND :endDate AND client_id=:clientId and (ota_id in(:otas)) GROUP BY num ORDER BY num ",
                        resultClass = Double.class,
                        resultSetMapping = "losMapping"
                ),
                @NamedNativeQuery(name="Bookings.findBookingDetails",
                        query="SELECT * FROM\n" +
                                "(SELECT DISTINCT client_id,            \n" +
                                "MAX(checkin_date) AS MaxDate,\n" +
                                "MIN(checkin_date) AS MinDate,\n" +
                                "MAX(regdate) AS ModDate\n" +
                                "FROM bookings\n" +
                                "WHERE client_id = :clientId\n" +
                                "GROUP BY client_id) AS b\n" +
                                "INNER JOIN\n" +
                                "(SELECT DISTINCT client_id,\n" +
                                "MAX(run_datetime) RecDate\n" +
                                "FROM recom_calib_log\n" +
                                "WHERE client_id = :clientId and process_type= 'Recommendation service' \n" +
                                "GROUP BY client_id) rad\n" +
                                "ON b.client_id = rad.client_id;",
                        resultClass = BookingsDto.class,
                        resultSetMapping = "bookingDetailsMapping"
                ),
                @NamedNativeQuery(name="Bookings.findRevenueAndRoomByDateQuery",
                        query="SELECT id FROM bookings where booking_datetime <= :startDate AND " +
                                "mod_datetime > :startDate AND client_id = :clientId AND " +
                                "cm_status in ('B', 'cancel', 'Cancelled', 'NoShow') union " +
                                "SELECT id FROM bookings where booking_datetime <= :startDate AND client_id = :clientId AND " +
                                "cm_status not in ('B', 'cancel', 'Cancelled', 'NoShow','Pending'); ",
                        resultClass = Integer.class,
                        resultSetMapping = "idMapping"
                ),
                @NamedNativeQuery(name="Bookings.findGraphRoomPickup",
                query="SELECT  (SELECT COALESCE(SUM(pickup),0) as picka \n"
                		+ "FROM ( SELECT obd.no_of_rooms AS pickup \n"
                		+ "FROM bookings b \n"
                		+ "INNER JOIN booking_pace_occupancy_by_date obd ON obd.booking_id=b.id \n"
                		+ "WHERE booking_datetime > DATE_ADD( :startDate , INTERVAL -1 SECOND) \n"
                		+ "AND booking_datetime <  DATE_ADD( :endDate , INTERVAL 1 DAY) AND b.client_id= :clientId \n"
                		+ ")  as A) \n"
                		+ "- (SELECT COALESCE(SUM(pickup),0) as pickb \n"
                		+ "FROM (SELECT obd.no_of_rooms AS pickup \n"
                		+ "FROM bookings b \n"
                		+ "INNER JOIN booking_pace_occupancy_by_date obd ON obd.booking_id=b.id \n"
                		+ "WHERE booking_datetime > DATE_ADD( :startDate , INTERVAL -1 SECOND) \n"
                		+ "AND booking_datetime <  DATE_ADD( :endDate , INTERVAL 1 DAY) \n"
                		+ "AND cm_status in ('B', 'cancel', 'Cancelled', 'NoShow','Pending') AND b.client_id= :clientId ) AS B) as id \n"
                		+ "",
                resultClass = Integer.class,
                resultSetMapping = "idMapping"
                ),
                @NamedNativeQuery(name="Bookings.findGraphRevenuePickup",
                query="SELECT  (SELECT COALESCE(SUM(revnue),0) as revnuea \n"
                		+ "FROM ( SELECT obd.rpd AS revnue \n"
                		+ "FROM bookings b \n"
                		+ "INNER JOIN booking_pace_occupancy_by_date obd ON obd.booking_id=b.id \n"
                		+ "WHERE booking_datetime > DATE_ADD( :startDate , INTERVAL -1 SECOND) \n"
                		+ "AND booking_datetime <  DATE_ADD( :endDate , INTERVAL 1 DAY) AND b.client_id= :clientId \n"
                		+ ")  as A) \n"
                		+ "- (SELECT COALESCE(SUM(revnue),0) as revnueb \n"
                		+ "FROM (SELECT obd.rpd AS revnue \n"
                		+ "FROM bookings b \n"
                		+ "INNER JOIN booking_pace_occupancy_by_date obd ON obd.booking_id=b.id \n"
                		+ "WHERE booking_datetime > DATE_ADD( :startDate , INTERVAL -1 SECOND) \n"
                		+ "AND booking_datetime <  DATE_ADD( :endDate , INTERVAL 1 DAY) \n"
                		+ "AND cm_status in ('B', 'cancel', 'Cancelled', 'NoShow','Pending') AND b.client_id= :clientId ) AS B) as id",
                resultClass = Integer.class,
                resultSetMapping = "idMapping"
                ),
                @NamedNativeQuery(name="Bookings.findRevenueAndRoomAndClientByDateQueryA",
                        query="select sum(bp.no_of_rooms) as room, ROUND(sum(bp.rpd)) as revenue , otas.name as otaName , bp.occupancy_date as date\n" +
                                "from booking_pace_occupancy_by_date bp \n" +
                                "LEFT JOIN bookings b on bp.booking_id = b.id " +
                                "INNER JOIN ota_mappings otm  ON (otm.id = b.ota_id) \n" +
                                "INNER JOIN otas  ON (otas.id = otm.ota_id) \n" +
                                "where bp.client_id = :clientId \n" +
                                "and b.booking_datetime <= :monthDate AND b.cm_status not in ('B', 'cancel', 'Cancelled', 'NoShow','Pending') \n" +
                                "and bp.occupancy_date between :fromDate and :toDate group by otas.id ,bp.occupancy_date ",
                        resultClass = PerformanceDto.class,
                        resultSetMapping = "newPerformanceDtoMapping"
                ),
                @NamedNativeQuery(name="Bookings.findRevenueAndRoomAndClientByDateforMonth",
                query="SELECT SUM(bp.no_of_rooms) as room, ROUND(sum(bp.rpd)) as revenue , otas.name as otaName , bp.occupancy_date as date\n" +
                        "FROM booking_pace_occupancy_by_date bp \n" +
                        "LEFT JOIN bookings b on bp.booking_id = b.id " +
                        "INNER JOIN ota_mappings otm  ON (otm.id = b.ota_id) \n" +
                        "INNER JOIN otas  ON (otas.id = otm.ota_id) \n" +
                        "WHERE bp.client_id = :clientId \n" +
                        "AND b.cm_status not in ('B', 'cancel', 'Cancelled', 'NoShow','Pending') \n" +
                        "AND bp.occupancy_date between :fromDate AND :toDate GROUP BY otas.id ,bp.occupancy_date ",
                resultClass = PerformanceDto.class,
                resultSetMapping = "newPerformanceDtoMapping"
                ),
                @NamedNativeQuery(name="Bookings.findRevenueAndRoomSTLMandSOTM",
                query="SELECT SUM(bp.no_of_rooms) as room, ROUND(sum(bp.rpd)) as revenue , otas.name as otaName , bp.occupancy_date as date\n" +
                        "FROM booking_pace_occupancy_by_date bp \n" +
                        "LEFT JOIN bookings b on bp.booking_id = b.id " +
                        "INNER JOIN ota_mappings otm  ON (otm.id = b.ota_id) \n" +
                        "INNER JOIN otas  ON (otas.id = otm.ota_id) \n" +
                        "WHERE bp.client_id = :clientId \n" +
                        "AND b.cm_status not in ('B', 'cancel', 'Cancelled', 'NoShow','Pending') \n" +
                        "AND b.booking_datetime <=:monthDate \n" +
                        "AND bp.occupancy_date between :fromDate AND :toDate GROUP BY otas.id ,bp.occupancy_date ",
                resultClass = PerformanceDto.class,
                resultSetMapping = "newPerformanceDtoMapping"
                ),
                @NamedNativeQuery(name="Bookings.findRevenueAndRoomAndClientByDateQueryAB",
                query="select bp.no_of_rooms as room, bp.rpd as revenue , otas.name as otaName , bp.occupancy_date as date \n"
                		+ "from booking_pace_occupancy_by_date bp  \n"
                		+ "LEFT JOIN bookings b on bp.booking_id = b.id   \n"
                		+ "INNER JOIN ota_mappings otm  ON (otm.id = b.ota_id)  \n"
                		+ "INNER JOIN otas  ON (otas.id = otm.ota_id)  \n"
                		+ "where bp.client_id = :clientId \n"
                		+ "and b.booking_datetime <= :monthDate AND b.cm_status not in ('B', 'cancel', 'Cancelled', 'NoShow','Pending') \n"
                		+ "and bp.occupancy_date between :fromDate and :toDate",
                resultClass = PerformanceDto.class,
                resultSetMapping = "newPerformanceDtoMapping"
                ),
                @NamedNativeQuery(name="Bookings.findRevenueAndRoomAndClientByDateQueryB",
                        query="select sum(bp.no_of_rooms) as room, ROUND(sum(bp.rpd)) as revenue , otas.name as otaName , bp.occupancy_date as date\n" +
                                "from booking_pace_occupancy_by_date bp \n" +
                                "LEFT JOIN bookings b on bp.booking_id = b.id \n" +
                                "INNER JOIN ota_mappings otm  ON (otm.id = b.ota_id) \n" +
                                "INNER JOIN otas  ON (otas.id = otm.ota_id) \n" +
                                "where bp.client_id = :clientId and b.mod_datetime > :monthDate \n" +
                                "and b.booking_datetime <= :monthDate AND b.cm_status not in ('B', 'cancel', 'Cancelled', 'NoShow','Pending')\n" +
                                "and bp.occupancy_date between :fromDate and :toDate group by otas.id ,bp.occupancy_date ",
                        resultClass = PerformanceDto.class,
                        resultSetMapping = "newPerformanceDtoMapping"
                ),
                @NamedNativeQuery(name="Bookings.findRevenueAndRoomAndClientByDateQueryBC",
                query="select bp.no_of_rooms as room,bp.rpd as revenue , otas.name as otaName , bp.occupancy_date as date \n" +
                        "from booking_pace_occupancy_by_date bp \n" +
                        "LEFT JOIN bookings b on bp.booking_id = b.id \n" +
                        "INNER JOIN ota_mappings otm  ON (otm.id = b.ota_id) \n" +
                        "INNER JOIN otas  ON (otas.id = otm.ota_id) \n" +
                        "where bp.client_id = :clientId and b.mod_datetime > :monthDate \n" +
                        "and b.booking_datetime <= :monthDate AND b.cm_status not in ('B', 'cancel', 'Cancelled', 'NoShow','Pending') \n" +
                        "and bp.occupancy_date between :fromDate and :toDate",
                resultClass = PerformanceDto.class,
                resultSetMapping = "newPerformanceDtoMapping"
        ),
                @NamedNativeQuery(name =
                "Bookings.findGrossPickupDuration",
                query = "SELECT COALESCE(SUM(pickup),0) as pickup \n"
                		+ "FROM ( SELECT b.no_of_rooms*DATEDIFF(checkout_date, checkin_date)AS pickup \n"
                		+ "FROM bookings b WHERE booking_datetime > DATE_ADD( :startDate , INTERVAL -1 SECOND) \n"
                		+ "AND booking_datetime <  DATE_ADD( :endDate , INTERVAL 1 DAY) AND b.client_id= :clientId ) as picka",
                		
                resultClass = PickupValueDto.class,
                resultSetMapping = "findPickupForDurationMapping"
                ),
                @NamedNativeQuery(name="Bookings.findGraphRoomPickupOTA",
                query="SELECT  (SELECT COALESCE(SUM(pickup),0) as picka \n"
                		+ "FROM ( SELECT obd.no_of_rooms AS pickup \n"
                		+ "FROM bookings b \n"
                		+ "INNER JOIN booking_pace_occupancy_by_date obd ON obd.booking_id=b.id \n"
                		+ "WHERE booking_datetime > DATE_ADD( :startDate , INTERVAL -1 SECOND) \n"
                		+ "AND booking_datetime <  DATE_ADD( :endDate , INTERVAL 1 DAY) AND b.client_id= :clientId AND b.ota_id in (:otaList) \n"
                		+ ")  as A) \n"
                		+ "- (SELECT COALESCE(SUM(pickup),0) as pickb \n"
                		+ "FROM (SELECT obd.no_of_rooms AS pickup \n"
                		+ "FROM bookings b \n"
                		+ "INNER JOIN booking_pace_occupancy_by_date obd ON obd.booking_id=b.id \n"
                		+ "WHERE booking_datetime > DATE_ADD( :startDate , INTERVAL -1 SECOND) \n"
                		+ "AND booking_datetime <  DATE_ADD( :endDate , INTERVAL 1 DAY) \n"
                		+ "AND cm_status in ('B', 'cancel', 'Cancelled', 'NoShow','Pending') AND b.client_id= :clientId AND b.ota_id in (:otaList) ) AS B) as id \n"
                		+ "",
                resultClass = Integer.class,
                resultSetMapping = "idMapping"
                ),
                @NamedNativeQuery(name="Bookings.findGraphRevenuePickupOTA",
                query="SELECT  (SELECT COALESCE(SUM(revnue),0) as revnuea \n"
                		+ "FROM ( SELECT obd.rpd AS revnue \n"
                		+ "FROM bookings b \n"
                		+ "INNER JOIN booking_pace_occupancy_by_date obd ON obd.booking_id=b.id \n"
                		+ "WHERE booking_datetime > DATE_ADD( :startDate , INTERVAL -1 SECOND) \n"
                		+ "AND booking_datetime <  DATE_ADD( :endDate , INTERVAL 1 DAY) AND b.client_id= :clientId AND b.ota_id in (:otaList)  \n"
                		+ ")  as A) \n"
                		+ "- (SELECT COALESCE(SUM(revnue),0) as revnueb \n"
                		+ "FROM (SELECT obd.rpd AS revnue \n"
                		+ "FROM bookings b \n"
                		+ "INNER JOIN booking_pace_occupancy_by_date obd ON obd.booking_id=b.id \n"
                		+ "WHERE booking_datetime > DATE_ADD( :startDate , INTERVAL -1 SECOND) \n"
                		+ "AND booking_datetime <  DATE_ADD( :endDate , INTERVAL 1 DAY) \n"
                		+ "AND cm_status in ('B', 'cancel', 'Cancelled', 'NoShow','Pending') AND b.client_id= :clientId AND b.ota_id in (:otaList) ) AS B) as id",
                resultClass = Integer.class,
                resultSetMapping = "idMapping"
                ),
                @NamedNativeQuery(name =
                "Bookings.findRevenuePickupOTA",
                query = "SELECT DATE_FORMAT(b.booking_datetime, '%Y-%m-%d') as booking_datetime,SUM(obd.rpd) as revenue,SUM(obd.no_of_rooms) as rooms FROM bookings b \n"
                		+ "INNER JOIN booking_pace_occupancy_by_date obd ON obd.booking_id=b.id \n"
                		+ "WHERE b.client_id=:clientId AND b.booking_datetime > DATE_ADD( :startDate , INTERVAL -1 SECOND) \n"
                		+ "AND  b.booking_datetime < DATE_ADD( :endDate , INTERVAL 1 DAY) \n"
                		+ "AND  b.cm_status not in ('B', 'cancel', 'Cancelled', 'NoShow','Pending')  AND b.ota_id in (:otaList) \n"
                		+ "GROUP BY DATE_FORMAT(b.booking_datetime, '%Y-%m-%d') order by booking_datetime",
                resultClass = PickupTrendDto.class,
                resultSetMapping = "revenueTrendDtoMapping"
        ),
        })

@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "revenueTrendDtoMapping",
                classes = {
                        @ConstructorResult(
                                targetClass = PickupTrendDto.class,
                                columns = {
                                        @ColumnResult(name = "booking_datetime", type = Date.class),
                                        @ColumnResult(name = "revenue", type = Double.class),
                                        @ColumnResult(name = "rooms", type = Integer.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "performanceDtoMapping",
                classes = {
                        @ConstructorResult(
                                targetClass = PerformanceDto.class,
                                columns = {
                                        @ColumnResult(name = "room", type = Integer.class),
                                        @ColumnResult(name = "revenue", type = BigDecimal.class),
                                        @ColumnResult(name = "otaName", type = String.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "newPerformanceDtoMapping",
                classes = {
                        @ConstructorResult(
                                targetClass = PerformanceDto.class,
                                columns = {
                                        @ColumnResult(name = "room", type = Integer.class),
                                        @ColumnResult(name = "revenue", type = BigDecimal.class),
                                        @ColumnResult(name = "date", type = Date.class),
                                        @ColumnResult(name = "otaName", type = String.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "losMapping",
                classes = {
                        @ConstructorResult(
                                targetClass = Double.class,
                                columns = {
                                        @ColumnResult(name = "los", type = Double.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "idMapping",
                classes = {
                        @ConstructorResult(
                                targetClass = Integer.class,
                                columns = {
                                        @ColumnResult(name = "id", type = Integer.class),
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "findPickupForDurationMapping",
                classes = {
                        @ConstructorResult(
                                targetClass = PickupValueDto.class,
                                columns = {
                                        @ColumnResult(name="pickup",type = Integer.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
          name = "bookingDetailsMapping",
          classes = {
                  @ConstructorResult(
                          targetClass = BookingsDto.class,
                          columns = {
                                  @ColumnResult(name="MaxDate",type = Date.class),
                                  @ColumnResult(name="MinDate",type = Date.class),
                                  @ColumnResult(name="ModDate",type = Date.class),
                                  @ColumnResult(name="RecDate",type = Date.class)
                          }
                  )
          }
        ),
        @SqlResultSetMapping(
                name = "dowMapping",
                classes = {
                        @ConstructorResult(
                                targetClass = OtaDowSumDto.class,
                                columns = {
                                        @ColumnResult(name = "total_1", type = Double.class),
                                        @ColumnResult(name = "total_2", type = Double.class),
                                        @ColumnResult(name = "total_3", type = Double.class),
                                        @ColumnResult(name = "total_4", type = Double.class),
                                        @ColumnResult(name = "total_5", type = Double.class),
                                        @ColumnResult(name = "total_6", type = Double.class),
                                        @ColumnResult(name = "total_7", type = Double.class),
                                        @ColumnResult(name = "count", type = Integer.class),
                                        @ColumnResult(name = "avg_rate", type = Double.class)

                                }
                        )
                }
        )

})

@Table(name = "bookings")
@Entity
public class Bookings implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "client_id")
    private Integer clientId;

    @Column(name = "hotel_id")
    private Integer hotelId;

    @Column(name = "cm_id")
    private Integer cmId;

    @Column(name = "channel_manager")
    private String channelManager;

    @Column(name = "booking_datetime")
    private Date bookingDateTime;

    @Column(name = "mod_datetime")
    private Date modDateTime;

    @Column(name = "booking_no")
    private String bookingNo;

    @Column(name = "channel_string")
    private String channelString;

    @Column(name = "channel_ref")
    private String channelRef;

    @Column(name = "cm_status")
    private String cmStatus;


    @Column(name = "ota_id")
    private Integer otaId;


    @Column(name = "checkin_date")
    private Date checkinDate;

    @Column(name = "checkout_date")
    private Date checkoutDate;

    @Column(name = "los")
    private Integer los;

    @Column(name = "no_of_rooms")
    private Integer noOfRooms;

    @Column(name = "cm_room_id")
    private Long cmRoomId;


    @Column(name = "cm_room_type_string")
    private String cmRoomTypeString;

    @Column(name = "room_type")
    private Integer roomType;

    @Column(name = "rate_id")
    private Long rateId;

    @Column(name = "ratePlan")
    private Long ratePlan;

    @Column(name = "currency")
    private String currency;


    @Column(name = "rate_value")
    private Float rateValue;


    @Column(name = "price_date")
    private Date priceDate;

    @Column(name = "price")
    private Double price;

    @Column(name = "commission")
    private Double commission;

    @Column(name = "tax_value")
    private Double taxValue;

    @Column(name = "total_amount")
    private Double totalAmount;

    @Column(name = "net_amount")
    private Double netAmount;


    @Column(name = "total_guests")
    private Integer totalGuests;


    @Column(name = "total_adults")
    private Integer totalAdults;

    @Column(name = "total_children")
    private Integer totalChildren;

    @Column(name = "no_of_extra_adults")
    private Integer noOfExtraAdults;

    @Column(name = "extra_adult_rate")
    private Double extraAdultRate;

    @Column(name = "no_of_extra_children")
    private Integer noOfExtraChildren;

    @Column(name = "extra_children_rate")
    private Double extraChildrenRate;

    @Column(name = "addon")
    private String addon;

    @Column(name = "addon_rate")
    private Double addonRate;

    @Column(name = "regdate_rate")
    private Date regdateRate;

    @Column(name = "regdate")
    private Date regDate;

    @Column(name = "status")
    private String status;

    @Column(name = "api_response")
    private String apiResponse;

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
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

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getCmId() {
        return cmId;
    }

    public void setCmId(Integer cmId) {
        this.cmId = cmId;
    }

    public String getChannelManager() {
        return channelManager;
    }

    public void setChannelManager(String channelManager) {
        this.channelManager = channelManager;
    }

    public Date getBookingDateTime() {
        return bookingDateTime;
    }

    public void setBookingDateTime(Date bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
    }

    public String getBookingNo() {
        return bookingNo;
    }

    public void setBookingNo(String bookingNo) {
        this.bookingNo = bookingNo;
    }

    public String getChannelString() {
        return channelString;
    }

    public void setChannelString(String channelString) {
        this.channelString = channelString;
    }

    public String getChannelRef() {
        return channelRef;
    }

    public void setChannelRef(String channelRef) {
        this.channelRef = channelRef;
    }

    public String getCmStatus() {
        return cmStatus;
    }

    public void setCmStatus(String cmStatus) {
        this.cmStatus = cmStatus;
    }

    public Integer getOtaId() {
        return otaId;
    }

    public void setOtaId(Integer otaId) {
        this.otaId = otaId;
    }

    public Date getModDateTime() {
        return modDateTime;
    }

    public void setModDateTime(Date modDateTime) {
        this.modDateTime = modDateTime;
    }

    public Date getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public Integer getLos() {
        return los;
    }

    public void setLos(Integer los) {
        this.los = los;
    }

    public Integer getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(Integer noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public Long getCmRoomId() {
        return cmRoomId;
    }

    public void setCmRoomId(Long cmRoomId) {
        this.cmRoomId = cmRoomId;
    }

    public String getCmRoomTypeString() {
        return cmRoomTypeString;
    }

    public void setCmRoomTypeString(String cmRoomTypeString) {
        this.cmRoomTypeString = cmRoomTypeString;
    }

    public Integer getRoomType() {
        return roomType;
    }

    public void setRoomType(Integer roomType) {
        this.roomType = roomType;
    }

    public Long getRateId() {
        return rateId;
    }

    public void setRateId(Long rateId) {
        this.rateId = rateId;
    }

    public Long getRatePlan() {
        return ratePlan;
    }

    public void setRatePlan(Long ratePlan) {
        this.ratePlan = ratePlan;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Float getRateValue() {
        return rateValue;
    }

    public void setRateValue(Float rateValue) {
        this.rateValue = rateValue;
    }

    public Date getPriceDate() {
        return priceDate;
    }

    public void setPriceDate(Date priceDate) {
        this.priceDate = priceDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public Double getTaxValue() {
        return taxValue;
    }

    public void setTaxValue(Double taxValue) {
        this.taxValue = taxValue;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(Double netAmount) {
        this.netAmount = netAmount;
    }

    public Integer getTotalGuests() {
        return totalGuests;
    }

    public void setTotalGuests(Integer totalGuests) {
        this.totalGuests = totalGuests;
    }

    public Integer getTotalAdults() {
        return totalAdults;
    }

    public void setTotalAdults(Integer totalAdults) {
        this.totalAdults = totalAdults;
    }

    public Integer getTotalChildren() {
        return totalChildren;
    }

    public void setTotalChildren(Integer totalChildren) {
        this.totalChildren = totalChildren;
    }

    public Integer getNoOfExtraAdults() {
        return noOfExtraAdults;
    }

    public void setNoOfExtraAdults(Integer noOfExtraAdults) {
        this.noOfExtraAdults = noOfExtraAdults;
    }

    public Double getExtraAdultRate() {
        return extraAdultRate;
    }

    public void setExtraAdultRate(Double extraAdultRate) {
        this.extraAdultRate = extraAdultRate;
    }

    public Integer getNoOfExtraChildren() {
        return noOfExtraChildren;
    }

    public void setNoOfExtraChildren(Integer noOfExtraChildren) {
        this.noOfExtraChildren = noOfExtraChildren;
    }

    public Double getExtraChildrenRate() {
        return extraChildrenRate;
    }

    public void setExtraChildrenRate(Double extraChildrenRate) {
        this.extraChildrenRate = extraChildrenRate;
    }

    public String getAddon() {
        return addon;
    }

    public void setAddon(String addon) {
        this.addon = addon;
    }

    public Double getAddonRate() {
        return addonRate;
    }

    public void setAddonRate(Double addonRate) {
        this.addonRate = addonRate;
    }

    public Date getRegdateRate() {
        return regdateRate;
    }

    public void setRegdateRate(Date regdateRate) {
        this.regdateRate = regdateRate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApiResponse() {
        return apiResponse;
    }

    public void setApiResponse(String apiResponse) {
        this.apiResponse = apiResponse;
    }
}
