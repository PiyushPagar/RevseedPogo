package com.revnomix.revseed.model;

import com.revnomix.revseed.wrapper.QualityMetricsDto;

import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NamedNativeQueries({
        @NamedNativeQuery(
                name = "ClientsQM.getAllHotelsNameAndOtaNameByQualityMetrics",
                query = " SELECT c.id, c.hotel_id, c.client_id, c.ota, c.name AS qmName, c.parameter, c.hotel_score, c.max_score, c.quantity, h.name AS hotelName, o.name AS domain_name " +
                        " FROM clients_qm c "+
                        " INNER JOIN hotels h ON (c.hotel_id=h.id) "+
                        " INNER JOIN otas o ON (c.ota=o.id) "+
                        " WHERE c.client_id = :clientId ",
                resultClass=QualityMetricsDto.class,
                resultSetMapping = "QualityMetricsDtoMapping"
        )
})

@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "QualityMetricsDtoMapping",
                classes = {
                        @ConstructorResult(
                                targetClass = QualityMetricsDto.class,
                                columns = {
                                        @ColumnResult(name = "id", type = Integer.class),
                                        @ColumnResult(name = "hotel_id", type = Integer.class),
                                        @ColumnResult(name = "client_id", type = Integer.class),
                                        @ColumnResult(name = "ota", type = Integer.class),
                                        @ColumnResult(name = "qmName", type = String.class),
                                        @ColumnResult(name = "parameter", type = String.class),
                                        @ColumnResult(name = "hotel_score", type = Double.class),
                                        @ColumnResult(name = "max_score", type = Double.class),
                                        @ColumnResult(name = "quantity", type = Double.class),
                                        @ColumnResult(name = "hotelName",type = String.class),
                                        @ColumnResult(name = "domain_name",type = String.class),
                                }
                        )
                }
        ),
})
@Entity
@Table(name = "clients_qm")
public class ClientsQM implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="hotel_id")
    private Integer hotelId;
    
    @Column(name="client_id")
    private Integer clientId;

    @Column(name="ota")
    private Integer ota;

    @Column(name="name")
    private String name;

    @Column(name="parameter")
    private String parameter;

    @Column(name = "hotel_score")
    private double hotelScore;

    @Column(name = "max_score")
    private double maxScore;

    @Column(name = "quantity")
    private double quantity;

    @Column(name="regdate")
    private Date regDate;

    @Column(name="author")
    private Integer author;

    @Column(name="status")
    private String status;


    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getOta() {
        return ota;
    }

    public void setOta(Integer ota) {
        this.ota = ota;
    }



    public double getHotelScore() {
        return hotelScore;
    }

    public void setHotelScore(double hotelScore) {
        this.hotelScore = hotelScore;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public double getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(double maxScore) {
        this.maxScore = maxScore;
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

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

}
