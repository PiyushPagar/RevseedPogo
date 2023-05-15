package com.revnomix.revseed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "permissions")
public class Permissions extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "client_id")
    private Integer clientId; 
    
    @Column(name = "account_id")
    private Integer accountId;
    
    //@Column(name = "ui_layout_id")
    //private Integer uiLayoutId;
    
    @ManyToOne
    @JoinColumn(name="ui_layout_id")
    private UILayout uiLayoutId;
    
    @Column(name="is_editable")
    private Boolean isEditable;
    
    @Column(name="is_disable")
    private Boolean isDisable;
    
    @Column(name="is_predefined")
    private Boolean isPredefined;
    
    @Column(name="role_custom")
    private String roleCustom;
    
    @Column(name="status")
    private String status;
}
