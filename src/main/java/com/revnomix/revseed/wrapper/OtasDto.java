package com.revnomix.revseed.wrapper;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.revnomix.revseed.model.Otas;

public class OtasDto implements Serializable {
    private List<Otas> otas;
    private boolean status;
    private Integer id;
    private String name;
    private String domainName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yy")
    private Date regdate;
    private String statusStr;

    public void setOtas(List<Otas> otas) {
        this.otas = otas;
    }

    public List<Otas> getOtas() {
        return otas;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getStatusStr() {
		return statusStr;
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}
    
    
}
