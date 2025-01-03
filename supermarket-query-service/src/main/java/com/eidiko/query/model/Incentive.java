package com.eidiko.query.model;

import java.time.LocalDate;

public class Incentive {

    private int id;
    private double incentiveAmount;
    private Employee employeeId;
    private Sale saleId;
    private LocalDate date = LocalDate.now();

    public Incentive() {
    }

    public Incentive(int id, double incentiveAmount, Employee employeeId, Sale saleId, LocalDate date) {
        this.id = id;
        this.incentiveAmount = incentiveAmount;
        this.employeeId = employeeId;
        this.saleId = saleId;
        this.date = date;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Incentive{" +
                "id=" + id +
                ", incentiveAmount=" + incentiveAmount +
                ", employeeId=" + employeeId +
                ", saleId=" + saleId +
                ", date=" + date +
                '}';
    }

}