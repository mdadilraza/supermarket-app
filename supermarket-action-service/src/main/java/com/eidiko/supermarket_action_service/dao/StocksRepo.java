package com.eidiko.supermarket_action_service.dao;

import com.eidiko.supermarket_action_service.exceptions.EmployeeNotFoundException;
import com.eidiko.supermarket_action_service.exceptions.StockNotFoundException;
import com.eidiko.supermarket_action_service.model.Stocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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

    public Stocks addStocks(Stocks stock)
    {
        String sql = "INSERT INTO stocks (name,category,quantity,price) VALUES (?, ?, ?,?)";
        int update = jdbcTemplate.update(sql, stock.getName(), stock.getCategory(), stock.getQuantity(), stock.getPrice());
       String query="select * from stocks where name=?";
       return jdbcTemplate.queryForObject(query,new BeanPropertyRowMapper<>(Stocks.class),stock.getName());
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

    public String deleteStock(int id) throws StockNotFoundException, EmployeeNotFoundException {
        String sql="delete from stocks where id=?";
        int result=jdbcTemplate.update(sql,id);
        if (result != 0) {
            return "stocks deleted";
        }
        throw new EmployeeNotFoundException("Stock not found");
    }


    public String updateStockQuantity(int stockId,int sellQuantity)
    {
        String getStock="select * from stocks where id=?";
        Stocks stocks=jdbcTemplate.queryForObject(getStock,new BeanPropertyRowMapper<>(Stocks.class),stockId);
        System.out.println(stocks);
        String query="UPDATE stocks SET quantity = ? WHERE id = ?";
        assert stocks != null;
        int totalQuantity = stocks.getQuantity();
        int updatedQuantity = totalQuantity - sellQuantity;
        if (updatedQuantity >= 0) {
            String updateQuery = "UPDATE stocks SET quantity = ? WHERE id = ?";
            int res = jdbcTemplate.update(updateQuery, updatedQuantity, stockId);
            if (res > 0) {
                return "Stocks updated successfully";
            } else {
                return "No rows affected, stock update failed";
            }
        } else {
            return "Insufficient stock to complete the sale";
        }
    }

}
