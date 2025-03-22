package com.mycompany.services;

@RandomAssignment
public class RandomEmployeeDepartment implements DepartmentAssignment {

    @Override
    public long generateDepartment() {
        long randomNumber =  (long) (Math.random() * 4) + 1;
        return randomNumber;
    }
    
}
