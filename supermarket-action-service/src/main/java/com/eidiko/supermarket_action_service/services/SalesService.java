package com.eidiko.supermarket_action_service.services;

import com.eidiko.supermarket_action_service.model.Sales;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class SalesService {

    private final JdbcTemplate jdbcTemplate;

    public SalesService(@Qualifier("postgresqlJdbcTemplate") JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate=jdbcTemplate;
    }

    public String addSales(Sales sales)
    {
        String sql="insert into sales values (id,salesAmount,employeeId,stockId)";
        jdbcTemplate.update(sql,sales.getId(),sales.getSalesAmount(),sales.getEmployeeId(),sales.getStockId());
        return "added";
    }

}
