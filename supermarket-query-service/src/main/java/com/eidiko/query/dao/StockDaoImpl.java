package com.eidiko.query.dao;

import com.eidiko.query.exception.StockNotFoundException;
import com.eidiko.query.mapper.StockMapper;
import com.eidiko.query.model.Stock;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StockDaoImpl implements StockDAO {

    private final JdbcTemplate mssqlJdbcTemplate;

    public StockDaoImpl(@Qualifier("mssqlJdbcTemplate") JdbcTemplate jdbcTemplate) {
        this.mssqlJdbcTemplate = jdbcTemplate;
    }

    @Override
    public Stock findById(int id) throws StockNotFoundException {
        String query = "SELECT * FROM stocks WHERE id=?";
        try {
            return mssqlJdbcTemplate.queryForObject(query, new StockMapper(), id);
        } catch (EmptyResultDataAccessException e) {
            throw new StockNotFoundException("Stock Not Found");
        }
    }

    @Override
    public List<Stock> findAll() {
        String query = "SELECT * FROM stocks";
        return mssqlJdbcTemplate.query(query, new StockMapper());
    }

    @Override
    public List<Stock> findByName(String name) throws StockNotFoundException {
        String query = "SELECT * FROM stocks WHERE name LIKE ?";
        try {
            List<Stock> stockList = mssqlJdbcTemplate.query(query, new StockMapper(), "%" + name + "%");
            if (stockList.isEmpty()) {
                throw new StockNotFoundException("Stock Not Found");
            } else {
                return stockList;
            }
        } catch (EmptyResultDataAccessException e) {
            throw new StockNotFoundException("Stock Not Found");
        }
    }

}
