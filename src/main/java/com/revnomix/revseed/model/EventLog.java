package com.revnomix.revseed.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "event_log")
@Getter
@Setter
public class EventLog extends BaseEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "source")
    private String source;

    @Column(name = "username")
    private String username;

    @Column(name = "action")
    private String action;

    @Column(name = "message")
    private String message;

    @Column(name = "account_id")
    private Integer accountId;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "response", length = 5000)
    private String response;

    @Column(name = "client_id")
    private Integer clientId;

}
