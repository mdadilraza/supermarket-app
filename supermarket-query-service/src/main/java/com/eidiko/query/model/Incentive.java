package com.eidiko.query.model;

public class Incentive {

    private int id;
    private double incentiveAmount;
    private Employee employeeId;
    private Sale saleId;

    public Incentive() {
    }

    public Incentive(int id, double incentiveAmount, Employee employeeId, Sale saleId) {
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

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public Sale getSaleId() {
        return saleId;
    }

    public void setSaleId(Sale saleId) {
        this.saleId = saleId;
    }

    @Override
    public String toString() {
        return "Incentive{" +
                "id=" + id +
                ", incentiveAmount=" + incentiveAmount +
                ", employeeId=" + employeeId +
                ", saleId=" + saleId +
                '}';
    }

}