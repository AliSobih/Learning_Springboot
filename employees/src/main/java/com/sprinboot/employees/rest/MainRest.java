package com.sprinboot.employees.rest;


import com.sprinboot.employees.dao.EmployeeDAO;
import com.sprinboot.employees.entity.Employee;
import com.sprinboot.employees.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainRest {


    private EmployeeService employeeService;


    @Autowired
    public MainRest(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    @GetMapping("/employees")
    public List<Employee> showEmployees(){
        return employeeService.findAll();
    }
    @GetMapping("/employees/{employeeId}")
    public Employee showEmployeeById(@PathVariable int employeeId){

        Employee employee = employeeService.findById(employeeId);
        if(employee == null)
            throw new RuntimeException("employee id not fount " + employeeId);
        return employee;
    }

    @PostMapping("/employees")
    public Employee saveNewEmployee(@RequestBody Employee employee){

        //force id to 0 to save new item not update
        employee.setId(0);

        return employeeService.save(employee);
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){

        return employeeService.save(employee);
    }
    @DeleteMapping("/employees/{employeeId}")
    public String  deleteEmployee(@PathVariable int employeeId){
        //check if the recorde in db or not
        Employee employee = employeeService.findById(employeeId);
        if(employee == null)
            throw new RuntimeException("Employee not found " + employeeId);

        employeeService.deleteEmployee(employeeId);
        return "deleted employee id: " +employeeId;
    }
}
