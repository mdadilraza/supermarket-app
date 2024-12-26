package com.eidiko.supermarket_query_service.service;

import com.eidiko.supermarket_query_service.exception.StockNotFoundException;
import com.eidiko.supermarket_query_service.model.Stock;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    private final JdbcTemplate mssqlJdbcTemplate;

    public StockServiceImpl(@Qualifier("mssqlJdbcTemplate") JdbcTemplate mssqlJdbcTemplate) {
        this.mssqlJdbcTemplate = mssqlJdbcTemplate;
    }

    @Override
    public Stock getStockById(int id) throws StockNotFoundException {
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
    public List<Stock> getAllStocks() {
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
