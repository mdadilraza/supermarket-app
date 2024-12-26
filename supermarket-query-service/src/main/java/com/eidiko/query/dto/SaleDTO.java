package com.eidiko.query.dto;

public class SaleDTO {

    private int id;
    private double saleAmount;
    private String stocks;
    private EmployeeDTO employeeId;

    public SaleDTO() {
    }

    public SaleDTO(int id, double saleAmount, String stocks, EmployeeDTO employeeId) {
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
                ", stocks='" + stocks + '\'' +
                ", employeeId=" + employeeId +
                '}';
    }

}
