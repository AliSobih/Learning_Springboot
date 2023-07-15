package com.sprinboot.employees;

import com.sprinboot.employees.dao.EmployeeDAO;
import com.sprinboot.employees.dao.EmployeeDAOImp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeesApplication.class, args);
	}



}
