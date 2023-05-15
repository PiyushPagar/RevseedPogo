package com.revnomix.revseed.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ms_role")
@Data
public class AccountRole implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", length = 255)
    private Integer roleId;

    @Column(name = "role_name", length = 255)
    private String name;

    @Column(name = "description", length = 255)
    private String description;
    
    @Column(name = "default_screen", length = 45)
    private String defaultScreen;
    
    @Column(name = "role_code", length = 45)
    private String roleCode;

    
	/*
	 * @ManyToMany(fetch = FetchType.LAZY)
	 * 
	 * @Access(AccessType.FIELD)
	 * 
	 * @JsonBackReference
	 * 
	 * @JoinTable(name = "ACCOUNT_ROLE", joinColumns = {@JoinColumn(name =
	 * "role_id")}, inverseJoinColumns = {@JoinColumn(name = "account_id")}) private
	 * Set<Accounts> accounts;
	 */

}