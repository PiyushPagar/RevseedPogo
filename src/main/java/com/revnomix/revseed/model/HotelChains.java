package com.revnomix.revseed.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "hotelChains")
@Entity
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class HotelChains implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "client_id")
    private Integer clientId;

    @Column(name = "hotel_name")
    private String hotelName;

    @Access(AccessType.FIELD)
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private HotelChainStatus status;

    @Column(name = "description")
    private String description;
}
