package com.eidiko.supermarket_action_service.dto;

import com.eidiko.supermarket_action_service.model.Stocks;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
import java.util.List;

public class SalesDto {

    private int employeeId;
    private List<Stocks> stocks;
    @JsonIgnore
    private double salesAmount;
    @JsonIgnore
    private LocalDateTime saleDate=LocalDateTime.now();

    public SalesDto()
    {
        super();
    }

    public SalesDto(int employeeId, List<Stocks> stocks, double salesAmount,LocalDateTime saleDate) {
        this.employeeId = employeeId;
        this.stocks = stocks;
        this.salesAmount = salesAmount;
        this.saleDate=saleDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public List<Stocks> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stocks> stocks) {
        this.stocks = stocks;
    }

    public double getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(double salesAmount) {
        this.salesAmount = salesAmount;
    }

    @Override
    public String toString() {
        return "SalesDto{" +
                "employeeId=" + employeeId +
                ", stocks=" + stocks +
                ", salesAmount=" + salesAmount +
                '}';
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
    }
}
