package com.eidiko.supermarket_action_service.model;

import java.time.LocalDateTime;
import java.util.List;

public class Sale {

    private int id;
    private double salesAmount;
    private int employeeId;
    private List<Integer> stockId;
    private LocalDateTime saleDate=LocalDateTime.now();

    public Sale()
    {
        super();
    }

    public Sale(int id, double salesAmount, int employeeId, List<Integer> stockId) {
        this.id = id;
        this.salesAmount = salesAmount;
        this.employeeId = employeeId;
        this.stockId = stockId;
    }

    public double getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(double salesAmount) {
        this.salesAmount = salesAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public List<Integer> getStockId() {
        return stockId;
    }

    public void setStockId(List<Integer> stockId) {
        this.stockId = stockId;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "id=" + id +
                ", salesAmount=" + salesAmount +
                ", employeeId=" + employeeId +
                ", stockId=" + stockId +
                '}';
    }
}