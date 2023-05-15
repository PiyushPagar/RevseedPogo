package com.revnomix.revseed.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Property_Configuration")
public class PropertyConfiguration implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "property_name")
    private String propertyName;

    @Column(name = "staah_id")
    private Integer staahId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Integer getStaahId() {
        return staahId;
    }

    public void setStaahId(Integer staahId) {
        this.staahId = staahId;
    }
}