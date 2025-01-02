package com.eidiko.query.dao;

import com.eidiko.query.dto.SaleDTO;
import com.eidiko.query.exception.EmployeeNotFoundException;
import com.eidiko.query.exception.SaleNotFoundException;
import com.eidiko.query.mapper.SaleMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleDaoImpl implements SaleDAO {

    private final JdbcTemplate postgresqlJdbcTemplate;

    public SaleDaoImpl(@Qualifier("postgresqlJdbcTemplate") JdbcTemplate jdbcTemplate) {
        this.postgresqlJdbcTemplate = jdbcTemplate;
    }

    @Override
    public SaleDTO findById(int id) throws SaleNotFoundException {
        String query = "SELECT * FROM sales s JOIN employees e ON s.employee_id = e.id WHERE s.id = ?";
        try {
            return postgresqlJdbcTemplate.queryForObject(query, new SaleMapper(), id);
        } catch (EmptyResultDataAccessException e) {
            throw new SaleNotFoundException("Sale not found");
        }
    }

    @Override
    public List<SaleDTO> findAll() {
        String query = "SELECT * FROM sales s JOIN employees e ON s.employee_id = e.id";
        return postgresqlJdbcTemplate.query(query, new SaleMapper());
    }

    @Override
    public List<SaleDTO> findByEmployeeId(int id) throws EmployeeNotFoundException {
        String query = "SELECT * FROM sales s JOIN employees e ON s.employee_id = e.id WHERE s.employee_id = ?";
        try {
            return postgresqlJdbcTemplate.query(query, new SaleMapper(), id);
        } catch (EmptyResultDataAccessException e) {
            throw new EmployeeNotFoundException("Employee not found");
        }
    }

}
