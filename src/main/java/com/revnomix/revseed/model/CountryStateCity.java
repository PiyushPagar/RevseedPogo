/**
 * 
 */
package com.revnomix.revseed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "country_state_city")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CountryStateCity extends BaseEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private Integer id;
	
	@Column(name = "code",length = 50)
    private String code;
    
    @Column(name = "name",length = 150)
    private String name;
    
    @Column(name = "type",length = 50)
    private String type;
    
    @Column(name = "phone_code",length = 10)
    private String phoneCode;
    
    @Column(name = "currency",length = 10)
    private String currency;
    
    @Column(name = "status")
    private String status;
    
    //@Column(name="parent")
    //private Integer parent;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent")
    private CountryStateCity parentSts;
    
//    @JsonIgnore
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parentSts")
//    private Set<CountryStateCity> child = new HashSet<>();
}
