package com.mycompany.services;

import jakarta.enterprise.inject.Default;

@Default
@ITAssignment
public class ITEmployeeDepartment implements DepartmentAssignment {

    @Override
    public long generateDepartment() {
        return 2L;
    }
}
