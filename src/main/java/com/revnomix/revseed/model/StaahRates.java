package com.revnomix.revseed.model;

import com.revnomix.revseed.wrapper.RateDto;

import javax.persistence.*;
import java.util.Date;

// adding MAX(rate) for now
@NamedNativeQueries({
        @NamedNativeQuery(name =
                "StaahRates.findAllRatesByClientIdAndRateDate",
                query = " SELECT rateDate,rateOnCm,rate_plan  FROM ( \n"
                		+ "SELECT rate_date AS rateDate ,rate AS rateOnCm,srt.staah_rate_id  AS rate_plan \n"
                		+ "  FROM  staah_rates sr \n"
                		+ "INNER JOIN staah_rate_types srt ON (sr.rate_type_id=srt.id) \n"
                		+ "INNER JOIN clients c ON (c.id=sr.client_id) \n"
                		+ "WHERE sr.client_id= :clientId AND srt.staah_rate_id=c.cm_master_rate AND srt.staah_room_id=c.cm_master_room  \n"
                		+ "AND sr.rate_date >= :startDate AND sr.rate_date <= :endDate ) AS A GROUP BY rateDate,rateOnCM,rate_plan ORDER BY rateDate \n",
                resultClass = RateDto.class,
                resultSetMapping = "rateDtoMapping")
        })

@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "rateDtoMapping",
                classes = {
                        @ConstructorResult(
                                targetClass = RateDto.class,
                                columns = {
                                        @ColumnResult(name = "rateDate", type = Date.class),
                                        @ColumnResult(name = "rateOnCm", type = Double.class)
                                }
                        )
                }
        )
})

@Table(name = "Staah_Rates")
@Entity
public class StaahRates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "client_id")
    private Integer clientId;
    @Column(name = "room_Type_Id")
    private Integer roomTypeId;
    @Column(name = "rate_Type_id")
    private Integer rateTypeId;
    @Column(name = "rate")
    private Double rate;
    @Column(name = "rate_Date")
    private Date rateDate;
    @Column(name = "regdate")
    private Date regDate;

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

    public Integer getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public Integer getRateTypeId() {
        return rateTypeId;
    }

    public void setRateTypeId(int rateTypeId) {
        this.rateTypeId = rateTypeId;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Date getRateDate() {
        return rateDate;
    }

    public void setRateDate(Date rateDate) {
        this.rateDate = rateDate;
    }
}
