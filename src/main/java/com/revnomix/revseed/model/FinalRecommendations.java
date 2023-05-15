package com.revnomix.revseed.model;

import com.revnomix.revseed.wrapper.OverrideDetailsDto;

import javax.persistence.*;
import java.util.Date;


@NamedNativeQueries({
        @NamedNativeQuery(
                name = "FinalRecommendations.getLatestFinalRateByClientId",
                query = "SELECT f.checkin_date,IF(o.override_value IS NULL, f.final_rate,o.override_value) AS rate " +
                        " FROM recommendations_final_by_date f " +
                        " LEFT JOIN ( SELECT checkin_date, override_value FROM (SELECT checkin_date, override_value,RANK() OVER( ORDER BY overriden_date DESC ) AS rankNo FROM recommendations_override_by_date " +
                        " WHERE client_id = :clientId AND override_value > 0 AND checkin_date >= CURDATE() ) AS A WHERE rankNo=1 ) AS o  ON (f.checkin_date=o.checkin_date) " +
                        " WHERE f.client_id=:clientId AND f.final_rate > 0 " +
                        " AND f.update_date = (SELECT MAX(update_date) FROM recommendations_final_by_date WHERE client_id=:clientId AND update_date >= CURDATE() ) " ,

                resultClass= OverrideDetailsDto.class,
                resultSetMapping = "FinalRateDtoMapping"
        )
})

@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "FinalRateDtoMapping",
                classes = {
                        @ConstructorResult(
                                targetClass = OverrideDetailsDto.class,
                                columns = {

                                        @ColumnResult(name = "checkin_date", type = Date.class),
                                        @ColumnResult(name = "rate",type = float.class),
                                }
                        )
                }
        ),
})

@Table(name = "recommendations_final_by_date")
@Entity
public class FinalRecommendations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "client_Id")
    private Integer clientId;
    @Column(name = "hotel_Id")
    private Integer hotelId;
    @Column(name = "room_Id")
    private Integer roomId;
    @Column(name = "checkin_Date")
    private Date checkinDate;
    @Column(name = "final_Rate")
    private double finalRate;

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

    public double getFinalRate() {
        return finalRate;
    }

    public void setFinalRate(double finalRate) {
        this.finalRate = finalRate;
    }
}
