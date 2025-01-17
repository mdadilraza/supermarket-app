package com.eidiko.supermarket_action_service.dao;

import com.eidiko.supermarket_action_service.model.Employee;
import com.eidiko.supermarket_action_service.model.Incentive;
import com.eidiko.supermarket_action_service.model.Sale;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class IncentiveRepo {

    private final JdbcTemplate jdbcTemplate;

    public IncentiveRepo(@Qualifier("postgresqlJdbcTemplate") JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate=jdbcTemplate;
    }

    public List<Incentive> addIncentive(Incentive incentive) {
        String query = "INSERT INTO incentives (employee_id,sale_id,incentive_amount,date) VALUES (?, ?, ?, ?)";

        String employeeQuery = "select * from employees where id= ?";
        Employee employee = jdbcTemplate.queryForObject(employeeQuery, new BeanPropertyRowMapper<>(Employee.class), incentive.getEmployeeId());
        assert employee!=null;
        String salesQuery = "select * from sales where id= ?";
        Sale sale = jdbcTemplate.queryForObject(salesQuery, new BeanPropertyRowMapper<>(Sale.class), incentive.getSalesId());
        assert sale != null;
        Incentive incentive1 =new Incentive();
        incentive1.setEmployeeId(incentive.getEmployeeId());
        incentive1.setSalesId(incentive.getSalesId());
        incentive1.setIncentiveAmount(sale.getSalesAmount()*0.8);
        incentive1.setDate(sale.getSaleDate().toLocalDate());

        String employeeReportingQuery="select * from employees where id= ?";
        Employee employee1 = jdbcTemplate.queryForObject(employeeReportingQuery, new BeanPropertyRowMapper<>(Employee.class), employee.getReportingTo());

        Incentive incentive2 =new Incentive();
        incentive2.setEmployeeId(employee.getReportingTo());
        incentive2.setSalesId(incentive.getSalesId());
        incentive2.setIncentiveAmount(sale.getSalesAmount()*0.6);
        incentive2.setDate(sale.getSaleDate().toLocalDate());

        Incentive incentive3 =new Incentive();
        assert employee1 != null;
        incentive3.setEmployeeId(employee1.getReportingTo());
        incentive3.setSalesId(incentive.getSalesId());
        incentive3.setIncentiveAmount(sale.getSalesAmount()*0.4);
        incentive3.setDate(sale.getSaleDate().toLocalDate());
//        INSERT INTO incentives (employee_id,sale_id,incentive_amount,date) VALUES (?, ?, ?, ?)
        jdbcTemplate.update(query, incentive1.getEmployeeId(), incentive1.getSalesId(), incentive1.getIncentiveAmount(), incentive1.getDate());
        jdbcTemplate.update(query, incentive2.getEmployeeId(), incentive2.getSalesId(), incentive2.getIncentiveAmount(), incentive2.getDate());
        jdbcTemplate.update(query, incentive3.getEmployeeId(), incentive3.getSalesId(), incentive3.getIncentiveAmount(), incentive3.getDate());
        List<Incentive>list=new ArrayList<>();
        list.add(incentive1);
        list.add(incentive2);
        list.add(incentive3);
        return list;
    }
}