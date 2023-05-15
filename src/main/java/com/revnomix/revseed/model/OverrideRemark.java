package com.revnomix.revseed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "override_remark")
@Entity
@Data
public class OverrideRemark extends BaseEntity{
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="override_id")
    private Integer overrideId;
    
    @Column(name="remark_code")
    private String remarkCode;
    
    @Column(name="remark")
    private String remark;

}
