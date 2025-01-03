package com.eidiko.supermarket_action_service.dao;

import com.eidiko.supermarket_action_service.dto.SaleRequest;
import com.eidiko.supermarket_action_service.model.Sales;
import com.eidiko.supermarket_action_service.model.Stocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SalesRepo {


    private final JdbcTemplate jdbcTemplate;
    private final JdbcTemplate postJdbcTemplate;

    @Autowired
    public SalesRepo(@Qualifier("mssqlJdbcTemplate") JdbcTemplate jdbcTemplate,@Qualifier("postgresqlJdbcTemplate")JdbcTemplate postgresJdbc)
    {
        this.jdbcTemplate=jdbcTemplate;
        this.postJdbcTemplate=postgresJdbc;
    }

    public Sales addSales(SaleRequest saleRequest)
    {
        List<Stocks>list = saleRequest.getStocks();
        List<Integer>resultList=new ArrayList<>();
        double totalAmount=0;
        for(Stocks stocks:list)
        {
            String stockQuery="select * from stocks where id= ?";
            Stocks stocks1=jdbcTemplate.queryForObject(stockQuery,new BeanPropertyRowMapper<>(Stocks.class),stocks.getId());
            assert stocks1 != null;
            resultList.add(stocks1.getId());
            double total=stocks1.getPrice()*stocks.getQuantity();
            totalAmount=totalAmount+total;
        }
        Sales sales=new Sales();
        sales.setStockId(resultList);
        sales.setSalesAmount(totalAmount);
        sales.setEmployeeId(saleRequest.getEmployeeId());
        Integer[] stockArray = sales.getStockId().toArray(new Integer[0]);
        Timestamp timestamp = Timestamp.valueOf(sales.getSaleDate());
        String query="INSERT INTO sales (sales_amount, stock, date, employee_id) VALUES (?,?,?,?)";
        int update = postJdbcTemplate.update(query, sales.getSalesAmount(), stockArray, timestamp, sales.getEmployeeId());
        return sales;
    }



}
