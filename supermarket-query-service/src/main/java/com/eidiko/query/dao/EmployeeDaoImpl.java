package com.eidiko.query.dao;

import com.eidiko.query.dto.EmployeeDTO;
import com.eidiko.query.exception.EmployeeNotFoundException;
import com.eidiko.query.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
            return postgresqlJdbcTemplate.queryForObject(query, new EmployeeMapper(), id);
        } catch (EmptyResultDataAccessException e) {
            throw new EmployeeNotFoundException("Employee Not Found");
        }
    }

    @Override
    public List<EmployeeDTO> findAll() {
        String query = "SELECT * FROM employees";
        return postgresqlJdbcTemplate.query(query, new EmployeeMapper());
    }
}
