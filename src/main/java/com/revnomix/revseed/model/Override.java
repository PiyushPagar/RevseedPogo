package com.revnomix.revseed.model;

import com.revnomix.revseed.wrapper.OverrideDetailsDto;
import com.revnomix.revseed.wrapper.OverrideStrageyDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Override.getLatestOverrideValue",
                query = " SELECT * FROM "+
                        "(SELECT *, ROW_NUMBER() OVER(PARTITION BY checkin_date  ORDER BY overriden_date DESC ) AS RowNumberRank "+
                        " FROM recommendations_override_by_date "+
                        " WHERE client_id = :clientId AND active_override='active') "+
                        " AS B WHERE RowNumberRank = 1 and checkin_date >= :startDate and override_value > 0 ",
                resultClass=OverrideDetailsDto.class,
                resultSetMapping = "OverrideDetailsDtoMapping"
        ),
        @NamedNativeQuery(
                name = "Override.getOverrideHistory",
                query = "SELECT * FROM recommendations_override_by_date WHERE client_id= :clientId AND checkin_date = :occupancyDate order by checkin_date;",
                resultClass=OverrideDetailsDto.class,
                resultSetMapping = "OverrideDetailsDtoMapping"
        ),
        @NamedNativeQuery(
                name = "Override.getOverrideAlgoByDate",
                query = "SELECT od.checkin_date as checkinDate, od.override_algo as overrideAlgo, od.override_value as overrideValue " +
                        "FROM revseed.recommendations_override_by_date od " +
                        "where od.active_override = 'active' and od.client_id = :clientId and od.checkin_date " +
                        "between :fromDate and :toDate group by od.checkin_date, overrideAlgo, overrideValue; ",
                resultClass= OverrideStrageyDto.class,
                resultSetMapping = "OverrideStrageyDtoMapping"
        ),
        @NamedNativeQuery(
                name = "Override.getOverrideAlgoByDateUserOnly",
                query = "SELECT od.checkin_date as checkinDate, od.override_algo as overrideAlgo, od.override_value as overrideValue " +
                        "FROM revseed.recommendations_override_by_date od " +
                        "where od.active_override = 'active' and od.override_type = 'user' and od.override_algo= 'other' and od.client_id = :clientId and od.checkin_date " +
                        "between :fromDate and :toDate group by od.checkin_date, overrideAlgo, overrideValue; ",
                resultClass= OverrideStrageyDto.class,
                resultSetMapping = "OverrideStrageyDtoMapping"
        ),
        
})

@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "OverrideDetailsDtoMapping",
                classes = {
                        @ConstructorResult(
                                targetClass = OverrideDetailsDto.class,
                                columns = {
                                        @ColumnResult(name = "id", type = Integer.class),
                                        @ColumnResult(name = "hotel_id", type = Integer.class),
                                        @ColumnResult(name = "client_id", type = Integer.class),
                                        @ColumnResult(name = "room_id", type = Integer.class),
                                        @ColumnResult(name = "overriden_date", type = Date.class),
                                        @ColumnResult(name = "checkin_date", type = Date.class),
                                        @ColumnResult(name = "override_type", type = String.class),
                                        @ColumnResult(name = "override_algo", type = String.class),
                                        @ColumnResult(name = "active_override", type = String.class),
                                        @ColumnResult(name = "override_value",type = float.class),
                                        @ColumnResult(name = "overriden_by",type = Integer.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "OverrideStrageyDtoMapping",
                classes = {
                        @ConstructorResult(
                                targetClass = OverrideStrageyDto.class,
                                columns = {
                                        @ColumnResult(name = "checkinDate", type = Date.class),
                                        @ColumnResult(name = "overrideAlgo", type = String.class),
                                        @ColumnResult(name = "overrideValue",type = float.class),
                                }
                        )
                }
        )
})

@Table(name = "recommendations_override_by_date")
@Entity
public class Override implements Serializable {

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

    @Column(name="override_type")
    private String overrideType;

    @Column(name="overriden_date")
    private Date overridenDate;

    @Column(name="override_algo")
    private String overrideAlgo;

    @Column(name="active_override")
    private String activeOverride;

    @Column(name="override_value")
    private float overrideValue;
    
    @Column(name="overriden_by")
    private Integer overridenBy;

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

    public String getOverrideType() {
        return overrideType;
    }

    public void setOverrideType(String overrideType) {
        this.overrideType = overrideType;
    }



    public String getOverrideAlgo(String algo) {
        return overrideAlgo;
    }

    public void setOverrideAlgo(String overrideAlgo) {
        this.overrideAlgo = overrideAlgo;
    }

    public String getActiveOverride() {
        return activeOverride;
    }

    public void setActiveOverride(String activeOverride) {
        this.activeOverride = activeOverride;
    }

    public float getOverrideValue() {
        return overrideValue;
    }

    public void setOverrideValue(float overrideValue) {
        this.overrideValue = overrideValue;
    }


    public Date getOverridenDate() {
        return overridenDate;
    }

    public void setOverridenDate(Date overridenDate) {
        this.overridenDate = overridenDate;
    }

	public Integer getOverridenBy() {
		return overridenBy;
	}

	public void setOverridenBy(Integer overridenBy) {
		this.overridenBy = overridenBy;
	}
    
    
}
