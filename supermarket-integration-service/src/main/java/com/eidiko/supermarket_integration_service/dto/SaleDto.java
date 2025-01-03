package com.eidiko.supermarket_integration_service.dto;

import com.eidiko.supermarket_integration_service.model.Stock;

import java.time.LocalDateTime;
import java.util.List;

public class SaleDto {
    private Integer salesId;
    private double salesAmount;
    private LocalDateTime salesDate;
    private Integer employeeId;
    private List<Stock> stocks;

    public SaleDto(Integer salesId, double salesAmount, LocalDateTime salesDate, Integer employeeId, List<Stock> stocks) {
        this.salesId = salesId;
        this.salesAmount = salesAmount;
        this.salesDate = salesDate;
        this.employeeId = employeeId;
        this.stocks = stocks;
    }

    public Integer getSalesId() {
        return salesId;
    }

    public void setSalesId(Integer salesId) {
        this.salesId = salesId;
    }

    public double getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(double salesAmount) {
        this.salesAmount = salesAmount;
    }

    public LocalDateTime getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(LocalDateTime salesDate) {
        this.salesDate = salesDate;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    @Override
    public String toString() {
        return "SaleDto{" +
                "salesId=" + salesId +
                ", salesAmount=" + salesAmount +
                ", salesDate=" + salesDate +
                ", employeeId=" + employeeId +
                ", stocks=" + stocks +
                '}';
    }
}
