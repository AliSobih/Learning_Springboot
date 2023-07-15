package com.sprinboot.employees.dao;

import com.sprinboot.employees.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
    Employee findById(int employeeId);
    Employee save(Employee employee);
    void deleteEmployee(int employeeId);


}
