package com.eidiko.query.dao;

import com.eidiko.query.dto.IncentiveDTO;
import com.eidiko.query.exception.IncentiveNotFoundException;
import com.eidiko.query.mapper.IncentiveMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IncentiveDaoImpl implements IncentiveDAO {

    private final JdbcTemplate postgresqlJdbcTemplate;

    public IncentiveDaoImpl(@Qualifier("postgresqlJdbcTemplate") JdbcTemplate jdbcTemplate) {
        this.postgresqlJdbcTemplate = jdbcTemplate;
    }


    @Override
    public IncentiveDTO findById(int id) throws IncentiveNotFoundException {
        String query = "SELECT * " +
                "FROM incentives i " +
                "JOIN employees e ON i.employee_id = e.id " +
                "JOIN sales s ON s.employee_id = e.id " +
                "WHERE e.id = ?";
        try {
            return postgresqlJdbcTemplate.queryForObject(query, new IncentiveMapper(), id);
        } catch (EmptyResultDataAccessException e) {
            throw new IncentiveNotFoundException("Incentive not found");
        }
    }

    @Override
    public List<IncentiveDTO> findAll() {
        String query = "SELECT * " +
                "FROM incentives i " +
                "JOIN employees e ON i.employee_id = e.id " +
                "JOIN sales s ON s.employee_id = e.id";

        return postgresqlJdbcTemplate.query(query, new IncentiveMapper());
    }
}
