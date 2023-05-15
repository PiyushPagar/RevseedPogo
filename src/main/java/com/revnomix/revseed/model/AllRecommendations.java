package com.revnomix.revseed.model;

import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.*;
import java.util.Date;

@NamedNativeQueries({
@NamedNativeQuery(name =
        "AllRecommendations.findAllRecommendationByClientIdAndCheckinDate",
        query = "SELECT rabd.* FROM recommendations_all_by_date rabd " +
                "                INNER JOIN (SELECT checkin_date,MAX(id) AS id FROM recommendations_all_by_date WHERE client_id= :clientId AND checkin_date >= :checkinDate GROUP BY checkin_date) AS A " +
                "                ON (rabd.id=A.id) " +
                "                WHERE rabd.client_id=:clientId AND rabd.checkin_date >= :checkinDate ",
        resultClass = AllRecommendations.class
),
@NamedNativeQuery(name =
"AllRecommendations.findAllRecommendationByClientIdAndCheckinDateSingleDate",
query = "SELECT rabd.* FROM recommendations_all_by_date rabd " +
        "                INNER JOIN (SELECT checkin_date,MAX(id) AS id FROM recommendations_all_by_date WHERE client_id= :clientId AND checkin_date = :checkinDate GROUP BY checkin_date) AS A " +
        "                ON (rabd.id=A.id) " +
        "                WHERE rabd.client_id=:clientId AND rabd.checkin_date = :checkinDate ",
resultClass = AllRecommendations.class
)
})

@Table(name = "recommendations_all_by_date")
@Entity
public class AllRecommendations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "client_Id")
    private Integer clientId;
    @Column(name = "hotel_Id")
    private Integer hotelId;
    @Column(name = "room_Id")
    private Integer roomId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yy")
    @Column(name = "checkin_Date")
    private Date checkinDate;
    @Column(name = "rate_Rcp")
    private Double rateRcp;
    @Column(name = "rate_Mpi")
    private Double rateMpi;
    @Column(name = "rate_Pqm")
    private Double ratePqm;
    @Column(name = "rate_Ari")
    private Double rateAri;

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

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Date getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }

    public Double getRateRcp() {
        return rateRcp;
    }

    public void setRateRcp(Double rateRcp) {
        this.rateRcp = rateRcp;
    }

    public Double getRateMpi() {
        return rateMpi;
    }

    public void setRateMpi(Double rateMpi) {
        this.rateMpi = rateMpi;
    }

    public Double getRatePqm() {
        return ratePqm;
    }

    public void setRatePqm(Double ratePqm) {
        this.ratePqm = ratePqm;
    }

    public Double getRateAri() {
        return rateAri;
    }

    public void setRateAri(Double rateAri) {
        this.rateAri = rateAri;
    }
}
