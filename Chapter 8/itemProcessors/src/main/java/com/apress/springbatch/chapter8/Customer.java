package com.apress.springbatch.chapter8;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Customer {
    
    private long id;

    @NotNull
    @Pattern(regexp="[a-zA-Z]+")
    private String firstName;

    @Size(min=1, max=1)
    private String middleInitial;
    
    @NotNull
    @Pattern(regexp="[a-zA-Z]+")
    private String lastName;

    @NotNull
    @Pattern(regexp="[0-9a-zA-Z\\. ]+")
    private String address;
    
    @NotNull
    @Pattern(regexp="[a-zA-Z\\. ]+")
    private String city;

    @NotNull
    @Size(min=2,max=2)
    @Pattern(regexp="[A-Z]{2}")
    private String state;
    
    @NotNull
    @Size(min=5,max=5)
    @Pattern(regexp="\\d{5}")
    private String zip;
    
    private AccountExecutive accountExecutive;
    
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getMiddleInitial() {
        return middleInitial;
    }
    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getZip() {
        return zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }
    public AccountExecutive getAccountExecutive() {
        return accountExecutive;
    }
    public void setAccountExecutive(AccountExecutive accountExecutive) {
        this.accountExecutive = accountExecutive;
    }
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(firstName);
        output.append(" ");
        output.append(middleInitial);
        output.append(" ");
        output.append(lastName);
        output.append(" lives at ");
        output.append(address);
        output.append(" ");
        output.append(city);
        output.append(", ");
        output.append(state);
        output.append(" ");
        output.append(zip);
        output.append(" and has ");
        
        if(accountExecutive != null) {
            output.append(accountExecutive.getFirstName());
            output.append(" ");
            output.append(accountExecutive.getLastName());
            output.append(" as their account exec");
        } else {
            output.append("no account exec");
        }
        
        return output.toString();
    }
}
