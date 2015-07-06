package com.jotase.crystalsystem.models;
// Generated Jul 4, 2015 1:37:22 PM by Hibernate Tools 3.6.0


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name="user"
    ,catalog="cristal"
)
public class User  implements java.io.Serializable {


     private String id;
     private String password;

    public User() {
    }

    public User(String id, String password) {
       this.id = id;
       this.password = password;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false, length=45)
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    
    @Column(name="password", nullable=false, length=45)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }




}


