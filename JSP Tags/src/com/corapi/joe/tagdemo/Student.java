package com.corapi.joe.tagdemo;

public class Student {

    private String firstName;
    private String lastName;
    private Boolean goldCustomer;

    public Student(String firstName, String lastName, Boolean goldCustomer) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.goldCustomer = goldCustomer;
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

    public Boolean getGoldCustomer() {
        return goldCustomer;
    }

    public void setGoldCustomer(Boolean goldCustomer) {
        this.goldCustomer = goldCustomer;
    }
}
