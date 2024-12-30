package com.eidiko.query.model;

import java.time.LocalDateTime;

public class Sale {

    private int id;
    private double saleAmount;
    private String stocks;
    private LocalDateTime date = LocalDateTime.now();
    private Employee employeeId;

    public Sale() {
    }

    public Sale(int id, double saleAmount, String stocks, LocalDateTime date, Employee employeeId) {
        this.id = id;
        this.saleAmount = saleAmount;
        this.stocks = stocks;
        this.date = date;
        this.employeeId = employeeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(double saleAmount) {
        this.saleAmount = saleAmount;
    }

    public String getStocks() {
        return stocks;
    }

    public void setStocks(String stocks) {
        this.stocks = stocks;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", saleAmount=" + saleAmount +
                ", stocks='" + stocks + '\'' +
                ", date=" + date +
                ", employeeId=" + employeeId +
                '}';
    }

}
