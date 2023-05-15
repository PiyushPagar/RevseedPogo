package com.revnomix.revseed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "on_demand_status")
public class OnDemandStatus extends BaseEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "client_id")
    private Integer clientId;

    @Column(name = "service_type")
    private String serviceType;

    @Column(name = "allow_run" , columnDefinition = "integer default 1")
    private Integer allowRun = 1;

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
    
    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Integer getAllowRun() {
        return allowRun;
    }

    public void setAllowRun(Integer allowRun) {
        this.allowRun = allowRun;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

}
