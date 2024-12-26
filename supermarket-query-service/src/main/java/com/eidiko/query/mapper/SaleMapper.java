package com.eidiko.query.mapper;

import com.eidiko.query.dto.EmployeeDTO;
import com.eidiko.query.dto.SaleDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SaleMapper implements RowMapper<SaleDTO> {

    @Override
    public SaleDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        SaleDTO saleDTO = new SaleDTO();
        saleDTO.setId(rs.getInt("id"));
        saleDTO.setSaleAmount(rs.getDouble("sales_amount"));
        saleDTO.setStocks(rs.getString("stock"));

        EmployeeDTO employeeDTO = mapEmployeeDTO(rs);
        saleDTO.setEmployeeId(employeeDTO);

        return saleDTO;
    }

    private EmployeeDTO mapEmployeeDTO(ResultSet rs) throws SQLException {
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
