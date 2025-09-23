package com.finalproject.hrportal.repository.impl;

import com.finalproject.hrportal.domain.Employee;
import com.finalproject.hrportal.exceptions.ResourceNotFoundException;
import com.finalproject.hrportal.repository.EmployeeRepository;
import com.finalproject.hrportal.rowmapper.EmployeeRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final String GET_ALL_EMPLOYEES="SELECT * FROM employee_details";
    private static final String GET_EMPLOYEE_BY_ROLE="SELECT * FROM employee_details WHERE role_key=?";
    @Override
    public List<Employee> getAllEmployee() {
        return jdbcTemplate.query(GET_ALL_EMPLOYEES,new EmployeeRowMapper());
    }

    @Override
    public List<String> getEmployeeByRole(String role) {
        String sql="select employee_id from employee_Details where role_key=?";
        List<String>employeeByRoleList=jdbcTemplate.query(sql, (rs, rowNum) -> rs.getString("employee_id"),role);
        if(employeeByRoleList.size()==0){
            throw (new ResourceNotFoundException("NO Employee Found By this Role " + role));
        }
        return employeeByRoleList;
    }

    @Override
    public List<Employee> getEmployeesOnBench() {
        String sql="SELECT * FROM employee_details WHERE project_id IS NULL AND is_ACTIVE=1 AND role_key NOT IN('TEAMLEAD','HR','PROJECTMANGER')";
        return jdbcTemplate.query(sql,new EmployeeRowMapper());
    }



}
