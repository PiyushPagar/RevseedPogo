package com.revnomix.revseed.model;

import com.revnomix.revseed.wrapper.StaahRateTypeDto;
import com.revnomix.revseed.wrapper.StaahRoomTypeDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NamedNativeQueries({
        @NamedNativeQuery(
                name = "StaahRoomTypes.findStaahRoomTypeDetails",
                query = " SELECT sr.staah_id, sr.name AS roomTypeName, c.property_name AS hotelName,sr.system_room_type AS systemRoomType,sr.capacity,c.channel_manager AS source" +
                        " FROM staah_room_types sr " +
                        " INNER JOIN clients c ON c.id = sr.client_id " +
                        " WHERE sr.client_id = :clientId",
                resultClass = StaahRoomTypeDto.class,
                resultSetMapping = "StaahRoomTypeDtoMapping"
        ),
        @NamedNativeQuery(
                name = "StaahRoomTypes.findDistinctRoomTypes",
                query = " select staah_id as staahRoomId,name as staahRoomTypeName from staah_room_types where client_id= :clientId",
                resultClass = StaahRateTypeDto.class,
                resultSetMapping = "findDistinctRoomTypes"
        ),
        @NamedNativeQuery(
                 name = "StaahRoomTypes.getRateTypeByRoomTypeId",
                 query = "SELECT srt.name as ,staah_rate_id AS staahRateId,srt.staah_room_id AS staahRoomId,srmt.name AS staahRoomTypeName  FROM  staah_rate_types srt INNER JOIN staah_room_types srmt ON (srt.system_room_id=srmt.id and srt.client_Id= srmt.client_Id) " +
                         " WHERE srt.client_id= :clientId",
                 resultClass= StaahRoomTypeDto.class,
                 resultSetMapping = "getRateTypeByRoomTypeId"
        )
})


@SqlResultSetMappings({

        @SqlResultSetMapping(
                name = "StaahRoomTypeDtoMapping",
                classes = {
                        @ConstructorResult(
                                targetClass = StaahRoomTypeDto.class,
                                columns = {

                                        @ColumnResult(name = "staah_id",type = String.class),
                                        @ColumnResult(name = "hotelName",type = String.class),
                                        @ColumnResult(name = "roomTypeName",type = String.class),
                                        @ColumnResult(name = "systemRoomType",type = String.class),
                                        @ColumnResult(name = "capacity",type = Integer.class),
                                        @ColumnResult(name = "source",type = String.class),
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "getRateTypeByRoomTypeId",
                classes = {
                        @ConstructorResult(
                                targetClass = StaahRateTypeDto.class,
                                columns = {
                                        @ColumnResult(name = "staahRoomId", type = Long.class),
                                        @ColumnResult(name = "name", type = String.class),
                                        @ColumnResult(name = "staahRateId", type = Long.class),
                                        @ColumnResult(name = "staahRoomTypeName", type = String.class),


                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "findDistinctRoomTypes",
                classes = {
                        @ConstructorResult(
                                targetClass = StaahRateTypeDto.class,
                                columns = {
                                        @ColumnResult(name = "staahRoomId", type = String.class),
                                        @ColumnResult(name = "staahRoomTypeName", type = String.class),

                                }
                        )
                }
        )
})




@Entity
@Table(name = "staah_room_types")
public class StaahRoomTypes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="client_id")
    private Integer clientId;
    @Column(name="staah_id")
    private Long staahId;
    @Column(name="name")
    private String name;
    @Column(name="regdate")
    private Date regDate;
    @Column(name = "system_room_type")
    private String systemRoomType;
    @Column(name = "capacity")
    private Integer capacity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public Long getStaahId() {
        return staahId;
    }

    public void setStaahId(Long staahId) {
        this.staahId = staahId;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSystemRoomType() {
        return systemRoomType;
    }

    public void setSystemRoomType(String systemRoomType) {
        this.systemRoomType = systemRoomType;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
