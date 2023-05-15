package com.revnomix.revseed.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "application_parameters")
public class ApplicationParameters {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "code")
    private String code;
	
	@Column(name = "code_desc")
    private String codeDesc;
	
	@Column(name = "short_desc")
    private String shortDesc;
	
	@Column(name = "parent_code")
    private String parentCode;
	
	@Column(name = "code_type")
    private String codeType;
	
	@Column(name = "status")
    private Boolean status;
	
    @Column(name = "created_by")
    private Long createdBy;
    
    @Column(name = "created_at")
    private Date createdAt;
    
    @Column(name = "updated_by")
    private Long updatedBy;
    
    @Column(name= "updated_at")
    private Date updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodeDesc() {
		return codeDesc;
	}

	public void setCodeDesc(String codeDesc) {
		this.codeDesc = codeDesc;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String toString() {
		return "ApplicationParameters [id=" + id + ", code=" + code + ", codeDesc=" + codeDesc + ", shortDesc="
				+ shortDesc + ", parentCode=" + parentCode + ", codeType=" + codeType + ", status=" + status
				+ ", createdBy=" + createdBy + ", createdAt=" + createdAt + ", updatedBy=" + updatedBy + ", updatedAt="
				+ updatedAt + "]";
	}

	public ApplicationParameters() {
		
	}
	
	public ApplicationParameters(Long id, String code, String codeDesc, String shortDesc, String parentCode,
			String codeType, Boolean status, Long createdBy, Date createdAt, Long updatedBy, Date updatedAt) {
		super();
		this.id = id;
		this.code = code;
		this.codeDesc = codeDesc;
		this.shortDesc = shortDesc;
		this.parentCode = parentCode;
		this.codeType = codeType;
		this.status = status;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.updatedBy = updatedBy;
		this.updatedAt = updatedAt;
	}
    
    
}
