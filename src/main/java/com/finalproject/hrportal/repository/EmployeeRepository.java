package com.finalproject.hrportal.repository;

import com.finalproject.hrportal.domain.Employee;

import java.util.List;

public interface EmployeeRepository  {

    List<Employee>getAllEmployee();
    List<String>getEmployeeByRole(String role);
    List<Employee>getEmployeesOnBench();
}
