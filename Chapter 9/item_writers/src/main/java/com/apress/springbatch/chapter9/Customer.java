package com.apress.springbatch.chapter9;

public class Customer {
    private String firstName;
    private String middleInitial;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    
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
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        
        output.append(firstName + " " + middleInitial + ". " + lastName + "\n");
        output.append(address + "\n");
        output.append(city + ", " + state + "\n");
        output.append(zip);
        
        return output.toString();
    }
}
