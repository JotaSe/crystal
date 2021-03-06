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
import javax.persistence.UniqueConstraint;

/**
 * Customers generated by hbm2java
 */
@Entity
@Table(name="customers"
    ,catalog="cristal"
    , uniqueConstraints = @UniqueConstraint(columnNames="rif") 
)
public class Customers  implements java.io.Serializable {


     private Integer id;
     private String name;
     private String telephone;
     private String rif;
     private String address;
     private String email;
     private String contacto;
     private Set budgets = new HashSet(0);

    public Customers() {
    }

	
    public Customers(String name, String telephone, String rif, String contacto) {
        this.name = name;
        this.telephone = telephone;
        this.rif = rif;
        this.contacto = contacto;
    }
    public Customers(String name, String telephone, String rif, String address, String email, String contacto, Set budgets) {
       this.name = name;
       this.telephone = telephone;
       this.rif = rif;
       this.address = address;
       this.email = email;
       this.contacto = contacto;
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

    
    @Column(name="email", length=90)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="Contacto", nullable=false, length=45)
    public String getContacto() {
        return this.contacto;
    }
    
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="customers")
    public Set getBudgets() {
        return this.budgets;
    }
    
    public void setBudgets(Set budgets) {
        this.budgets = budgets;
    }




}


