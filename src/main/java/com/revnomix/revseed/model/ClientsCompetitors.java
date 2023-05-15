package com.revnomix.revseed.model;

import javax.persistence.*;
@Table(name = "clients_competitors")
@Entity
public class ClientsCompetitors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    @Column(name = "client_Id")
    private int clientId;
    @Column(name = "hotel_Id")
    private int hotelId;

    public int getClientId(){
        return clientId;
    }

    public void setClientId(int clientId){
        this.clientId=clientId;
    }

    public int getHotelId(){
        return hotelId;
    }

    public void setHotelId(int hotelId){
        this.hotelId=hotelId;
    }
}
