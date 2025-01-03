package com.eidiko.supermarket_integration_service.dto;

import java.time.LocalDateTime;
import java.util.List;

public class SaleDTO {

    private int id;
    private double saleAmount;
    private List<Integer> stocks;
    private LocalDateTime date = LocalDateTime.now();
    private EmployeeDTO employeeId;

    public SaleDTO() {
    }

    public SaleDTO(int id, double saleAmount, List<Integer> stocks, LocalDateTime date, EmployeeDTO employeeId) {
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

    public List<Integer> getStocks() {
        return stocks;
    }

    public void setStocks(List<Integer> stocks) {
        this.stocks = stocks;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public EmployeeDTO getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(EmployeeDTO employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "SaleDTO{" +
                "id=" + id +
                ", saleAmount=" + saleAmount +
                ", stocks=" + stocks +
                ", date=" + date +
                ", employeeId=" + employeeId +
                '}';
    }

}
