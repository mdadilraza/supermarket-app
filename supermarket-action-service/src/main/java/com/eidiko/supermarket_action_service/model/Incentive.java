package com.eidiko.supermarket_action_service.model;

import java.time.LocalDate;

public class Incentive {

    private int id;
    private int employeeId;
    private int salesId;
    private double incentiveAmount;
    private LocalDate date;

    public Incentive() {
    }

    public Incentive(int id, int employeeId, int salesId, double incentiveAmount, LocalDate date) {
        this.id = id;
        this.employeeId = employeeId;
        this.salesId = salesId;
        this.incentiveAmount = incentiveAmount;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getSalesId() {
        return salesId;
    }

    public void setSalesId(int salesId) {
        this.salesId = salesId;
    }

    public double getIncentiveAmount() {
        return incentiveAmount;
    }

    public void setIncentiveAmount(double incentiveAmount) {
        this.incentiveAmount = incentiveAmount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Incentives{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", salesId=" + salesId +
                ", incentiveAmount=" + incentiveAmount +
                ", date=" + date +
                '}';
    }
}
