package com.revnomix.revseed.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "accounts")
@Getter
@Setter
public class Accounts implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;

    @Column(name = "account_fname")
    private String accountFirstName;

    @Column(name = "account_lname")
    private String accountLastName;

    @Column(name = "account_address1")
    private String address1;

    @Column(name = "account_address2")
    private String address2;

    @Column(name = "account_mobile1")
    private String mobile1;

    @Column(name = "account_mobile2")
    private String mobile2;

    @Column(name = "account_city")
    private String city;

    @Column(name = "account_state")
    private String state;

    @Column(name = "account_email")
    private String email;

    @Column(name = "account_password")
    private String password;

    @Column(name = "account_status")
    private String status;

    @Column(name = "account_regdate")
    private Date regdate;

    @Column(name = "account_author")
    private String author;

    @Column(name = "account_position")
    private String position;

    @Column(name = "client_id")
    private Integer clientId;

    @ElementCollection
    @CollectionTable(name = "account_property" ,joinColumns = @JoinColumn(name = "account_id"))
    @Column(name = "property_id")
    private List<Integer> propertyIds;

	/*
	 * @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	 * 
	 * @Access(AccessType.FIELD)
	 * 
	 * @JoinTable(name = "ACCOUNT_ROLE", joinColumns = {@JoinColumn(name =
	 * "account_id")}, inverseJoinColumns = {
	 * 
	 * @JoinColumn(name = "role_id")})
	 * 
	 * @JsonBackReference private Set<AccountRole> roles = new HashSet<>();
	 */

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CREATED_DATE", updatable = false)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="UPDATED_DATE")
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

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountFirstName() {
        return accountFirstName;
    }

    public void setAccountFirstName(String accountFirstName) {
        this.accountFirstName = accountFirstName;
    }

    public String getAccountLastName() {
        return accountLastName;
    }

    public void setAccountLastName(String accountLastName) {
        this.accountLastName = accountLastName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getMobile1() {
        return mobile1;
    }

    public void setMobile1(String mobile1) {
        this.mobile1 = mobile1;
    }

    public String getMobile2() {
        return mobile2;
    }

    public void setMobile2(String mobile2) {
        this.mobile2 = mobile2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String isStatus() {
        return status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

	/*
	 * public Set<AccountRole> getRoles() { return roles; }
	 * 
	 * public void setRoles(Set<AccountRole> roles) { this.roles = roles; }
	 */
}
