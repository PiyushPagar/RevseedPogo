package com.revnomix.revseed.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@NamedNativeQueries({
@NamedNativeQuery(name ="Competitors.findAllHotelsForQM",
        query = "SELECT ho.id AS id, ho.rm_code AS rmCode, ho.name AS NAME, ho.address AS address, ho.city AS city, ho.city_Id AS cityId, " +
                "ho.state_id AS stateId, ho.state AS state, ho.zip AS zip, ho.country AS country,ho.country_id AS countryId, ho.latitude AS latitude, " +
                "ho.longitude AS longitude, ho.status AS STATUS, ho.regdate AS regDate, ho.author AS author, 0 AS distance " +
                "FROM ( " +
                "SELECT client_id, hotel_id FROM clients_competitors AS t1 " +
                "UNION " +
                "SELECT id AS client_id, hotel_id FROM clients AS t2) AS t3 " +
                "INNER JOIN hotels ho ON ho.id=hotel_id " +
                "WHERE client_id = :clientId",
        resultClass = Hotels.class,
        resultSetMapping = "hotels"),
@NamedNativeQuery(name ="Competitors.findAllCompetitorsForClient",
                query = "SELECT ho.id AS id, ho.rm_code AS rmCode, ho.name AS NAME, ho.address AS address, ho.city AS city, ho.city_Id AS cityId, " +
                        "ho.state_id AS stateId, ho.state AS state, ho.zip AS zip, ho.country AS country,ho.country_id AS countryId, ho.latitude AS latitude, " +
                        "ho.longitude AS longitude, ho.status AS STATUS, ho.regdate AS regDate, ho.author AS author, 0 AS distance " +
                        "FROM hotels AS ho " +
                        "INNER JOIN clients_competitors AS cc ON ho.id=cc.hotel_id " +
                        "WHERE client_id= :clientId ",
                resultClass = Hotels.class,
                resultSetMapping = "hotels"),
@NamedNativeQuery(name="Competitors.findAllSuggestedCompetitorsByDistance",
    query="SELECT ho.id as id, ho.rm_code as rmCode, ho.name as name, ho.address as address, ho.city as city, ho.city_Id as cityId, " +
            "ho.state_id as stateId, ho.state as state, ho.zip as zip, ho.country as country,ho.country_id as countryId, ho.latitude as latitude, " +
            "ho.longitude as longitude, ho.status as status, ho.regdate as regDate, ho.author as author, " +
            "( 3959 * ACOS( COS( RADIANS(h1.latitude) ) * COS( RADIANS( ho.latitude ) ) " +
            "* COS( RADIANS( ho.longitude ) - RADIANS(h1.longitude) ) + SIN( RADIANS(h1.latitude) ) * SIN(RADIANS(ho.latitude)) ) ) AS distance " +
            " FROM hotels h1 INNER JOIN clients c ON c.hotel_id = h1.id,hotels ho WHERE c.id=:clientId AND ( 3959 * ACOS( COS( RADIANS(h1.latitude) ) * COS( RADIANS( ho.latitude ) ) " +
            "* COS( RADIANS( ho.longitude ) - RADIANS(h1.longitude) ) + SIN( RADIANS(h1.latitude) ) * SIN(RADIANS(ho.latitude)) ) ) <=10",
        resultClass = Hotels.class,
        resultSetMapping = "hotels"
),
@NamedNativeQuery(name="Competitors.findClientsByHotelId",
query="SELECT * FROM revseed.clients WHERE id in (SELECT client_id FROM clients_competitors where hotel_id = :hotelId) \n",
    resultClass = Clients.class
)})
@SqlResultSetMapping(
        name = "hotels",
        classes = {
                @ConstructorResult(
                        targetClass = Hotels.class,
                        columns = {
                                @ColumnResult(name = "id", type=Integer.class),
                                @ColumnResult(name = "rmCode", type=Integer.class),
                                @ColumnResult(name = "name", type=String.class),
                                @ColumnResult(name = "address", type=String.class),
                                @ColumnResult(name = "city", type=String.class),
                                @ColumnResult(name = "cityId", type=Integer.class),
                                @ColumnResult(name = "stateId", type=Integer.class),
                                @ColumnResult(name = "state", type=String.class),
                                @ColumnResult(name = "zip", type=String.class),
                                @ColumnResult(name = "country", type=String.class),
                                @ColumnResult(name = "countryId", type=Integer.class),
                                @ColumnResult(name = "latitude", type=String.class),
                                @ColumnResult(name = "longitude", type=String.class),
                                @ColumnResult(name = "status",type=String.class),
                                @ColumnResult(name = "regDate", type= Date.class),
                                @ColumnResult(name = "author", type= Integer.class),
                                @ColumnResult(name = "distance", type= Float.class)
                        }
                )
        }
)







@Entity
@Table(name = "clients_competitors")
public class Competitors implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "client_id")
    private Integer clientId;
    @Column(name = "hotel_id")
    private  Integer hotelId;

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
}
