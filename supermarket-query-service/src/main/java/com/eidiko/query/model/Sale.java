package com.eidiko.query.model;

public class Sale {

    private int id;
    private double saleAmount;
    private String stocks;
    private Employee employeeId;

    public Sale() {
    }

    public Sale(int id, double saleAmount, String stocks, Employee employeeId) {
        this.id = id;
        this.saleAmount = saleAmount;
        this.stocks = stocks;
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
                ", employeeId=" + employeeId +
                '}';
    }

}
