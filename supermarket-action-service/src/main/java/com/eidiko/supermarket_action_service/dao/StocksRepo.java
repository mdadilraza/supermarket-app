package com.eidiko.supermarket_action_service.dao;

import com.eidiko.supermarket_action_service.exceptions.EmployeeNotFoundException;
import com.eidiko.supermarket_action_service.exceptions.InsufficientStockException;
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

    public Stocks updateStocks(int id,Stocks stocks)
    {
        int totalQuantity=0;
        StringBuilder sql=new StringBuilder("update stocks set ");
        List<Object> params = new ArrayList<>();
        boolean isFirst = true;
        if (stocks.getName() != null) {
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
            isFirst = false;
        }
        if(stocks.getQuantity()!=0)
        {
            if (!isFirst) sql.append(", ");
            sql.append("quantity = ?");
            params.add(stocks.getQuantity());
            totalQuantity= stocks.getQuantity();
        }
        sql.append(" WHERE id = ?");
        params.add(id);
        jdbcTemplate.update(sql.toString(), params.toArray());
        String resQuery="select * from stocks where id= ?";
        Stocks stocks1=jdbcTemplate.queryForObject(resQuery,new BeanPropertyRowMapper<>(Stocks.class),id);
        assert stocks1 != null;
        stocks1.setQuantity(totalQuantity);
         return stocks1;
    }

    public String deleteStock(int id) throws StockNotFoundException, EmployeeNotFoundException {
        String sql="delete from stocks where id=?";
        int result=jdbcTemplate.update(sql,id);
        if (result != 0) {
            return "stocks deleted";
        }
        throw new EmployeeNotFoundException("Stock not found");
    }


    public Stocks updateStockQuantity(int stockId,int sellQuantity) throws InsufficientStockException {
        String getStock="select * from stocks where id=?";
        Stocks stocks=jdbcTemplate.queryForObject(getStock,new BeanPropertyRowMapper<>(Stocks.class),stockId);
        assert stocks != null;
        int totalQuantity = stocks.getQuantity();
        int updatedQuantity = totalQuantity - sellQuantity;
        stocks.setQuantity(updatedQuantity);
        if (updatedQuantity >= 0) {
            String updateQuery = "UPDATE stocks SET quantity = ? WHERE id = ?";
            int res = jdbcTemplate.update(updateQuery, updatedQuantity, stockId);
            if (res > 0) {
                stocks.setQuantity(updatedQuantity);
                return stocks;
            } else {
                throw new RuntimeException("No rows affected, stock update failed");
            }
        } else {
            throw new InsufficientStockException("Insufficient stock to complete the sale");
        }
    }

}
