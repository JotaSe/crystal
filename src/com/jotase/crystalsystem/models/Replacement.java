package com.jotase.crystalsystem.models;
// Generated Jul 4, 2015 1:37:22 PM by Hibernate Tools 3.6.0


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Replacement generated by hbm2java
 */
@Entity
@Table(name="replacement"
    ,catalog="cristal"
)
public class Replacement  implements java.io.Serializable {


     private ReplacementId id;
     @NotNull (message = "Debe asignarle un vidrio")
     private Glasses glasses;
     @NotNull (message = "Debe asignarle un estado")
     private Integer state;
     @NotNull (message = "Debe asignarle un comentario")
     private String comment;

    public Replacement() {
    }

	
    public Replacement(ReplacementId id, Glasses glasses) {
        this.id = id;
        this.glasses = glasses;
    }
    public Replacement(ReplacementId id, Glasses glasses, Integer state, String comment) {
       this.id = id;
       this.glasses = glasses;
       this.state = state;
       this.comment = comment;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="id", column=@Column(name="id", nullable=false) ), 
        @AttributeOverride(name="glassesId", column=@Column(name="glasses_id", nullable=false) ), 
        @AttributeOverride(name="glassesOrderGlassId", column=@Column(name="glasses_orderGlass_id", nullable=false) ), 
        @AttributeOverride(name="glassesOrderGlassBudgetId", column=@Column(name="glasses_orderGlass_budget_id", nullable=false) ), 
        @AttributeOverride(name="glassesOrderGlassBudgetCostumersId", column=@Column(name="glasses_orderGlass_budget_costumers_id", nullable=false) ) } )
    public ReplacementId getId() {
        return this.id;
    }
    
    public void setId(ReplacementId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="glasses_id", referencedColumnName="id", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="glasses_orderGlass_id", referencedColumnName="orderGlass_id", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="glasses_orderGlass_budget_id", referencedColumnName="orderGlass_budget_id", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="glasses_orderGlass_budget_costumers_id", referencedColumnName="orderGlass_budget_costumers_id", nullable=false, insertable=false, updatable=false) } )
    public Glasses getGlasses() {
        return this.glasses;
    }
    
    public void setGlasses(Glasses glasses) {
        this.glasses = glasses;
    }

    
    @Column(name="state")
    public Integer getState() {
        return this.state;
    }
    
    public void setState(Integer state) {
        this.state = state;
    }

    
    @Column(name="comment", length=100)
    public String getComment() {
        return this.comment;
    }
    
    public void setComment(String comment) {
        this.comment = comment;
    }




}

