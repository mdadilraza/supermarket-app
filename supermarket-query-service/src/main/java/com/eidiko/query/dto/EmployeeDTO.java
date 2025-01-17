package com.eidiko.query.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private int id;
    private String name;
    private String email;
    private String designation;
    private String role;
    private String phoneNumber;
    private Date joiningDate;
    private double salary;
    private int reportingTo;

}
