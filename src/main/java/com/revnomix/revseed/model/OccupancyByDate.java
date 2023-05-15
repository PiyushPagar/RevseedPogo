package com.revnomix.revseed.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NamedNativeQueries({






})


@SqlResultSetMappings({


})

@Entity
@Table(name = "Occupancy_By_Date")
public class OccupancyByDate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "client_Id")
    private int clientId;
    @Column(name = "hotel_Id")
    private int hotelId;
    @Column(name = "ota_Id")
    private int otaId;
    @Column(name = "occupancy_Date")
    private Date occupancyDate;
    @Column(name = "cm_Id")
    private int cmId;
    @Column(name = "cm_Room_Id")
    private Long cmRoomId;
    @Column(name = "total_Amount")
    private double totalAmount;
    @Column(name = "net_Amount")
    private double netAmount;
    @Column(name = "adr")
    private double adr;
    @Column(name = "no_Of_Rooms")
    private int noOfRooms;
    @Column(name = "arrivals")
    private int arrivals;
    @Column(name = "departures")
    private int departures;
    @Column(name = "last_update")
    private Date lastUpdate;

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getOtaId() {
        return otaId;
    }

    public void setOtaId(int otaId) {
        this.otaId = otaId;
    }

    public Date getOccupancyDate() {
        return occupancyDate;
    }

    public void setOccupancyDate(Date occupancyDate) {
        this.occupancyDate = occupancyDate;
    }

    public int getCmId() {
        return cmId;
    }

    public void setCmId(int cmId) {
        this.cmId = cmId;
    }

    public Long getCmRoomId() {
        return cmRoomId;
    }

    public void setCmRoomId(Long cmRoomId) {
        this.cmRoomId = cmRoomId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(double netAmount) {
        this.netAmount = netAmount;
    }

    public double getAdr() {
        return adr;
    }

    public void setAdr(double adr) {
        this.adr = adr;
    }

    public int getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(int noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public int getArrivals() {
        return arrivals;
    }

    public void setArrivals(int arrivals) {
        this.arrivals = arrivals;
    }

    public int getDepartures() {
        return departures;
    }

    public void setDepartures(int departures) {
        this.departures = departures;
    }

}
