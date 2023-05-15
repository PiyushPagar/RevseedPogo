package com.revnomix.revseed.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Table(name = "property_parameters")
@Entity
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class Parameter implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "client_id")
    private Integer clientId;

    @Column(name = "param_type")
    private String paramType;

    @Column(name = "param_name")
    private String paramName;

    @Column(name = "param_value")
    private String paramValue;

    @Column(name = "mod_date")
    private Date modDate;

    @Column(name = "author")
    private String author;

    @Column(name = "ui_tag")
    private String uiTag;

    @Column(name = "ui_operator")
    private String uiOperator;

    @Column(name = "description")
    private String description;

}

