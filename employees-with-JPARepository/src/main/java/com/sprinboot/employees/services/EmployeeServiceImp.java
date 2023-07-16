package com.sprinboot.employees.services;

import com.sprinboot.employees.dao.EmployeeRepository;
import com.sprinboot.employees.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService{

    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImp(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int employeeId) {

        Optional<Employee> result = employeeRepository.findById(employeeId);
        Employee employee = null;
        if(result.isPresent()){
            employee = result.get();
        }
        else {
            throw new RuntimeException("Employee not found " + employeeId);
        }
        return employee;
    }

    //save or update


    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }


    @Override
    public void deleteEmployee(int employeeId) {
        Employee employee =findById(employeeId);
        employeeRepository.delete(employee);
    }

}
