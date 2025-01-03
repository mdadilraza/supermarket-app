package com.eidiko.supermarket_action_service.dto;

import com.eidiko.supermarket_action_service.model.Stock;

import java.util.List;

public class SaleRequest {

    private int employeeId;
    private List<Stock> stocks;

    public SaleRequest() {
    }

    public SaleRequest(int employeeId, List<Stock> stocks) {
        this.employeeId = employeeId;
        this.stocks = stocks;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
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
        return "SalesDto{" +
                "employeeId=" + employeeId +
                ", stocks=" + stocks +
                '}';
    }
}
