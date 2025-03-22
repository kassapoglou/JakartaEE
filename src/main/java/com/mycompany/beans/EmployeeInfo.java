package com.mycompany.beans;

import jakarta.enterprise.context.ConversationScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@ConversationScoped
public class EmployeeInfo implements Serializable {

  private String firstName;
         private String lastName;
         private String email;
         private String date;
         private String phoneNumber;
         private Double monthlySalary;
         private String dept;
         private String street_address;
         private String postal_code;
         private String city;
         private String state_province;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(Double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState_province() {
        return state_province;
    }

    public void setState_province(String state_province) {
        this.state_province = state_province;
    }

    @Override
    public String toString() {
        return "EmployeeInfo{" + 
                "firstName=" + 
                firstName + ", lastName=" 
                + lastName + ", email=" + 
                email + ", date=" + date + 
                ", phoneNumber=" + phoneNumber + 
                ", monthlySalary=" + monthlySalary + 
                ", dept=" + dept + ", street_address=" + 
                street_address + ", postal_code=" + 
                postal_code + ", city=" + city + 
                ", state_province=" + state_province + '}';
    }

}