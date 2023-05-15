package com.revnomix.revseed.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.revnomix.revseed.wrapper.CompetitorPricingDto;
import com.revnomix.revseed.wrapper.RateShopDto;
import com.revnomix.revseed.wrapper.RmRatesDto;
import com.revnomix.revseed.wrapper.analysis.CompetitorPricingAnalysisDto;
import com.revnomix.revseed.wrapper.analysis.OTAByCategoriesDto;
import com.revnomix.revseed.wrapper.analysis.RangeByCategoriesDto;

@NamedNativeQueries({
        @NamedNativeQuery(name =
                "RmRates.findAllCompetitorPricingByClientIdAndOccupancyDate",
                query = "SELECT checkin_date AS occupancyDate, MIN(mi) AS MIN,MAX(mi) AS MAX,AVG(mi)AS AVG\n" +
                        "FROM (\n" +
                        "SELECT checkin_date, hotel_id, MIN(onsite_rate) AS mi\n" +
                        "FROM (\n" +
                        "SELECT checkin_date, cc.hotel_id, onsite_rate,\n" +
                        "RANK() OVER (PARTITION BY cc.hotel_id,checkin_date ORDER BY date_collected DESC)AS RowNumberRank\n" +
                        "FROM rm_rates rmr\n" +
                        "INNER JOIN hotels h ON (h.rm_code=rmr.hotel_code)\n" +
                        "INNER JOIN clients_competitors cc ON (h.id=cc.hotel_id)\n" +
                        "WHERE checkin_date >= :startDate AND checkin_date <= :endDate\n" +
                        "AND rmr.currency = (select currency from clients c1 where c1.id= :clientId ) COLLATE utf8_unicode_ci\n" +
                        "AND onsite_rate > 0 AND cc.client_id= :clientId) F\n" +
                        "WHERE RowNumberRank =1\n" +
                        "GROUP BY hotel_id,checkin_date\n" +
                        "UNION\n" +
                        "SELECT checkin_date, hotel_id, MIN(onsite_rate) AS mi\n" +
                        "FROM (\n" +
                        "SELECT checkin_date, cc.hotel_id, onsite_rate,\n" +
                        "RANK() OVER (PARTITION BY cc.hotel_id,checkin_date ORDER BY date_collected DESC)AS RowNumberRank\n" +
                        "FROM rm_rates rmr\n" +
                        "INNER JOIN hotels h ON (h.rm_code=rmr.hotel_code)\n" +
                        "INNER JOIN clients cc ON (h.id=cc.hotel_id)\n" +
                        "WHERE checkin_date >= :startDate AND checkin_date <= :endDate\n" +
                        "AND cc.currency = rmr.currency COLLATE utf8_unicode_ci\n" +
                        "AND onsite_rate > 0 AND cc.id= :clientId) F\n" +
                        "WHERE RowNumberRank =1\n" +
                        "GROUP BY hotel_id,checkin_date) AS a\n" +
                        "GROUP BY checkin_date ORDER BY occupancyDate",
                resultClass = CompetitorPricingDto.class,
                resultSetMapping = "competitorPricingMapping"
        ),

        @NamedNativeQuery(name =
                "RmRates.findCompetitorPricingDtos",
                query = "SELECT checkin_date as occupancyDate, hotel_code as hotelCode, onsite_rate as onsiteRate \n"
                		+ "FROM rm_rates rmr WHERE onsite_rate > 0 AND checkin_date >= :startDate AND checkin_date <= :endDate \n"
                		+ "AND hotel_code in :hotelCode \n"
                		+ "AND rmr.currency = (select currency from clients c1 where c1.id= :clientId ) COLLATE utf8_unicode_ci ",
                resultClass = CompetitorPricingDto.class,
                resultSetMapping = "allCompetitorPricingMappingNew"
        ),
        
        @NamedNativeQuery(name =
        "RmRates.findMinAllCompetitorPricingByClientIdAndOccupancyDate",
        query = "SELECT * FROM ( SELECT  checkin_date AS occupancyDate,DATE_FORMAT(checkin_date, '%a') AS dow, IF(BR IS NULL , GR,BR) AS MIN ,hotelName AS NAME,id  FROM (\n" +
                "SELECT  id,hotelName,checkin_date,GROUP_CONCAT(IF(otaName='BOOKING.COM',minrate,NULL)) AS BR,\n" +
                "SUBSTRING_INDEX(GROUP_CONCAT( IF(otaName<>'BOOKING.COM',minrate,NULL) ORDER BY minrate ASC),',',1) AS GR\n" +
                "FROM (SELECT id, hotelName, otaName,checkin_date, MIN(onsite_rate) AS minRate, rate_date  FROM (\n" +
                "SELECT h.id,h.name AS hotelName, o.domain_name AS otaName, r.checkin_date, r.onsite_rate , r.rate_date, RANK() OVER\n" +
                "(PARTITION BY h.name,r.checkin_date ORDER BY date_collected DESC)AS RowNumberRank\n" +
                "FROM rm_rates r\n" +
                "INNER JOIN hotels h ON (h.rm_code=r.hotel_code)\n" +
                "INNER JOIN clients_competitors cc ON (h.id=cc.hotel_id)\n" +
                "INNER JOIN ota_mappings otam ON (r.ota_id=otam.id)\n" +
                "INNER JOIN otas o ON otam.ota_id = o.id\n" +
                "WHERE  cc.client_id= :clientId AND r.onsite_rate > 0 AND r.currency = \n" +
                "(SELECT currency FROM clients c1 WHERE  c1.id= :clientId ) \n" +
                "COLLATE utf8_unicode_ci AND checkin_date BETWEEN :startDate AND :endDate ) F \n" +
                "WHERE RowNumberRank =1\n" +
                "GROUP BY hotelName, otaName, checkin_date, rate_date ,id\n" +
                "ORDER BY rate_date) AS B  GROUP BY  hotelName,checkin_date,id\n" +
                ") final\n" +
                "UNION\n" +
                "SELECT  checkin_date AS occupancyDate,DATE_FORMAT(checkin_date, '%a') AS dow,\n" +
                "IF(BR IS NULL , GR,BR)    AS MIN ,hotelName AS NAME ,id FROM (\n" +
                "SELECT  id,hotelName,checkin_date,GROUP_CONCAT(IF(otaName='BOOKING.COM',minrate,NULL)) AS BR,\n" +
                "SUBSTRING_INDEX(GROUP_CONCAT( IF(otaName<>'BOOKING.COM',minrate,NULL) ORDER BY minrate ASC),',',1) AS GR\n" +
                "FROM (SELECT id, hotelName, otaName,checkin_date, MIN(onsite_rate) AS minRate, rate_date  FROM (\n" +
                "SELECT h.id,h.name AS hotelName, o.domain_name AS otaName, r.checkin_date, r.onsite_rate ,\n" +
                "r.rate_date, RANK() OVER (PARTITION BY h.name,r.checkin_date ORDER BY date_collected DESC)AS RowNumberRank\n" +
                "FROM rm_rates r\n" +
                "INNER JOIN hotels h ON (h.rm_code=r.hotel_code)\n" +
                "INNER JOIN clients c ON (h.id = c.hotel_id)\n" +
                "INNER JOIN ota_mappings otam ON (r.ota_id=otam.id)\n" +
                "JOIN otas o ON otam.ota_id = o.id\n" +
                "WHERE   c.id= :clientId AND r.onsite_rate > 0 AND c.currency = r.currency COLLATE utf8_unicode_ci AND\n" +
                "checkin_date BETWEEN :startDate AND :endDate ) F\n" +
                "WHERE RowNumberRank =1\n" +
                "GROUP BY hotelName, otaName, checkin_date, rate_date ,id\n" +
                "ORDER BY rate_date) AS B   GROUP BY  hotelName,checkin_date,id\n" +
                ") final  ) DATA ORDER BY occupancyDate, FIELD(NAME,:clientName) DESC",
        resultClass = CompetitorPricingDto.class,
        resultSetMapping = "minCompetitorPricingMapping"
),
        @NamedNativeQuery(name =
                "RmRates.findMinCompetitorsByClientIdAndOccupancyDate",
                query = " SELECT h.name,rr.checkin_date AS occupancyDate,rt.name AS categoryName,client_ota AS otaName,MIN(onsite_rate) AS MIN , rr.date_collected AS regDate " +
                        "   FROM rm_rates rr " +
                        "   INNER JOIN ota_mappings otam ON (rr.ota_id=otam.id) " +
                        "   INNER JOIN rm_room_types rmt ON (rmt.id = rr.room_type)  " +
                        "   INNER JOIN room_types rt ON (rt.id = rmt.rm_id)  " +
                        "   INNER JOIN hotels h ON (h.rm_code=rr.hotel_code)      " +
                        "             WHERE h.id IN (SELECT hotel_id FROM  clients_competitors cc WHERE cc.client_id= :clientId) AND otam.client_id= :clientId  AND rr.checkin_date >= :checkinDate  AND  rr.onsite_rate > 0 " +
                        "   GROUP BY h.name,rt.name,rr.checkin_date,client_ota,rr.date_collected",

                resultClass = CompetitorPricingDto.class,
                resultSetMapping = "competitorMapping"
        ),
        @NamedNativeQuery(name =
                "RmRates.findRangeByRoomTypeCategories",
                query = "SELECT DATE_FORMAT(checkin_date,'%d-%b')  AS occupancyDate, MIN(minRate) AS MIN,MAX(minRate) AS MAX FROM ( \n"
                		+ "SELECT checkin_date,minRate,hotelName FROM (SELECT id, hotelName, otaName,"
                		+ "checkin_date, MIN(onsite_rate) AS minRate, rate_date  FROM ( \n"
                		+ "SELECT h.id,h.name AS hotelName, o.domain_name AS otaName, r.checkin_date,"
                		+ " r.onsite_rate , r.rate_date, RANK() OVER (PARTITION BY  o.id,r.checkin_date ORDER BY date_collected DESC)AS RowNumberRank \n"
                		+ "FROM rm_rates r   \n"
                		+ "INNER JOIN hotels h ON (h.rm_code=r.hotel_code)  \n"
                		+ "INNER JOIN rm_room_types rmt ON (r.room_type=rmt.id)   \n"
                		+ "INNER JOIN clients_competitors cc ON (h.id=cc.hotel_id)     \n"
                		+ "INNER JOIN ota_mappings otam ON (r.ota_id=otam.id) \n"
                		+ "INNER JOIN otas o ON otam.ota_id = o.id    \n"
                		+ "WHERE rmt.rm_id= :roomTypeId AND cc.client_id=  :clientId AND r.onsite_rate > 0  AND checkin_date BETWEEN :startDate AND  :endDate  ) F     \n"
                		+ "WHERE RowNumberRank =1 \n"
                		+ "GROUP BY hotelName, otaName, checkin_date, rate_date ,id  \n"
                		+ "ORDER BY rate_date asc) AS d \n"
                		+ "UNION \n"
                		+ "SELECT checkin_date,minRate,hotelName FROM ( \n"
                		+ "SELECT id, hotelName, otaName,checkin_date, MIN(onsite_rate) AS minRate, rate_date  FROM ( \n"
                		+ "SELECT h.id,h.name AS hotelName, o.domain_name AS otaName, r.checkin_date, r.onsite_rate , r.rate_date,"
                		+ "RANK() OVER (PARTITION BY  o.id,r.checkin_date ORDER BY date_collected DESC)AS RowNumberRank \n"
                		+ "FROM rm_rates r    \r\n"
                		+ "INNER JOIN hotels h ON (h.rm_code=r.hotel_code)       \n"
                		+ "INNER JOIN rm_room_types rmt ON (r.room_type=rmt.id)   \n"
                		+ "INNER JOIN clients c ON (h.id = c.hotel_id)     \n"
                		+ "INNER JOIN ota_mappings otam ON (r.ota_id=otam.id) \n"
                		+ "INNER JOIN otas o ON otam.ota_id = o.id    \n"
                		+ "WHERE rmt.rm_id= :roomTypeId AND c.id=  :clientId AND r.onsite_rate > 0  AND checkin_date BETWEEN :startDate AND :endDate"
                		+ " ) F     \n"
                		+ "WHERE RowNumberRank =1  \n"
                		+ "GROUP BY hotelName, otaName, checkin_date, rate_date ,id \n"
                		+ "ORDER BY rate_date asc) as d \n"
                		+ ") AS D GROUP BY DATE_FORMAT(checkin_date,'%d-%b')",
                resultClass = RangeByCategoriesDto.class,
                resultSetMapping = "rangeByCategoriesDtoMapping"
        ),
        @NamedNativeQuery(name =
                "RmRates.findOTAByCategories",
                query = " SELECT name,DATE_FORMAT(checkin_date,'%Y-%m-%d') AS DATE, MIN(onsite_rate) AS MIN  FROM ( \n"
                		+ "SELECT ot.NAME AS name, rmr.checkin_date, rmr.onsite_rate , RANK() OVER (PARTITION BY ot.id,rmr.checkin_date ORDER BY date_collected DESC)AS RowNumberRank \n"
                		+ "FROM rm_rates rmr \n"
                		+ "INNER JOIN ota_mappings otm ON (rmr.ota_id=otm.id) \n"
                		+ "JOIN otas ot ON otm.ota_id = ot.id \n"
                		+ "INNER JOIN rm_room_types rmt ON (rmr.room_type=rmt.id) \n"
                		+ "INNER JOIN hotels h ON (h.rm_code=rmr.hotel_code) \n"
                		+ "INNER JOIN clients c ON (h.id = c.hotel_id)  \n"
                		+ "WHERE rmt.rm_id= :roomTypeId AND ot.id in (SELECT id FROM revseed.otas) AND c.id= :clientId AND rmr.onsite_rate > 0  \n"
                		+ "AND checkin_date BETWEEN :startDate AND  :endDate \n"
                		+ "GROUP BY ot.id,name,checkin_date,onsite_rate,date_collected \n"
                		+ ") F \n"
                		+ "WHERE RowNumberRank =1 \n"
                		+ "GROUP BY name, DATE \n"
                		+ "ORDER BY DATE  ",
                resultClass = OTAByCategoriesDto.class,
                resultSetMapping = "otaByCategoriesMapping"
        ),
        @NamedNativeQuery(name =
        "RmRates.findOTAByCategoriesOTA",
        query = "SELECT name,DATE_FORMAT(checkin_date,'%Y-%m-%d') AS DATE, MIN(onsite_rate) AS MIN  FROM ( \n"
        		+ "SELECT ot.NAME AS name, rmr.checkin_date, rmr.onsite_rate , RANK() OVER (PARTITION BY ot.id,rmr.checkin_date ORDER BY date_collected DESC)AS RowNumberRank \n"
        		+ "FROM rm_rates rmr \n"
        		+ "INNER JOIN ota_mappings otm ON (rmr.ota_id=otm.id) \n"
        		+ "JOIN otas ot ON otm.ota_id = ot.id  \n"
        		+ "INNER JOIN rm_room_types rmt ON (rmr.room_type=rmt.id) \n"
        		+ "INNER JOIN hotels h ON (h.rm_code=rmr.hotel_code)  \n"
        		+ "INNER JOIN clients c ON (h.id = c.hotel_id)  \n"
        		+ "WHERE rmt.rm_id= :roomTypeId AND ot.id in (SELECT id FROM revseed.otas) AND c.id= :clientId AND ot.id in (:otas) AND rmr.onsite_rate > 0 \n"
        		+ "AND checkin_date BETWEEN :startDate AND  :endDate  \n"
        		+ "GROUP BY ot.id,name,checkin_date,onsite_rate,date_collected \n"
        		+ ") F     \n"
        		+ "WHERE RowNumberRank =1 \n"
        		+ "GROUP BY name, DATE \n"
        		+ "ORDER BY DATE ",
        resultClass = OTAByCategoriesDto.class,
        resultSetMapping = "otaByCategoriesMapping"
        ),
        @NamedNativeQuery(name =
                "RmRates.findOTAByCategoriesByClientId",
                query = " SELECT name,DATE_FORMAT(checkin_date,'%Y-%m-%d') AS DATE, MIN(onsite_rate) AS MIN  FROM ( \n"
                		+ "SELECT ot.domain_name AS name, rmr.checkin_date, rmr.onsite_rate , RANK() OVER (PARTITION BY ot.id,rmr.checkin_date ORDER BY date_collected DESC)AS RowNumberRank  \n"
                		+ "FROM rm_rates rmr \n"
                		+ "INNER JOIN ota_mappings otm ON (rmr.ota_id=otm.id) \n"
                		+ "JOIN otas ot ON otm.ota_id = ot.id \n"
                		+ "INNER JOIN rm_room_types rmt ON (rmr.room_type=rmt.id) \n"
                		+ "INNER JOIN hotels h ON (h.rm_code=rmr.hotel_code) \n"
                		+ "INNER JOIN clients c ON (h.id = c.hotel_id)  \n"
                		+ "WHERE rmt.rm_id= :roomTypeId AND ot.id in (SELECT id FROM revseed.otas) AND c.id= :clientId AND rmr.onsite_rate > 0  \n"
                		+ "AND checkin_date BETWEEN :startDate AND  :endDate \n"
                		+ "GROUP BY ot.id,ot.domain_name,checkin_date,onsite_rate,date_collected \n"
                		+ ") F     \n"
                		+ "WHERE RowNumberRank =1 \n"
                		+ "GROUP BY name, DATE ",
                resultClass = OTAByCategoriesDto.class,
                resultSetMapping = "otaByCategoriesMapping"
        ),
        @NamedNativeQuery(name =
                "RmRates.findAllCompetitorByClientIdCategoryTypeId",
                query = " SELECT * FROM ( SELECT  checkin_date AS occupancyDate,DATE_FORMAT(checkin_date, '%a') AS dow, IF(BR IS NULL , GR,BR)    AS MIN ,hotelName AS NAME,id  FROM (  \n" +
                        "                                                 SELECT  id,hotelName,checkin_date,GROUP_CONCAT(IF(otaName='BOOKING.COM',minrate,NULL)) AS BR,SUBSTRING_INDEX(GROUP_CONCAT( IF(otaName<>'BOOKING.COM',minrate,NULL) ORDER BY minrate ASC),',',1) AS GR   \n" +
                        "                                                 FROM (SELECT id, hotelName, otaName,checkin_date, MIN(onsite_rate) AS minRate, rate_date  FROM (\n" +
                        "\t\t\t\t\t\t\tSELECT h.id,h.name AS hotelName, o.domain_name AS otaName, r.checkin_date, r.onsite_rate , r.rate_date, RANK() OVER (PARTITION BY o.id,h.name,r.checkin_date ORDER BY date_collected DESC)AS RowNumberRank \n" +
                        "                                                                         FROM rm_rates r    \n" +
                        "                                                                         INNER JOIN hotels h ON (h.rm_code=r.hotel_code)       \n" +
                        "                                                                         INNER JOIN rm_room_types rmt ON (r.room_type=rmt.id)  \t\t\t\t\t\t\t\t\t\t \n" +
                        "                                                                         INNER JOIN clients_competitors cc ON (h.id=cc.hotel_id)     \n" +
                        "                                                                         INNER JOIN ota_mappings otam ON (r.ota_id=otam.id) \n" +
                        "                                                                         INNER JOIN otas o ON otam.ota_id = o.id    \n" +
                        "                                                                         WHERE rmt.rm_id= :roomCategoryTypeId AND cc.client_id=  :clientId AND r.onsite_rate > 0 AND o.id in (:otas)  AND checkin_date BETWEEN :startDate AND  :endDate  ) F     \n" +
                        "                                                                         WHERE RowNumberRank =1                                                            \n" +
                        "                                                                         GROUP BY hotelName, otaName, checkin_date, rate_date ,id \n" +
                        "                                                                         ORDER BY rate_date) AS B  GROUP BY  hotelName,checkin_date,id\n" +
                        "                                                                          ) final    \n" +
                        "                                                 UNION      \n" +
                        "                                                 SELECT  checkin_date AS occupancyDate,DATE_FORMAT(checkin_date, '%a') AS dow, IF(BR IS NULL , GR,BR)    AS MIN ,hotelName AS NAME ,id FROM (  \n" +
                        "                                                SELECT  id,hotelName,checkin_date,GROUP_CONCAT(IF(otaName='BOOKING.COM',minrate,NULL)) AS BR,SUBSTRING_INDEX(GROUP_CONCAT( IF(otaName<>'BOOKING.COM',minrate,NULL) ORDER BY minrate ASC),',',1) AS GR  \n" +
                        "                                                 FROM (SELECT id, hotelName, otaName,checkin_date, MIN(onsite_rate) AS minRate, rate_date  FROM (\n" +
                        "\t\t\t\t\t\t\tSELECT h.id,h.name AS hotelName, o.domain_name AS otaName, r.checkin_date, r.onsite_rate , r.rate_date, RANK() OVER (PARTITION BY o.id,h.name,r.checkin_date ORDER BY date_collected DESC)AS RowNumberRank \n" +
                        "                                                                         FROM rm_rates r \n" +
                        "\t\t\t\t\t\t\t\t\tINNER JOIN hotels h ON (h.rm_code=r.hotel_code) \n" +
                        "\t\t\t\t\t\t\t\t\tINNER JOIN rm_room_types rmt ON (r.room_type=rmt.id)  \t\n" +
                        "                                                                         INNER JOIN clients c ON (h.id = c.hotel_id)  \n" +
                        "                                                                         INNER JOIN ota_mappings otam ON (r.ota_id=otam.id) \n" +
                        "                                                                         JOIN otas o ON otam.ota_id = o.id    \n" +
                        "                                                                         WHERE rmt.rm_id= :roomCategoryTypeId AND  c.id= :clientId AND r.onsite_rate > 0 AND checkin_date BETWEEN :startDate AND  :endDate AND o.id in (:otas) ) F     \n" +
                        "                                                                         WHERE RowNumberRank =1                                                            \n" +
                        "                                                                         GROUP BY hotelName, otaName, checkin_date, rate_date ,id \n" +
                        "                                                                         ORDER BY rate_date) AS B   GROUP BY  hotelName,checkin_date,id\n" +
                        "                                                                         \n" +
                        "                                                                         \n" +
                        "                                                                       ) final  ) DATA ORDER BY occupancyDate, FIELD(NAME,:clientName) DESC",
                resultClass = CompetitorPricingAnalysisDto.class,
                resultSetMapping = "allCompetitorByClientIdCategoryTypeId"
        ),
        @NamedNativeQuery(name =
                "RmRates.findAllCompetitorMinPricingByOta",
                query = "SELECT * FROM ( \n" +
                        "SELECT hotelName, otaName,checkin_date, MIN(onsite_rate) AS minRate, rate_date  FROM (  \n" +
                        "  SELECT h.name AS hotelName, o.domain_name AS otaName, r.checkin_date, r.onsite_rate , r.rate_date ,RANK() OVER (PARTITION BY h.name, r.checkin_date ORDER BY date_collected DESC)AS RowNumberRank \n" +
                        "                                                 FROM rm_rates r    \n" +
                        "                         INNER JOIN hotels h ON (h.rm_code=r.hotel_code) \n" +
                        "                         INNER JOIN ota_mappings otm ON (otm.id=r.ota_id) \n" +
                        "                                                 INNER JOIN otas o ON otm.ota_id = o.id   \n" +
                        "                                                 WHERE  checkin_date =  :startDate AND onsite_rate > 0 AND otm.type='RATESHOP' \n" +
                        "                                                 AND r.hotel_code IN (SELECT rm_code FROM clients_competitors cc INNER JOIN hotels h ON(cc.hotel_id=h.id)  \n" +
                        "                                                                                                    WHERE client_id= :clientId) ) F\n" +
                        "                                                 WHERE RowNumberRank=1\n" +
                        "                                                       GROUP BY hotelName, otaName, checkin_date, rate_date\n" +
                        "                                                 ORDER BY rate_date ) AS comp\n" +
                        "                                                \n" +
                        " UNION               \n" +
                        "SELECT hotelName, otaName,checkin_date, MIN(onsite_rate) AS minRate, rate_date  FROM (  \n" +
                        "  SELECT h.name AS hotelName, o.domain_name AS otaName, r.checkin_date, r.onsite_rate , r.rate_date ,RANK() OVER (PARTITION BY h.name, r.checkin_date ORDER BY date_collected DESC)AS RowNumberRank \n" +
                        "                                                 FROM rm_rates r   \n" +
                        "                         INNER JOIN hotels h ON (h.rm_code=r.hotel_code) \n" +
                        "                         INNER JOIN ota_mappings otm ON (otm.id=r.ota_id) \n" +
                        "                                                 INNER JOIN otas o ON otm.ota_id = o.id   \n" +
                        "                                                 WHERE  checkin_date =  :startDate AND onsite_rate > 0 AND otm.type='RATESHOP' \n" +
                        "                                                 AND r.hotel_code = :clientRmCode) F\n" +
                        "                                                 WHERE RowNumberRank=1\n" +
                        "                                                 GROUP BY hotelName, otaName, checkin_date, rate_date   \n" +
                        "                                                 ORDER BY rate_date" +
                        "   ",
                resultClass = RmRatesDto.class,
                resultSetMapping = "allCompetitorMinPricingByOta"
        ),
        @NamedNativeQuery(name =
        "RmRates.findOneCompetitorMinPricingByOta",
        query = "SELECT hotelName, otaName,checkin_date, MIN(onsite_rate) AS minRate, rate_date  FROM (   \n"
        		+ "SELECT h.name AS hotelName, o.domain_name AS otaName, r.checkin_date, r.onsite_rate , r.rate_date ,RANK() OVER (PARTITION BY h.name, r.checkin_date ORDER BY onsite_rate ASC)AS RowNumberRank  \n"
        		+ "FROM rm_rates r    \n"
        		+ "INNER JOIN hotels h ON (h.rm_code=r.hotel_code)  \n"
        		+ "INNER JOIN ota_mappings otm ON (otm.id=r.ota_id)  \n"
        		+ "INNER JOIN otas o ON otm.ota_id = o.id    \n"
        		+ "WHERE  checkin_date =  :startDate AND onsite_rate > 0 AND otm.type='RATESHOP'  \n"
        		+ "AND r.hotel_code = :clientRmCode) F \n"
        		+ "WHERE RowNumberRank=1 \n"
        		+ "GROUP BY hotelName, otaName, checkin_date, rate_date    \n"
        		+ "ORDER BY rate_date ",
        resultClass = RmRatesDto.class,
        resultSetMapping = "allCompetitorMinPricingByOta"
),
  @NamedNativeQuery(name = "RmRates.findByClientIdAndCheckinDate",
  query = "SELECT h.name as hotelName, '' as month , rmr.checkin_date as checkin,otas.name as websiteName,rmr.tax_type as tax,rmr.meal_inclusion_type as mealInclusionType, \n"
  		+ "srt.name as roomTypeDescription, rmr.rate_type as rateType,rmr.onsite_rate as onsiteRate,rmr.rate as netRate,rmr.currency as currency \n"
  		+ "FROM rm_rates rmr \n"
  		+ "INNER JOIN hotels h ON (h.rm_code=rmr.hotel_code) \n"
  		+ "JOIN clients c ON (h.id=c.hotel_id) \n"
  		+ "JOIN staah_room_types srt on srt.id = rmr.room_type \n"
  		+ "JOIN ota_mappings om on om.id = rmr.ota_id \n"
  		+ "JOIN otas otas on otas.id = om.ota_id \n"
  		+ "WHERE rmr.checkin_date >= :startDate AND rmr.checkin_date <= :endDate \n"
  		+ "AND rmr.onsite_rate > 0 AND c.id= :clientId AND rmr.date_collected > DATE_ADD( :currentDate  , INTERVAL -1 SECOND) \n"
  		+ "AND rmr.date_collected <  DATE_ADD( :currentDate  , INTERVAL 1 DAY) \n"
  		+ "AND h.id = COALESCE(:hotelId,h.id) AND otas.id = COALESCE(:otaId,otas.id) \n"
  		+ "union \n"
  		+ "SELECT h.name as hotelName, '' as month , rmr.checkin_date as checkin,otas.name as websiteName,rmr.tax_type as tax,rmr.meal_inclusion_type as mealInclusionType, \n"
  		+ "srt.name as roomTypeDescription, rmr.rate_type as rateType,rmr.onsite_rate as onsiteRate,rmr.rate as netRate,rmr.currency as currency \n"
  		+ "FROM rm_rates rmr \n"
  		+ "INNER JOIN hotels h ON (h.rm_code=rmr.hotel_code) \n"
  		+ "JOIN clients_competitors cc ON (h.id=cc.hotel_id) \n"
  		+ "JOIN staah_room_types srt on srt.id = rmr.room_type \n"
  		+ "JOIN ota_mappings om on om.id = rmr.ota_id \n"
  		+ "JOIN otas otas on otas.id = om.ota_id \n"
  		+ "WHERE rmr.checkin_date >= :startDate AND rmr.checkin_date <= :endDate \n"
  		+ "AND rmr.onsite_rate > 0 AND cc.client_id= :clientId AND rmr.date_collected > DATE_ADD( :currentDate  , INTERVAL -1 SECOND) \n"
  		+ "AND rmr.date_collected <  DATE_ADD( :currentDate  , INTERVAL 1 DAY) \n"
  		+ "AND h.id = COALESCE(:hotelId,h.id) AND otas.id = COALESCE(:otaId,otas.id) \n"
  		,resultClass = RateShopDto.class,
  resultSetMapping = "rateShopDto")
}
)
@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "competitorPricingMapping",
                classes = {
                        @ConstructorResult(
                                targetClass = CompetitorPricingDto.class,
                                columns = {
                                        @ColumnResult(name = "occupancyDate", type = Date.class),
                                        @ColumnResult(name = "min", type = Double.class),
                                        @ColumnResult(name = "max", type = Double.class),
                                        @ColumnResult(name = "avg", type = Double.class),
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "allCompetitorPricingMappingNew",
                classes = {
                        @ConstructorResult(
                                targetClass = CompetitorPricingDto.class,
                                columns = {
                                        @ColumnResult(name = "occupancyDate", type = Date.class),
                                        @ColumnResult(name = "hotelCode", type = String.class),
                                        @ColumnResult(name = "onsiteRate", type = Double.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "minCompetitorPricingMapping",
                classes = {
                        @ConstructorResult(
                                targetClass = CompetitorPricingDto.class,
                                columns = {
                                        @ColumnResult(name = "occupancyDate", type = Date.class),
                                        @ColumnResult(name = "min", type = Double.class),
                                        @ColumnResult(name = "name", type = String.class),
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "competitorMapping",
                classes = {
                        @ConstructorResult(
                                targetClass = CompetitorPricingDto.class,
                                columns = {
                                        @ColumnResult(name = "occupancyDate", type = Date.class),
                                        @ColumnResult(name = "min", type = Double.class),
                                        @ColumnResult(name = "name", type = String.class),
                                        @ColumnResult(name = "categoryName", type = String.class),
                                        @ColumnResult(name = "otaName", type = String.class),
                                        @ColumnResult(name = "regDate", type = Date.class),
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "rangeByCategoriesDtoMapping",
                classes = {
                        @ConstructorResult(
                                targetClass = RangeByCategoriesDto.class,
                                columns = {
                                        @ColumnResult(name = "occupancyDate", type = String.class),
                                        @ColumnResult(name = "min", type = Double.class),
                                        @ColumnResult(name = "max", type = Double.class),

                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "otaByCategoriesMapping",
                classes = {
                        @ConstructorResult(
                                targetClass = OTAByCategoriesDto.class,
                                columns = {
                                        @ColumnResult(name = "name", type = String.class),
                                        @ColumnResult(name = "date", type = String.class),
                                        @ColumnResult(name = "min", type = Double.class),

                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "allCompetitorByClientIdCategoryTypeId",
                classes = {
                        @ConstructorResult(
                                targetClass = CompetitorPricingAnalysisDto.class,
                                columns = {
                                        @ColumnResult(name = "occupancyDate", type = Date.class),
                                        @ColumnResult(name = "dow", type = String.class),
                                        @ColumnResult(name = "min", type = Double.class),
                                        @ColumnResult(name = "name", type = String.class),
                                        @ColumnResult(name = "id", type = Integer.class),

                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "allCompetitorMinPricingByOta",
                classes = {
                        @ConstructorResult(
                                targetClass = RmRatesDto.class,
                                columns = {
                                        @ColumnResult(name = "hotelName", type = String.class),
                                        @ColumnResult(name = "otaName", type = String.class),
                                        @ColumnResult(name = "minRate", type = Double.class),
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "rateShopDto",
                classes = {
                        @ConstructorResult(
                                targetClass = RateShopDto.class,
                                columns = {
                                        @ColumnResult(name = "hotelName", type = String.class),
                                        @ColumnResult(name = "checkin", type = Date.class),
                                        @ColumnResult(name = "month", type = String.class),
                                        @ColumnResult(name = "websiteName", type = String.class),
                                        @ColumnResult(name = "tax", type = String.class),
                                        @ColumnResult(name = "mealInclusionType", type = String.class),
                                        @ColumnResult(name = "roomTypeDescription", type = String.class),
                                        @ColumnResult(name = "rateType", type = String.class),
                                        @ColumnResult(name = "onsiteRate", type = Double.class),
                                        @ColumnResult(name = "netRate", type = Double.class),
                                        @ColumnResult(name = "currency", type = String.class),
                                }
                        )
                }
        )
})


@Entity
@Table(name = "rm_rates")
public class RmRates extends BaseEntity{

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yy")
    @Column(name = "rate_date")
    private Date rateDate;
    @Column(name = "ota_id")
    private Integer otaId;
    @Column(name = "hotel_code")
    private Integer hotelCode;
    @Column(name = "website_code")
    private Integer websiteCode;
    @Column(name = "los")
    private Integer los;
    @Column(name = "guest")
    private Integer guests;
    @Column(name = "rate")
    private Double rate;
    @Column(name = "onsite_rate")
    private Double onsiteRate;
    @Column(name = "currency")
    private String currency;
    @Column(name = "max_occupancy")
    private Integer maxOccupancy;
    @Column(name = "conditions_code")
    private Integer conditionsCode;
    @Column(name = "room_type")
    private Integer roomType;
    @Column(name = "rate_type")
    private String rateType;

    @Column(name = "tax_status")
    private Integer taxStatus;

    @Column(name = "rate_description")
    private String rateDescription;

    @Column(name = "tax_Included")
    private String taxIncluded;


    @Column(name = "tax_type")
    private String taxType;

    @Column(name = "meal_inclusion_type")
    private String mealInclusionType;

    @Column(name = "room_type_code")
    private Integer roomTypeCode;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yy")
    @Column(name = "checkin_date")
    private Date checkinDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yy")
    @Column(name = "checkout_date")
    private Date checkoutDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yy")
    @Column(name = "date_collected")
    private Date dateCollected;
    
    @Id
    private String uuid;

    public String getRateType() {
        return rateType;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public String getRateDescription() {
        return rateDescription;
    }

    public void setRateDescription(String rateDescription) {
        this.rateDescription = rateDescription;
    }

    public String getMealInclusionType() {
        return mealInclusionType;
    }

    public void setMealInclusionType(String mealInclusionType) {
        this.mealInclusionType = mealInclusionType;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Date getRateDate() {
        return rateDate;
    }

    public void setRateDate(Date rateDate) {
        this.rateDate = rateDate;
    }

    public Integer getOtaId() {
        return otaId;
    }

    public void setOtaId(Integer otaId) {
        this.otaId = otaId;
    }

    public Integer getRoomTypeCode() {
        return roomTypeCode;
    }

    public void setRoomTypeCode(Integer roomTypeCode) {
        this.roomTypeCode = roomTypeCode;
    }

    public Integer getHotelCode() {
        return hotelCode;
    }

    public void setHotelCode(Integer hotelCode) {
        this.hotelCode = hotelCode;
    }

    public Integer getWebsiteCode() {
        return websiteCode;
    }

    public void setWebsiteCode(Integer websiteCode) {
        this.websiteCode = websiteCode;
    }

    public Integer getLos() {
        return los;
    }

    public void setLos(Integer los) {
        this.los = los;
    }

    public Integer getGuests() {
        return guests;
    }

    public void setGuests(Integer guests) {
        this.guests = guests;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getOnsiteRate() {
        return onsiteRate;
    }

    public void setOnsiteRate(Double onsiteRate) {
        this.onsiteRate = onsiteRate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getMaxOccupancy() {
        return maxOccupancy;
    }

    public void setMaxOccupancy(Integer maxOccupancy) {
        this.maxOccupancy = maxOccupancy;
    }

    public Integer getConditionsCode() {
        return conditionsCode;
    }

    public void setConditionsCode(Integer conditionsCode) {
        this.conditionsCode = conditionsCode;
    }

    public Integer getRoomType() {
        return roomType;
    }

    public void setRoomType(Integer roomType) {
        this.roomType = roomType;
    }

    public Integer getTaxStatus() {
        return taxStatus;
    }

    public void setTaxStatus(Integer taxStatus) {
        this.taxStatus = taxStatus;
    }

    public String getTaxIncluded() {
        return taxIncluded;
    }

    public void setTaxIncluded(String taxIncluded) {
        this.taxIncluded = taxIncluded;
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

    public Date getDateCollected() {
        return dateCollected;
    }

    public void setDateCollected(Date dateCollected) {
        this.dateCollected = dateCollected;
    }
}
