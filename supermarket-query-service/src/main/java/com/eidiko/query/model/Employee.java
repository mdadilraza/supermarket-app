package com.eidiko.query.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private int id;
    private String name;
    private String email;
    private String password;
    private String designation;
    private String role;
    private String phoneNumber;
    private Date joiningDate;
    private double salary;
    private int reportingTo;

}
