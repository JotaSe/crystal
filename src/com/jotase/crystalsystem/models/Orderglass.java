package com.jotase.crystalsystem.models;
// Generated Jul 4, 2015 1:37:22 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Orderglass generated by hbm2java
 */
@Entity
@Table(name="orderglass"
    ,catalog="cristal"
)
public class Orderglass  implements java.io.Serializable {


     private OrderglassId id;
     @NotNull (message = "No se ha asignado a un presupuesto")
     private Budget budget;
     @NotNull (message = "Debe asignarle una cantidad valida")
     private int qty;
     @NotNull (message = "Debe asignarle la altura")
     private int height;
     @NotNull (message = "Debe asignarle el ancho")
     private int width;
     @NotNull (message = "Debe asignarle el espesor")
     private int thickness;
     private String comments;
     @NotNull (message = "Debe asignarle el tipo")
     private String type;
     @NotNull (message = "El precio no ha sido asignado")
     private double price;
     private Boolean supplied;
     private Set glasseses = new HashSet(0);

    public Orderglass() {
    }

	
    public Orderglass(OrderglassId id, Budget budget, int qty, int height, int width, int thickness, String type, double price) {
        this.id = id;
        this.budget = budget;
        this.qty = qty;
        this.height = height;
        this.width = width;
        this.thickness = thickness;
        this.type = type;
        this.price = price;
    }
    public Orderglass(OrderglassId id, Budget budget, int qty, int height, int width, int thickness, String comments, String type, double price, Boolean supplied, Set glasseses) {
       this.id = id;
       this.budget = budget;
       this.qty = qty;
       this.height = height;
       this.width = width;
       this.thickness = thickness;
       this.comments = comments;
       this.type = type;
       this.price = price;
       this.supplied = supplied;
       this.glasseses = glasseses;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="id", column=@Column(name="id", nullable=false) ), 
        @AttributeOverride(name="budgetId", column=@Column(name="budget_id", nullable=false) ), 
        @AttributeOverride(name="budgetCostumersId", column=@Column(name="budget_costumers_id", nullable=false) ) } )
    public OrderglassId getId() {
        return this.id;
    }
    
    public void setId(OrderglassId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="budget_id", referencedColumnName="id", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="budget_costumers_id", referencedColumnName="costumers_id", nullable=false, insertable=false, updatable=false) } )
    public Budget getBudget() {
        return this.budget;
    }
    
    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    
    @Column(name="qty", nullable=false)
    public int getQty() {
        return this.qty;
    }
    
    public void setQty(int qty) {
        this.qty = qty;
    }

    
    @Column(name="height", nullable=false)
    public int getHeight() {
        return this.height;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }

    
    @Column(name="width", nullable=false)
    public int getWidth() {
        return this.width;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }

    
    @Column(name="thickness", nullable=false)
    public int getThickness() {
        return this.thickness;
    }
    
    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    
    @Column(name="comments", length=45)
    public String getComments() {
        return this.comments;
    }
    
    public void setComments(String comments) {
        this.comments = comments;
    }

    
    @Column(name="type", nullable=false, length=45)
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    
    @Column(name="price", nullable=false, precision=22, scale=0)
    public double getPrice() {
        return this.price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }

    
    @Column(name="supplied")
    public Boolean getSupplied() {
        return this.supplied;
    }
    
    public void setSupplied(Boolean supplied) {
        this.supplied = supplied;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="orderglass")
    public Set getGlasseses() {
        return this.glasseses;
    }
    
    public void setGlasseses(Set glasseses) {
        this.glasseses = glasseses;
    }




}

