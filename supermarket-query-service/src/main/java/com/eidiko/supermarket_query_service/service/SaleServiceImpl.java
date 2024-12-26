package com.eidiko.supermarket_query_service.service;

import com.eidiko.supermarket_query_service.exception.SaleNotFoundException;
import com.eidiko.supermarket_query_service.mapper.SaleMapper;
import com.eidiko.supermarket_query_service.model.Employee;
import com.eidiko.supermarket_query_service.model.Sale;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {

    private final JdbcTemplate postgresqlJdbcTemplate;

    public SaleServiceImpl(@Qualifier("postgresqlJdbcTemplate") JdbcTemplate postgresqlJdbcTemplate) {
        this.postgresqlJdbcTemplate = postgresqlJdbcTemplate;
    }

    @Override
    public Sale getSaleById(int id) throws SaleNotFoundException {
        String query = "SELECT * FROM sales s JOIN employees e ON s.employee_id = e.id WHERE s.id = ?";
        try {
            return postgresqlJdbcTemplate.queryForObject(query, new SaleMapper(), id);
        } catch (EmptyResultDataAccessException e) {
            throw new SaleNotFoundException("Sale not found");
        }
    }

    @Override
    public List<Sale> getAllSales() {
        String query = "SELECT * FROM sales s JOIN employees e ON s.employee_id = e.id";
        return postgresqlJdbcTemplate.query(query, new SaleMapper());
    }

}
