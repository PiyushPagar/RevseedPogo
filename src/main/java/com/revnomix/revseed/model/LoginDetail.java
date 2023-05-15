package com.revnomix.revseed.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "login_detail")
@Getter
@Setter
public class LoginDetail extends MasterBaseEntity {

    @Column(name = "account_id")
    private Integer accountId;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "check_in")
    private Date checkIn;

    @Column(name = "check_out")
    private Date checkOut;

    @Access(AccessType.FIELD)
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private RowStatus status;

    @Column(name = "note")
    private String note;
}
