package com.revnomix.revseed.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.revnomix.revseed.wrapper.CompetitorPricingDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NamedNativeQueries({
        @NamedNativeQuery(name= "Otas.findByIntegrationType",
            query = "    SELECT ot.* FROM otas  ot" +
                    "                             INNER JOIN ota_mappings otm ON otm.ota_id=ot.id " +
                    "                             WHERE TYPE= :type",
            resultClass = Otas.class
        ),

        @NamedNativeQuery(name= "Otas.findForBookings",
                query = "SELECT id,name,domain_name,regdate,status FROM otas WHERE id IN (SELECT DISTINCT(ota_id) FROM bookings WHERE client_id= :clientId) AND status ='active' OR id=10 ORDER BY NAME",
                resultClass = Otas.class,
                resultSetMapping = "otaMapping"
        ),
        @NamedNativeQuery(name= "Otas.findForBookingsForAllClients",
                query = "SELECT id,name,domain_name,regdate,status FROM otas WHERE id IN (SELECT DISTINCT(ota_id) FROM bookings) and status ='active' OR id=10 ORDER BY NAME",
                resultClass = Otas.class,
                resultSetMapping = "otaMapping"
        ),
        @NamedNativeQuery(name= "Otas.findByClientId",
                query = "SELECT distinct ota.* FROM ota_mappings otm INNER JOIN otas ota ON otm.ota_id= ota.id WHERE client_id= :clientId AND ota.STATUS ='active'",
                resultClass = Otas.class
        )
})
    @SqlResultSetMapping(
            name = "otaMapping",
            classes = {
                    @ConstructorResult(
                            targetClass = Otas.class,
                            columns = {
                                    @ColumnResult(name = "id", type = Integer.class),
                                    @ColumnResult(name = "name", type = String.class),
                                    @ColumnResult(name = "domain_name", type = String.class),
                                    @ColumnResult(name = "regdate", type = Date.class),
                                    @ColumnResult(name = "status", type = String.class),
                            }
                    )
            }
    )


@Entity
@Table(name = "otas")
public class Otas implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "domain_name")
    private String domainName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yy")
    @Column(name = "regdate")
    private Date regdate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author",referencedColumnName = "accountId",insertable = false,updatable = false,foreignKey = @javax.persistence.ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private Accounts accounts;

    @Column(name = "status")
    private String status;

    public Otas(Integer id, String name, String domainName, Date regdate,String status) {
        this.id = id;
        this.name = name;
        this.domainName = domainName;
        this.regdate = regdate;
        this.status = status;
    }
    public Otas(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @Transient
    public String getAuthorFname(){
        return accounts!=null?accounts.getAccountFirstName():"";
    }

    @Transient
    public String getAuthorLname(){
        return accounts!=null?accounts.getAccountLastName():"";
    }
}
