package com.eidiko.query.mapper;

import com.eidiko.query.dto.EmployeeDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<EmployeeDTO> {

    @Override
    public EmployeeDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
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
    }

}
