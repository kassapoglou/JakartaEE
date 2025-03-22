package com.mycompany.beans;

import com.mycompany.entities.Employee;
import java.io.Serializable;


public class RegistrationInfo implements Serializable {

    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
