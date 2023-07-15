package com.sprinboot.employees.dao;

import com.sprinboot.employees.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImp implements EmployeeDAO{


    //field for entityManager
    private EntityManager entityManager;

    //constructor injection
    @Autowired
    public EmployeeDAOImp(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    @Override
    public List<Employee> findAll() {

        //create query
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);

        return query.getResultList()    ;
    }

    @Override
    public Employee findById(int employeeId) {

        Employee employee = entityManager.find(Employee.class, employeeId);

        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        entityManager.persist(employee);
        return entityManager.merge(employee);
    }

    @Override
    public void deleteEmployee(int employeeId) {
        Employee employee = entityManager.find(Employee.class, employeeId);
        entityManager.remove(employee);
    }
}
