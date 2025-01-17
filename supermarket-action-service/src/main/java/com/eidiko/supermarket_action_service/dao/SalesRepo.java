package com.eidiko.supermarket_action_service.dao;

import com.eidiko.supermarket_action_service.dto.SaleRequest;
import com.eidiko.supermarket_action_service.exceptions.InsufficientStockException;
import com.eidiko.supermarket_action_service.exceptions.StockNotFoundException;
import com.eidiko.supermarket_action_service.model.Sale;
import com.eidiko.supermarket_action_service.model.Stock;
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
    private final StocksRepo stocksRepo;


    public SalesRepo(@Qualifier("mssqlJdbcTemplate") JdbcTemplate jdbcTemplate,StocksRepo stocksRepo,@Qualifier("postgresqlJdbcTemplate")JdbcTemplate postgresJdbc)
    {
        this.jdbcTemplate=jdbcTemplate;
        this.postJdbcTemplate=postgresJdbc;
        this.stocksRepo=stocksRepo;
    }

    public Sale addSales(SaleRequest saleRequest) throws InsufficientStockException, StockNotFoundException {
        List<Stock>list = saleRequest.getStocks();
        List<Integer>resultList=new ArrayList<>();
        double totalAmount=0;
        for(Stock stock :list)
        {
            String stockQuery="select * from stocks where id= ?";
            Stock stock1 =jdbcTemplate.queryForObject(stockQuery,new BeanPropertyRowMapper<>(Stock.class), stock.getId());
            assert stock1 != null;
            resultList.add(stock1.getId());
            double total= stock1.getPrice()* stock.getQuantity();
            totalAmount=totalAmount+total;
            stocksRepo.updateStockQuantity(stock1.getId(),stock.getQuantity());


        }
        Sale sale =new Sale();
        sale.setStockId(resultList);
        sale.setSalesAmount(totalAmount);
        sale.setEmployeeId(saleRequest.getEmployeeId());
        Integer[] stockArray = sale.getStockId().toArray(new Integer[0]);
        Timestamp timestamp = Timestamp.valueOf(sale.getSaleDate());
        String query="INSERT INTO sales (sales_amount, stock, date, employee_id) VALUES (?,?,?,?)";
        postJdbcTemplate.update(query, sale.getSalesAmount(), stockArray, timestamp, sale.getEmployeeId());
        return sale;
    }



}
