package com.eidiko.supermarket_query_service.service;

import com.eidiko.supermarket_query_service.dto.EmployeeDTO;
import com.eidiko.supermarket_query_service.exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final JdbcTemplate postgresqlJdbcTemplate;

    public EmployeeServiceImpl(@Qualifier("postgresqlJdbcTemplate") JdbcTemplate postgresqlJdbcTemplate) {
        this.postgresqlJdbcTemplate = postgresqlJdbcTemplate;
    }

    @Override
    public EmployeeDTO getEmployeeById(int id) throws EmployeeNotFoundException {
        String query = "SELECT * FROM employees WHERE id=?";
        try {
            return postgresqlJdbcTemplate.queryForObject(query, (rs, rowNum) -> {
                EmployeeDTO employeeDTO = new EmployeeDTO();
                employeeDTO.setId(rs.getInt("id"));
                employeeDTO.setName(rs.getString("name"));
                employeeDTO.setEmail(rs.getString("email"));
                employeeDTO.setDesignation(rs.getString("designation"));
                employeeDTO.setRole(rs.getString("role"));
                employeeDTO.setPhoneNumber(rs.getString("phone_number"));
                employeeDTO.setJoiningDate(rs.getDate("joining_date"));
                employeeDTO.setSalary(rs.getDouble("salary"));
                employeeDTO.setReportingTo(rs.getInt("reporting_to"));
                return employeeDTO;
            }, id);
        } catch (EmptyResultDataAccessException e) {
            throw new EmployeeNotFoundException("Employee Not Found");
        }
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        String query = "SELECT * FROM employees";
        return postgresqlJdbcTemplate.query(query, (rs, rowNum) -> {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setId(rs.getInt("id"));
            employeeDTO.setName(rs.getString("name"));
            employeeDTO.setEmail(rs.getString("email"));
            employeeDTO.setDesignation(rs.getString("designation"));
            employeeDTO.setRole(rs.getString("role"));
            employeeDTO.setPhoneNumber(rs.getString("phone_number"));
            employeeDTO.setJoiningDate(rs.getDate("joining_date"));
            employeeDTO.setSalary(rs.getDouble("salary"));
            employeeDTO.setReportingTo(rs.getInt("reporting_to"));
            return employeeDTO;
        });
    }

}
