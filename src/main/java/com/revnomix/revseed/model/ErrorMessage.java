package com.revnomix.revseed.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class ErrorMessage  implements Serializable {

    private static final long serialVersionUID = -4990617176439462236L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String errorMessage;
    private Date createDate;
    private String payload;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Date getCreateDate() {
        if (createDate == null){
            createDate = new Date();
        }
        return createDate ;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}
