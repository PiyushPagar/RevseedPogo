package com.revnomix.revseed.model;

import com.revnomix.revseed.wrapper.StaahRateTypeDto;

import javax.persistence.*;
import java.util.Date;

@NamedNativeQueries({
        @NamedNativeQuery(
                name = "StaahRateTypes.findDistinctStaahRateTypes",
                query = "  select distinct name,staah_rate_id as staahRateId from staah_rate_types " +
                        " WHERE client_id = :clientId",
                resultClass = StaahRateTypeDto.class,
                resultSetMapping = "findDistinctStaahRateTypes"
        )
})


@SqlResultSetMappings({

        @SqlResultSetMapping(
                name = "findDistinctStaahRateTypes",
                classes = {
                        @ConstructorResult(
                                targetClass = StaahRateTypeDto.class,
                                columns = {
                                        @ColumnResult(name = "staahRateId",type = String.class),
                                        @ColumnResult(name = "name",type = String.class)
                                }
                        )
                }
        )
})


@Entity
@Table(name = "staah_rate_types")
public class StaahRateTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="client_id")
    private Integer clientId;
    @Column(name="staah_rate_id")
    private Long staahRateId;
    @Column(name="rate_id")
    private Long rateId;
    @Column(name="staah_room_id")
    private Long staahRoomId;
    private String name;
    @Column(name="regdate")
    private Date regDate;

    public Long getRateId() {
        return rateId;
    }

    public void setRateId(Long rateId) {
        this.rateId = rateId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public Long getStaahRateId() {
        return staahRateId;
    }

    public void setStaahRateId(Long staahRateId) {
        this.staahRateId = staahRateId;
    }

    public Long getStaahRoomId() {
        return staahRoomId;
    }

    public void setStaahRoomId(Long staahRoomId) {
        this.staahRoomId = staahRoomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}