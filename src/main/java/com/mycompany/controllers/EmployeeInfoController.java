package com.mycompany.controllers;

import com.mycompany.beans.EmployeeInfo;
import com.mycompany.entities.Department;
import com.mycompany.entities.Employee;
import com.mycompany.entities.Location;
import com.mycompany.services.DepartmentAssignment;
import com.mycompany.services.ITAssignment;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.Conversation;
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
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
@RequestScoped
public class EmployeeInfoController implements Serializable {
    
     @PersistenceContext
    private EntityManager em;

    @Resource
    private UserTransaction userTransaction;
    
    @Inject
    private Conversation conversation;
    
    @Inject
    EmployeeInfo employeeInfo;

    
    @Inject
    private EmployeeInfo employee;
    
     private static final Logger logger = 
             Logger.getLogger(EmployeeInfoController.class.getName());
    
    @Inject
    @Default
    @ITAssignment
    DepartmentAssignment departmentAssignment;

    public String employeeInfoEntry() {
        conversation.begin();
        System.out.println(employee);
        return "personal";
    }

    public String employeePersonalInfo() {
        System.out.println(employee);
        return "address";
    }
    
    public String employeePersonalBackInfo() {
        System.out.println(employee);
        return "personal";
    }

    public String employeeConfirmationPage() throws java.text.ParseException, 
            NotSupportedException, SystemException, 
            RollbackException, HeuristicMixedException, 
            HeuristicRollbackException {
        System.out.println(employee);
        
         Employee employee = new Employee();
      Department department = new Department();
      Location location = new Location();
      
      
     if ("None".equals(employeeInfo.getDept())) {
            department.setDept_id(departmentAssignment.generateDepartment());
        } else {
            switch (employeeInfo.getDept()) {
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

        employee.setFirstName(employeeInfo.getFirstName());
        employee.setLastName(employeeInfo.getLastName());
        employee.setMonthlySalary(employeeInfo.getMonthlySalary());
        Date dt = null;
        dt = new SimpleDateFormat("yyyy-MM-dd").parse(employeeInfo.getDate());
        employee.setHireDate(dt);
        employee.setEmail(employeeInfo.getEmail());
        employee.setPhoneNumber(employeeInfo.getPhoneNumber());
        
       location.setCity(employeeInfo.getCity());
       location.setPostal_code(employeeInfo.getPostal_code());
       location.setState_province(employeeInfo.getState_province());
       location.setStreet_address(employeeInfo.getStreet_address());

      employee.setAddress(location);
      employee.setDepartment(department);
      System.out.println(employeeInfo.toString());
       try {
            userTransaction.begin();
            em.persist(employee);
            userTransaction.commit();
            logger.log(Level.INFO, 
                    "Transaction has been completed with employee id: {0}", 
                    employee.getEmployee_id());
        } catch (NotSupportedException
                | SystemException | RollbackException
                | HeuristicMixedException | HeuristicRollbackException
                | SecurityException | IllegalStateException ex) {
            Logger.getLogger(EmployeeInfoController.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
      
        conversation.end();
        return "confirmation";
    }
}