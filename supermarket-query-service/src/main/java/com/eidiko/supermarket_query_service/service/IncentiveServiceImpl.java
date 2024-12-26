package com.eidiko.supermarket_query_service.service;

import com.eidiko.supermarket_query_service.exception.IncentiveNotFoundException;
import com.eidiko.supermarket_query_service.mapper.IncentiveMapper;
import com.eidiko.supermarket_query_service.model.Employee;
import com.eidiko.supermarket_query_service.model.Incentive;
import com.eidiko.supermarket_query_service.model.Sale;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncentiveServiceImpl implements IncentiveService {

    private final JdbcTemplate postgresqlJdbcTemplate;

    public IncentiveServiceImpl(@Qualifier("postgresqlJdbcTemplate") JdbcTemplate postgresqlJdbcTemplate) {
        this.postgresqlJdbcTemplate = postgresqlJdbcTemplate;
    }

    @Override
    public Incentive getIncentiveById(int id) throws IncentiveNotFoundException {
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
    public List<Incentive> getAllIncentives() {
        String query = "SELECT * " +
                "FROM incentives i " +
                "JOIN employees e ON i.employee_id = e.id " +
                "JOIN sales s ON s.employee_id = e.id";

        return postgresqlJdbcTemplate.query(query, new IncentiveMapper());
    }

}
