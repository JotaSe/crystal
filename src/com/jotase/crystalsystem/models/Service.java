package com.jotase.crystalsystem.models;
// Generated Jul 15, 2015 1:51:53 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Service generated by hbm2java
 */
@Entity
@Table(name="service"
    ,catalog="cristal"
)
public class Service  implements java.io.Serializable {


     private Integer id;
     private String name;
     private Integer thickness;
     private Integer priceType;
     private Double cost;
     private Set orderglassHasServices = new HashSet(0);

    public Service() {
    }

	
    public Service(String name) {
        this.name = name;
    }
    public Service(String name, Integer thickness, Integer priceType, Double cost, Set orderglassHasServices) {
       this.name = name;
       this.thickness = thickness;
       this.priceType = priceType;
       this.cost = cost;
       this.orderglassHasServices = orderglassHasServices;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="name", nullable=false, length=45)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="thickness")
    public Integer getThickness() {
        return this.thickness;
    }
    
    public void setThickness(Integer thickness) {
        this.thickness = thickness;
    }

    
    @Column(name="priceType")
    public Integer getPriceType() {
        return this.priceType;
    }
    
    public void setPriceType(Integer priceType) {
        this.priceType = priceType;
    }

    
    @Column(name="cost", precision=22, scale=0)
    public Double getCost() {
        return this.cost;
    }
    
    public void setCost(Double cost) {
        this.cost = cost;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="service")
    public Set getOrderglassHasServices() {
        return this.orderglassHasServices;
    }
    
    public void setOrderglassHasServices(Set orderglassHasServices) {
        this.orderglassHasServices = orderglassHasServices;
    }




}


