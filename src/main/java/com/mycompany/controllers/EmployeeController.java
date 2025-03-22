package com.mycompany.controllers;

import com.mycompany.entities.Department;
import com.mycompany.entities.Employee;
import com.mycompany.services.DepartmentAssignment;
import com.mycompany.services.ITAssignment;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Default;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.HeuristicMixedException;
import jakarta.transaction.HeuristicRollbackException;
import jakarta.transaction.NotSupportedException;
import jakarta.transaction.RollbackException;
import jakarta.transaction.SystemException;
import jakarta.transaction.UserTransaction;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
@RequestScoped
public class EmployeeController {
    
         private String firstName;
         private String lastName;
         private String email;
         private String date;
         private String phoneNumber;
         private Double monthlySalary;
         private String dept;
         

    @PersistenceContext
    private EntityManager em;

    @Resource
    private UserTransaction userTransaction;


    private static final Logger logger = Logger.getLogger(
          EmployeeController.class.getName());
  
  
  @Inject
    @Default
    @ITAssignment
    DepartmentAssignment departmentAssignment;
  

  public String saveCustomer() {
      
      Employee employee = new Employee();
      Department department = new Department();
      
     if ("None".equals(dept)) {
            department.setDept_id(departmentAssignment.generateDepartment());
        } else {
            switch (dept) {
                case "HR" ->
                    department.setDept_id(1L);
                case "IT" ->
                    department.setDept_id(2L);
                case "Finance" ->
                    department.setDept_id(3L);
                case "Marketing" ->
                    department.setDept_id(4L);
                default -> {
                }
            }
        }

        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setMonthlySalary(monthlySalary);
        Date dt = null;
        try {
            dt = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        employee.setHireDate(dt);
        employee.setEmail(email);
        employee.setPhoneNumber(phoneNumber);
        employee.setDepartment(department);

        try {
            userTransaction.begin();
            em.persist(employee);
            userTransaction.commit();
            logger.log(Level.INFO, "Transaction has been completed with employee id: {0}", 
                                    employee.getEmployee_id());
        } catch (NotSupportedException
                | SystemException | RollbackException
                | HeuristicMixedException | HeuristicRollbackException
                | SecurityException | IllegalStateException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    return "confirmation";
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
}