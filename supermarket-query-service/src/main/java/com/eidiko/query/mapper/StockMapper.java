package com.eidiko.query.mapper;

import com.eidiko.query.model.Stock;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StockMapper implements RowMapper<Stock> {

    @Override
    public Stock mapRow(ResultSet rs, int rowNum) throws SQLException {
        Stock stock = new Stock();
        stock.setId(rs.getInt("id"));
        stock.setName(rs.getString("name"));
        stock.setCategory(rs.getString("category"));
        stock.setQuantity(rs.getInt("quantity"));
        stock.setPrice(rs.getDouble("price"));
        return stock;
    }

}
