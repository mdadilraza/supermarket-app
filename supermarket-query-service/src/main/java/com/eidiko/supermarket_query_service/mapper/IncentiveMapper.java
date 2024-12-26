package com.eidiko.supermarket_query_service.mapper;

import com.eidiko.supermarket_query_service.model.Employee;
import com.eidiko.supermarket_query_service.model.Incentive;
import com.eidiko.supermarket_query_service.model.Sale;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IncentiveMapper implements RowMapper<Incentive> {

    @Override
    public Incentive mapRow(ResultSet rs, int rowNum) throws SQLException {
        Incentive incentive = new Incentive();
        incentive.setId(rs.getInt("id"));
        incentive.setIncentiveAmount(rs.getDouble("incentive_amount"));

        Employee employee = mapEmployee(rs);
        incentive.setEmployeeId(employee);

        Sale sale = mapSale(rs, employee);
        incentive.setSaleId(sale);

        return incentive;
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

    private Sale mapSale(ResultSet rs, Employee employee) throws SQLException {
        Sale sale = new Sale();
        sale.setId(rs.getInt("id"));
        sale.setSaleAmount(rs.getDouble("sales_amount"));
        sale.setStocks(rs.getString("stock"));
        sale.setEmployeeId(employee);
        return sale;
    }

}

