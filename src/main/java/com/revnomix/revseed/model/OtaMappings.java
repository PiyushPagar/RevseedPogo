package com.revnomix.revseed.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ota_mappings",uniqueConstraints={@UniqueConstraint(columnNames={"client_id","client_ota"})})
public class OtaMappings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "client_Id")
    private Integer clientId;
    @Column(name = "client_Ota")
    private String clientOta;
    @Column(name = "ota_id" , columnDefinition = "integer default 1")
    private Integer otaId = 1;
    @Column(name = "type")
    private String type;
    @Column(name = "regdate")
    private Date regdate;

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getOtaId() {
        return otaId;
    }

    public void setOtaId(Integer otaId) {
        this.otaId = otaId;
    }

    public String getClientOta() {
        return clientOta;
    }

    public void setClientOta(String clientOta) {
        this.clientOta = clientOta;
    }

//    public String getSystemName(){
//        return otaId.getName();
//    }

//    public String getClientOtaName(){
//        if(this.type.equalsIgnoreCase("rateshopping")){
//            return otaId.getDomainName() + " (ID: "+otaId.getId()+")";
//        }else
//            return otaId.getDomainName();
//    }

}

