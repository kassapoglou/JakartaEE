package com.mycompany.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "EMPLOYEES")
public class Employee implements Serializable {

    public Employee() {
    }

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employee_id;
    
    @Column(name = "emp_firstname", nullable = false)
    private String firstName;
    
    @Column(name = "emp_lastname", nullable = false)
    private String lastName;
    
    @Column(name = "emp_email")
    private String email;
    
    @Column(name = "emp_phone")
    private String phoneNumber;
    
    @Column(name = "emp_hiredate", nullable = false)
    private Date hireDate;
    
    @Column(name = "emp_salary", precision=0, nullable = false)
    private Double monthlySalary;
    
    @ManyToOne
    @JoinColumn(name="dept_id")
    private Department department;

    
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name="location_id",referencedColumnName = "location_id", unique=true)
    private Location address;

    public Location getAddress() {
        return address;
    }

    public void setAddress(Location address) {
        this.address = address;
    }

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(Double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}