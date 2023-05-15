package com.revnomix.revseed.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.revnomix.revseed.wrapper.RateShopRoomTypeMappingDto;
import com.revnomix.revseed.wrapper.RoomTypeMappingsDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NamedNativeQueries({
        @NamedNativeQuery(name = "RoomTypeMappings.findAllRatesByClientIdAndRateDate",
                query = "SELECT capacity,client_id,h.hotel_id AS hotel_id,priority,rt.id AS rt_id,rt.author AS rt_author," +
                        "rts.id as id,rrt.name AS client_room_type, h.name AS hotel_name,rt.description as rt_description," +
                        "rt.name AS rt_name,rt.status AS rt_status,rts.status AS status,rt.name AS system_name,type,rt.regdate as rt_regdate" +
                        " FROM room_type_mappings AS rts INNER JOIN room_types AS rt ON rts.room_type_id = rt.id INNER JOIN " +
                        " (SELECT hotels.id AS hotel_id,hotels.name,hotels.address FROM clients_competitors AS cc RIGHT JOIN hotels ON hotels.id=hotel_id  " +
                        " WHERE client_id=:clientId OR hotels.id=(SELECT hotel_id FROM clients WHERE id =:clientId)) AS h ON h.hotel_id = rts.hotel_id " +
                        " INNER JOIN  rm_room_types AS rrt ON rrt.id= client_room_type",
                resultClass = RoomTypeMappingsDto.class,
                resultSetMapping = "roomHotelMapping"),
        @NamedNativeQuery(name = "RoomTypeMappings.findAllRatesMappings",
                query = "                         SELECT rrt.name as rt_name,rtm.type,rtm.room_type_id as rt_id FROM rm_room_types rrt \n" +
                        "                         INNER JOIN room_type_mappings rtm ON (rrt.id=rtm.room_type_id)",
                resultClass = RoomTypeMappingsDto.class,
                resultSetMapping = "roomHotelMapping1")}

)

@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "roomHotelMapping1",
                classes = {
                        @ConstructorResult(
                                targetClass = RoomTypeMappingsDto.class,
                                columns = {
                                		@ColumnResult(name = "rt_id", type = Integer.class),
                                        @ColumnResult(name = "rt_name", type = String.class),
                                        @ColumnResult(name = "type", type = String.class)                                       
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "roomHotelMapping",
                classes = {
                        @ConstructorResult(
                                targetClass = RoomTypeMappingsDto.class,
                                columns = {
                                        @ColumnResult(name = "capacity", type = Integer.class),
                                        @ColumnResult(name = "client_id", type = Integer.class),
                                        @ColumnResult(name = "hotel_id", type = Integer.class),
                                        @ColumnResult(name = "priority", type = Integer.class),
                                        @ColumnResult(name = "rt_id", type = Integer.class),
                                        @ColumnResult(name = "rt_author", type = Integer.class),
                                        @ColumnResult(name = "id", type = Integer.class),
                                        @ColumnResult(name = "client_room_type", type = String.class),
                                        @ColumnResult(name = "hotel_name", type = String.class),
                                        @ColumnResult(name = "rt_description", type = String.class),
                                        @ColumnResult(name = "rt_name", type = String.class),
                                        @ColumnResult(name = "rt_status", type = String.class),
                                        @ColumnResult(name = "status", type = String.class),
                                        @ColumnResult(name = "system_name", type = String.class),
                                        @ColumnResult(name = "type", type = String.class),
                                        @ColumnResult(name = "rt_regdate", type = Date.class)
                                }
                        )
                }
        )
})

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "room_type_mappings")
public class RoomTypeMappings implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    //@ManyToOne(fetch = FetchType.EAGER,cascade={CascadeType.ALL})
    //@JoinColumn(name = "room_type_id",referencedColumnName = "id",insertable = false,updatable = false,foreignKey = @javax.persistence.ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private Integer roomTypeId;

    @Column(name = "client_id")
    private Integer clientId;

    @Column(name = "client_room_type")
    private Long clientRoomType;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "type")
    private String type;

    @Column(name = "status")
    private String status;

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

    public Long getClientRoomType() {
        return clientRoomType;
    }

    public void setClientRoomType(Long clientRoomType) {
        this.clientRoomType = clientRoomType;
    }

    public Integer getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Integer roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
