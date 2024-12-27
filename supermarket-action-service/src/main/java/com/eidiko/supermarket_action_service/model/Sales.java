package com.eidiko.supermarket_action_service.model;

import java.util.List;

public class Sales {

    private int id;
    private double salesAmount;
    private Employee employeeId;
    private List<Integer> stockId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(double salesAmount) {
        this.salesAmount = salesAmount;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public List<Integer> getStockId() {
        return stockId;
    }

    public void setStockId(List<Integer> stockId) {
        this.stockId = stockId;
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
