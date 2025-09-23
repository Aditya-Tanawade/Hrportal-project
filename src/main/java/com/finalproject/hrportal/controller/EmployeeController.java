package com.finalproject.hrportal.controller;

import com.finalproject.hrportal.domain.Employee;
import com.finalproject.hrportal.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    @GetMapping("/allemployee")
    public List<Employee> getAllEmployee(){
        return employeeRepository.getAllEmployee();
    }

    @GetMapping("/fullname")
    public String employeeName(String employeeId){
        return "NOt FOUND ";
    }
}
