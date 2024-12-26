package com.eidiko.query.service;

import com.eidiko.query.dto.SaleDTO;
import com.eidiko.query.exception.SaleNotFoundException;
import com.eidiko.query.mapper.SaleMapper;
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
    public SaleDTO getSaleById(int id) throws SaleNotFoundException {
        String query = "SELECT * FROM sales s JOIN employees e ON s.employee_id = e.id WHERE s.id = ?";
        try {
            return postgresqlJdbcTemplate.queryForObject(query, new SaleMapper(), id);
        } catch (EmptyResultDataAccessException e) {
            throw new SaleNotFoundException("Sale not found");
        }
    }

    @Override
    public List<SaleDTO> getAllSales() {
        String query = "SELECT * FROM sales s JOIN employees e ON s.employee_id = e.id";
        return postgresqlJdbcTemplate.query(query, new SaleMapper());
    }

}
