package com.mycompany.services;

import jakarta.enterprise.inject.Default;

@Default
public class RandomEmployeeDepartment implements DepartmentAssignment {

    @Override
    public long generateDepartment() {
        long randomNumber =  (long) (Math.random() * 4) + 1;
        return randomNumber;
    }
    
}
