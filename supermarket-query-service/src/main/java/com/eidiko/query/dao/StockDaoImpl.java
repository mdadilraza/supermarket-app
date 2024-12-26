package com.eidiko.query.dao;

import com.eidiko.query.exception.StockNotFoundException;
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
            return mssqlJdbcTemplate.queryForObject(query, (rs, rowNum) -> {
                Stock stock = new Stock();
                stock.setId(rs.getInt("id"));
                stock.setName(rs.getString("name"));
                stock.setCategory(rs.getString("category"));
                stock.setQuantity(rs.getInt("quantity"));
                stock.setPrice(rs.getDouble("price"));
                return stock;
            }, id);
        } catch (EmptyResultDataAccessException e) {
            throw new StockNotFoundException("Stock Not Found");
        }
    }

    @Override
    public List<Stock> findAll() {
        String query = "SELECT * FROM stocks";
        return mssqlJdbcTemplate.query(query, (rs, rowNum) -> {
            Stock stock = new Stock();
            stock.setId(rs.getInt("id"));
            stock.setName(rs.getString("name"));
            stock.setCategory(rs.getString("category"));
            stock.setQuantity(rs.getInt("quantity"));
            stock.setPrice(rs.getDouble("price"));
            return stock;
        });
    }

}
