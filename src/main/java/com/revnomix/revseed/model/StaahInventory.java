package com.revnomix.revseed.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="staah_inventory")
public class StaahInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="client_id")
    private Integer clientId;
    @Column(name="inv_date")
    private Date invDate;
    @Column(name="room_type_id")
    private Integer roomTypeId;
    @Column(name="availability")
    private Integer availability;
    @Column(name="regdate")
    private Date regDate;

    @Column(name="description")
    private String description;

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

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public Date getInvDate() {
        return invDate;
    }

    public void setInvDate(Date invDate) {
        this.invDate = invDate;
    }

    public Integer getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public Integer getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
