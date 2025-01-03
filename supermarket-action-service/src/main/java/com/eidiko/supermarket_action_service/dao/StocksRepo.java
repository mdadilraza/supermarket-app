package com.eidiko.supermarket_action_service.dao;

import com.eidiko.supermarket_action_service.exceptions.EmployeeNotFoundException;
import com.eidiko.supermarket_action_service.exceptions.InsufficientStockException;
import com.eidiko.supermarket_action_service.exceptions.StockNotFoundException;
import com.eidiko.supermarket_action_service.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    public Stock addStocks(Stock stock)
    {
        String sql = "INSERT INTO stocks (name,category,quantity,price) VALUES (?, ?, ?,?)";
        int update = jdbcTemplate.update(sql, stock.getName(), stock.getCategory(), stock.getQuantity(), stock.getPrice());
       String query="select * from stocks where name=?";
       return jdbcTemplate.queryForObject(query,new BeanPropertyRowMapper<>(Stock.class),stock.getName());
    }

    public Stock updateStocks(int id, Stock stock)
    {
        int totalQuantity=0;
        StringBuilder sql=new StringBuilder("update stocks set ");
        List<Object> params = new ArrayList<>();
        boolean isFirst = true;
        if (stock.getName() != null) {
            sql.append("name = ?");
            params.add(stock.getName() );
            isFirst = false;
        }

        if (stock.getCategory() != null) {
            if (!isFirst) sql.append(", ");
            sql.append("category = ?");
            params.add(stock.getCategory());
            isFirst = false;
        }

        if (stock.getPrice() != 0) {
            if (!isFirst) sql.append(", ");
            sql.append("price = ?");
            params.add(stock.getPrice());
            isFirst = false;
        }
        if(stock.getQuantity()!=0)
        {
            if (!isFirst) sql.append(", ");
            sql.append("quantity = ?");
            params.add(stock.getQuantity());
            totalQuantity= stock.getQuantity();
        }
        sql.append(" WHERE id = ?");
        params.add(id);
        jdbcTemplate.update(sql.toString(), params.toArray());
        String resQuery="select * from stocks where id= ?";
        Stock stock1 =jdbcTemplate.queryForObject(resQuery,new BeanPropertyRowMapper<>(Stock.class),id);
        assert stock1 != null;
        stock1.setQuantity(totalQuantity);
         return stock1;
    }

    public String deleteStock(int id) throws StockNotFoundException, EmployeeNotFoundException {
        String sql="delete from stocks where id=?";
        int result=jdbcTemplate.update(sql,id);
        if (result != 0) {
            return "stocks deleted";
        }
        throw new EmployeeNotFoundException("Stock not found");
    }


    public Stock updateStockQuantity(int stockId, int sellQuantity) throws InsufficientStockException {
        String getStock="select * from stocks where id=?";
        Stock stock =jdbcTemplate.queryForObject(getStock,new BeanPropertyRowMapper<>(Stock.class),stockId);
        assert stock != null;
        int totalQuantity = stock.getQuantity();
        int updatedQuantity = totalQuantity - sellQuantity;
        stock.setQuantity(updatedQuantity);
        if (updatedQuantity >= 0) {
            String updateQuery = "UPDATE stocks SET quantity = ? WHERE id = ?";
            int res = jdbcTemplate.update(updateQuery, updatedQuantity, stockId);
            if (res > 0) {
                stock.setQuantity(updatedQuantity);
                return stock;
            } else {
                throw new RuntimeException("No rows affected, stock update failed");
            }
        } else {
            throw new InsufficientStockException("Insufficient stock to complete the sale");
        }
    }
}
