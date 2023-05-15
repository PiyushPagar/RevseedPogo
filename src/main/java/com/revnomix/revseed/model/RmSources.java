package com.revnomix.revseed.model;

import javax.persistence.*;

@Entity
@Table(name = "rm_source")
public class RmSources {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="website_code")
    private int websiteCode;

    private String name;

    public int getWebsiteCode(){
        return websiteCode;
    }

    public void setWebsiteCode(int websiteCode){
        this.websiteCode=websiteCode;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
