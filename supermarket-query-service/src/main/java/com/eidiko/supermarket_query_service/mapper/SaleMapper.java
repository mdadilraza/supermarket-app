package com.eidiko.supermarket_query_service.mapper;

import com.eidiko.supermarket_query_service.model.Employee;
import com.eidiko.supermarket_query_service.model.Sale;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SaleMapper implements RowMapper<Sale> {

    @Override
    public Sale mapRow(ResultSet rs, int rowNum) throws SQLException {
        Sale sale = new Sale();
        sale.setId(rs.getInt("id"));
        sale.setSaleAmount(rs.getDouble("sales_amount"));
        sale.setStocks(rs.getString("stock"));

        Employee employee = mapEmployee(rs);
        sale.setEmployeeId(employee);

        return sale;
    }

    private Employee mapEmployee(ResultSet rs) throws SQLException {
        Employee employee = new Employee();
        employee.setId(rs.getInt("id"));
        employee.setName(rs.getString("name"));
        employee.setEmail(rs.getString("email"));
        employee.setDesignation(rs.getString("designation"));
        employee.setRole(rs.getString("role"));
        employee.setPhoneNumber(rs.getString("phone_number"));
        employee.setJoiningDate(rs.getDate("joining_date"));
        employee.setSalary(rs.getDouble("salary"));
        employee.setReportingTo(rs.getInt("reporting_to"));
        return employee;
    }

}
