
package com.mycompany.jakartaee.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "DEPARTMENTS")
public class Department implements Serializable {

    public Department() {
    }
    
    private static final long serialVersionUID = 1L;
    @Id
    private Long dept_id;
    
    @Column(name = "dept_name")
    private String name;
    
    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER )
    private List<Employee> employees;

    public Long getDept_id() {
        return dept_id;
    }

    public void setDept_id(Long dept_id) {
        this.dept_id = dept_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
