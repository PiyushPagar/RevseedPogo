package com.revnomix.revseed.model;

import com.revnomix.revseed.wrapper.OverrideFinalDto;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NamedNativeQueries({
        @NamedNativeQuery(
                name = "OverrideFinal.getLatestFinalValue",
                query = " SELECT * FROM "+
                        "(SELECT *, ROW_NUMBER() OVER(PARTITION BY checkin_date  ORDER BY update_date DESC ) AS RowNumberRank "+
                        " FROM recommendations_final_by_date "+
                        " WHERE client_id = :clientId AND checkin_date >= :startDate AND checkin_date <= :endDate) "+
                        " AS B WHERE RowNumberRank = 1 ",
                resultClass= OverrideFinalDto.class,
                resultSetMapping = "OverrideFinalDtoMapping"
        )
})

@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "OverrideFinalDtoMapping",
                classes = {
                        @ConstructorResult(
                                targetClass = OverrideFinalDto.class,
                                columns = {
                                        @ColumnResult(name = "id", type = Integer.class),
                                        @ColumnResult(name = "hotel_id", type = Integer.class),
                                        @ColumnResult(name = "client_id", type = Integer.class),
                                        @ColumnResult(name = "room_id", type = Integer.class),
                                        @ColumnResult(name = "update_date", type = Date.class),
                                        @ColumnResult(name = "checkin_date", type = Date.class),
                                        @ColumnResult(name = "final_rate",type = Float.class),
                                }
                        )
                }
        ),
})
@Table(name = "recommendations_final_by_date")
@Entity
public class OverrideFinal implements Serializable {
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
    @Column(name="update_date")
    private Date updateDate;
    @Column(name="final_rate")
    private Float finalRate;

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

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Float getFinalRate() {
        return finalRate;
    }

    public void setFinalRate(Float finalRate) {
        this.finalRate = finalRate;
    }
}
