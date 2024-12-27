package com.eidiko.supermarket_integration_service.dto;

import com.eidiko.supermarket_integration_service.model.Employee;

import java.time.LocalDate;
import java.util.List;

public class DetailsDto {
    private Integer id;
    private String name;
    private String phoneNumber;
    private double salary;
    private LocalDate joiningDate;
    private List<String> roles;
    private List<Employee> employees;

    public DetailsDto(Integer id, String name, String phoneNumber, double salary, LocalDate joiningDate, List<String> roles, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.joiningDate = joiningDate;
        this.roles = roles;
        this.employees = employees;
    }
    public DetailsDto(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "DetailsDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", salary=" + salary +
                ", joiningDate=" + joiningDate +
                ", roles=" + roles +
                ", employees=" + employees +
                '}';
    }
}
