package com.revnomix.revseed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class BookingStatusMapping extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "booking_status")
    private String bookingStatus;
    
    @Column(name = "channel_manager")
    private String channelManager;
    
    @Column(name = "is_active")
    private Boolean isActive;
    
    @Column(name = "status")
    private String status;
    
    
}
