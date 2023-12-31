/*
 * Created on 2023-08-29 ( 12:15:32 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.startsup.merchant.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;


/**
 * JPA entity class for "OrderItems"
 *
 * @author Telosys
 *
 */
@Entity
@Table(name="order_items", catalog="merchantdb" )
@IdClass(OrderItemsId.class)
public class OrderItems implements Serializable {

    private static final long serialVersionUID = 1L;

    public void setItems(Items items) {
        this.items = items;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    //--- ENTITY PRIMARY KEY
    @Id
    @Column(name="order_id", nullable=false)
    private Integer    orderId ;

    @Id
    @Column(name="item_id", nullable=false)
    private Integer    itemId ;

    //--- ENTITY DATA FIELDS 
    @Column(name="quantity", nullable=false)
    private Integer    quantity ;

    @Column(name="price", nullable=false)
    private Double     price ;

    @Column(name="total", nullable=false)
    private Double     total ;


    //--- ENTITY LINKS ( RELATIONSHIP )
    @ManyToOne
    @JoinColumn(name="item_id", referencedColumnName="id", insertable=false, updatable=false)
    @JsonIgnore
    private Items      items ; 

    @ManyToOne
    @JoinColumn(name="order_id", referencedColumnName="id", insertable=false, updatable=false)
    @JsonIgnore
    private Order      order ; 


    /**
     * Constructor
     */
    public OrderItems() {
		super();
    }
    
    //--- GETTERS & SETTERS FOR FIELDS
    public void setOrderId( Integer orderId ) {
        this.orderId = orderId ;
    }
    public Integer getOrderId() {
        return this.orderId;
    }

    public void setItemId( Integer itemId ) {
        this.itemId = itemId ;
    }
    public Integer getItemId() {
        return this.itemId;
    }

    public void setQuantity( Integer quantity ) {
        this.quantity = quantity ;
    }
    public Integer getQuantity() {
        return this.quantity;
    }

    public void setPrice( Double price ) {
        this.price = price ;
    }
    public Double getPrice() {
        return this.price;
    }

    public void setTotal( Double total ) {
        this.total = total ;
    }
    public Double getTotal() {
        return this.total;
    }

    //--- GETTERS FOR LINKS
    public Items getItems() {
        return this.items;
    } 

    public Order getOrder() {
        return this.order;
    } 

    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(orderId);
        sb.append("|");
        sb.append(itemId);
        sb.append("|");
        sb.append(quantity);
        sb.append("|");
        sb.append(price);
        sb.append("|");
        sb.append(total);
        return sb.toString(); 
    } 

}
