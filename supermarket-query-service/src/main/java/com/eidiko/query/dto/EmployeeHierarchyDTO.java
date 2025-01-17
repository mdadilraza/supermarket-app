package com.eidiko.query.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeHierarchyDTO {

    private int id;
    private String name;
    private String email;
    private String designation;
    private String role;
    private String phoneNumber;
    private Date joiningDate;
    private double salary;
    private List<EmployeeHierarchyDTO> employees;

}
