package com.sprinboot.employees.services;

import com.sprinboot.employees.entity.Employee;

import java.util.List;

public interface EmployeeService  {

    List<Employee> findAll();
    Employee findById(int employeeId);
    Employee save(Employee employee);
    void deleteEmployee(int employeeId);
}
