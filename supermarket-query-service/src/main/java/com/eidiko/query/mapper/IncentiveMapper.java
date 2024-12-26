package com.eidiko.query.mapper;

import com.eidiko.query.dto.EmployeeDTO;
import com.eidiko.query.dto.IncentiveDTO;
import com.eidiko.query.dto.SaleDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IncentiveMapper implements RowMapper<IncentiveDTO> {

    @Override
    public IncentiveDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        IncentiveDTO incentiveDTO = new IncentiveDTO();
        incentiveDTO.setId(rs.getInt("id"));
        incentiveDTO.setIncentiveAmount(rs.getDouble("incentive_amount"));

        EmployeeDTO employeeDTO = mapEmployee(rs);
        incentiveDTO.setEmployeeId(employeeDTO);

        SaleDTO saleDTO = mapSale(rs, employeeDTO);
        incentiveDTO.setSaleId(saleDTO);

        return incentiveDTO;
    }

    private EmployeeDTO mapEmployee(ResultSet rs) throws SQLException {
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

    private SaleDTO mapSale(ResultSet rs, EmployeeDTO employeeDTO) throws SQLException {
        SaleDTO saleDTO = new SaleDTO();
        saleDTO.setId(rs.getInt("id"));
        saleDTO.setSaleAmount(rs.getDouble("sales_amount"));
        saleDTO.setStocks(rs.getString("stock"));
        saleDTO.setEmployeeId(employeeDTO);
        return saleDTO;
    }

}

