package com.eidiko.supermarket_integration_service.dto;

public class IncentiveDTO {

    private int id;
    private double incentiveAmount;
    private EmployeeDTO employeeId;
    private SaleDTO saleId;

    public IncentiveDTO() {
    }

    public IncentiveDTO(int id, double incentiveAmount, EmployeeDTO employeeId, SaleDTO saleId) {
        this.id = id;
        this.incentiveAmount = incentiveAmount;
        this.employeeId = employeeId;
        this.saleId = saleId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getIncentiveAmount() {
        return incentiveAmount;
    }

    public void setIncentiveAmount(double incentiveAmount) {
        this.incentiveAmount = incentiveAmount;
    }

    public EmployeeDTO getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(EmployeeDTO employeeId) {
        this.employeeId = employeeId;
    }

    public SaleDTO getSaleId() {
        return saleId;
    }

    public void setSaleId(SaleDTO saleId) {
        this.saleId = saleId;
    }

    @Override
    public String toString() {
        return "IncentiveDTO{" +
                "id=" + id +
                ", incentiveAmount=" + incentiveAmount +
                ", employeeId=" + employeeId +
                ", saleId=" + saleId +
                '}';
    }

}
