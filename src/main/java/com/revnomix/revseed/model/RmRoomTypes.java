package com.revnomix.revseed.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rm_room_types")
public class RmRoomTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="rm_id")
    private int rmId;
    private String name;
    private String slug;
    private String status;
    @Column(name="regdate")
    private Date regDate;

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRmId(){
        return rmId;
    }

    public void setRmId(int rmId){
        this.rmId=rmId;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getSlug(){
        return slug;
    }

    public void setSlug(String slug){
        this.slug=slug;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status=status;
    }
}
