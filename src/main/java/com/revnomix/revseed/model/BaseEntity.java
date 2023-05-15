package com.revnomix.revseed.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@JsonIgnoreProperties(
		value = {"createdDate", "updatedDate", "version"},
		allowGetters = true
)
@Getter
@Setter
@Accessors(chain = true)
public class BaseEntity {

	private static final long serialVersionUID = 1963086204985183449L;

	/*
	 * @Version
	 * 
	 * @Access(AccessType.FIELD)
	 * 
	 * @Column(name = "VERSION") private Integer version;
	 */

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", nullable = false, updatable = false)
	@CreatedDate
	private Date createdDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_DATE", nullable = false)
	@LastModifiedDate
	private Date updatedDate;

	@PreUpdate
	public void setPreUpdateEntity() {
		this.updatedDate = new Date();
	}

	@PrePersist
	public void setPrePersistEntity() {
		this.createdDate = new Date();
		this.updatedDate = new Date();
	}


}
