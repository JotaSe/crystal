package com.jotase.crystalsystem.models;
// Generated Jul 4, 2015 1:37:22 PM by Hibernate Tools 3.6.0


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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 * Costumers generated by hbm2java
 */
@Entity
@Table(name="costumers"
    ,catalog="cristal"
    , uniqueConstraints = @UniqueConstraint(columnNames="rif") 
)
public class Costumers  implements java.io.Serializable {


     private Integer id;
     @NotNull (message = "Debe asignarle un nombre")
     private String name;
     @NotNull (message = "Debe asignarle un numero telefonico")
     private String telephone;
     @NotNull (message = "Debe asignarle el RIF")
     private String rif;
     @NotNull (message = "Debe asignarle una direccion")
     private String address;
     private Set budgets = new HashSet(0);

    public Costumers() {
    }

	
    public Costumers(String name, String telephone, String rif) {
        this.name = name;
        this.telephone = telephone;
        this.rif = rif;
    }
    public Costumers(String name, String telephone, String rif, String address, Set budgets) {
       this.name = name;
       this.telephone = telephone;
       this.rif = rif;
       this.address = address;
       this.budgets = budgets;
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

    
    @Column(name="telephone", nullable=false, length=45)
    public String getTelephone() {
        return this.telephone;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    
    @Column(name="rif", unique=true, nullable=false, length=45)
    public String getRif() {
        return this.rif;
    }
    
    public void setRif(String rif) {
        this.rif = rif;
    }

    
    @Column(name="address", length=45)
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="costumers")
    public Set getBudgets() {
        return this.budgets;
    }
    
    public void setBudgets(Set budgets) {
        this.budgets = budgets;
    }




}

