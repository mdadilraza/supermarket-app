package com.eidiko.query.dao;

import com.eidiko.query.dto.EmployeeDTO;
import com.eidiko.query.exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO {

    private final JdbcTemplate postgresqlJdbcTemplate;

    public EmployeeDaoImpl(@Qualifier("postgresqlJdbcTemplate") JdbcTemplate jdbcTemplate) {
        this.postgresqlJdbcTemplate = jdbcTemplate;
    }

    @Override
    public EmployeeDTO findById(int id) throws EmployeeNotFoundException {
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
    public List<EmployeeDTO> findAll() {
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
