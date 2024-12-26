package com.eidiko.supermarket_action_service.dao;

import com.eidiko.supermarket_action_service.model.Stocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StocksRepo {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StocksRepo(@Qualifier("mssqlJdbcTemplate")JdbcTemplate jdbcTemplate1)
    {
        this.jdbcTemplate=jdbcTemplate1;
    }

    public String addStocks(Stocks stock)
    {
        String sql = "INSERT INTO stocks (name,category,quantity,price) VALUES (?, ?, ?,?)";
        int update = jdbcTemplate.update(sql, stock.getName(), stock.getCategory(), stock.getQuantity(), stock.getPrice());
        return "Stocks added";
    }

    public int updateStocks(int id,Stocks stocks)
    {
        StringBuilder sql=new StringBuilder("update stocks set ");
        List<Object> params = new ArrayList<>();
        // Dynamically add the columns that are not null
        boolean isFirst = true;

        if (stocks.getName() != null) {
            System.out.println(stocks.getName() );
            sql.append("name = ?");
            params.add(stocks.getName() );
            isFirst = false;
        }

        if (stocks.getCategory() != null) {
            if (!isFirst) sql.append(", ");
            sql.append("category = ?");
            params.add(stocks.getCategory());
            isFirst = false;
        }

        if (stocks.getPrice() != 0) {
            if (!isFirst) sql.append(", ");
            sql.append("price = ?");
            params.add(stocks.getPrice());
        }
        sql.append(" WHERE id = ?");
        params.add(id);
        return jdbcTemplate.update(sql.toString(), params.toArray());
    }

    public String deleteStock(int id)
    {
        String query="delete from stocks where id=?";
        jdbcTemplate.update(query,id);
        return "stock deleted";
    }
}
