package com.apress.springbatch.chapter10.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="orders")
public class Order implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Version
    private long version;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;
    private String creditCardNumber;
    private String expirationDate;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="order", fetch = FetchType.LAZY)
    private List<OrderItem> items;
    private Date placedOn;
    private Boolean creditValidated;
    
    public long getVersion() {
        return version;
    }
    public void setVersion(long version) {
        this.version = version;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public String getCreditCardNumber() {
        return creditCardNumber;
    }
    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
    public String getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
    public List<OrderItem> getItems() {
        return items;
    }
    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
    public Date getPlacedOn() {
        return placedOn;
    }
    public void setPlacedOn(Date placedOn) {
        this.placedOn = placedOn;
    }
    public boolean isCreditValidated() {
        return creditValidated;
    }
    public void setCreditValidated(boolean creditValidated) {
        this.creditValidated = creditValidated;
    }
}
