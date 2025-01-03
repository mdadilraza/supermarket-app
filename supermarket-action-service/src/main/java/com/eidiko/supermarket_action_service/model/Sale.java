package com.eidiko.supermarket_action_service.model;
import java.time.LocalDateTime;
import java.util.List;

public class Sale {

    private int id;
    private double saleAmount;
    private Employee employeeId;
    private List<Integer> stocks;
    private LocalDateTime saleDate=LocalDateTime.now();

    public Sale() {
    }

    public Sale(int id, double saleAmount, Employee employeeId, List<Integer> stocks, LocalDateTime saleDate) {
        this.id = id;
        this.saleAmount = saleAmount;
        this.employeeId = employeeId;
        this.stocks = stocks;
        this.saleDate = saleDate;
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

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public List<Integer> getStocks() {
        return stocks;
    }

    public void setStocks(List<Integer> stocks) {
        this.stocks = stocks;
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
                ", saleAmount=" + saleAmount +
                ", employeeId=" + employeeId +
                ", stocks=" + stocks +
                ", saleDate=" + saleDate +
                '}';
    }
}
