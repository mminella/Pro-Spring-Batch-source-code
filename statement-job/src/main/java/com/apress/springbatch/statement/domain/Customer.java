package com.apress.springbatch.statement.domain;

public class Customer {

    private long id = -1l;
    private String firstName;
    private String lastName;
    private Address address;
    private Account account;
    private String taxId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    @Override
    public String toString() {
        String output = "Customer number " + id + ", " + firstName + " " + lastName;
        
        if(address != null) {
            output = output + " who lives in "
                + address.getCity() + "," + address.getState();
        }
        
        if(account != null && account.getTransactions() != null) {
            output = output + " has "
            + account.getTransactions().size() + " transactions.";
        }

        return output;
    }
}
