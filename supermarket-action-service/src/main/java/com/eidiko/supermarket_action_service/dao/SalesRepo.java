package com.eidiko.supermarket_action_service.dao;

import com.eidiko.supermarket_action_service.dto.SaleRequest;
import com.eidiko.supermarket_action_service.exceptions.EmployeeNotFoundException;
import com.eidiko.supermarket_action_service.model.Employee;
import com.eidiko.supermarket_action_service.model.Sale;
import com.eidiko.supermarket_action_service.model.Stock;
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

    public Sale addSales(SaleRequest saleRequest) throws EmployeeNotFoundException {
        List<Stock>list = saleRequest.getStocks();
        List<Integer>resultList=new ArrayList<>();
        double totalAmount=0;
        String empQuery = "SELECT * FROM employees WHERE id = ?";
        Employee employee = postJdbcTemplate.queryForObject(empQuery, new BeanPropertyRowMapper<>(Employee.class), saleRequest.getEmployeeId());
        if (employee == null) {
            throw new EmployeeNotFoundException("employees not found");
        }
        for(Stock stock :list)
        {
            String stockQuery="select * from stocks where id= ?";
            Stock stock1 =jdbcTemplate.queryForObject(stockQuery,new BeanPropertyRowMapper<>(Stock.class), stock.getId());
            assert stock1 != null;
            resultList.add(stock1.getId());
            double total= stock1.getPrice()* stock.getQuantity();
            totalAmount=totalAmount+total;
        }
        Sale sales=new Sale();
        sales.setStocks(resultList);
        sales.setSaleAmount(totalAmount);
        sales.setEmployeeId(employee);
        Integer[] stockArray = sales.getStocks().toArray(new Integer[0]);
        Timestamp timestamp = Timestamp.valueOf(sales.getSaleDate());
        String query="INSERT INTO sales (sales_amount, stock, date, employee_id) VALUES (?,?,?,?)";
        int update = postJdbcTemplate.update(query, sales.getSaleAmount(), stockArray, timestamp, employee.getId());
        return sales;
    }



}
