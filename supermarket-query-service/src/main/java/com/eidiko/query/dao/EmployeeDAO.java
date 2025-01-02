package com.eidiko.query.dao;

import com.eidiko.query.dto.EmployeeDTO;
import com.eidiko.query.dto.EmployeeHierarchyDTO;
import com.eidiko.query.exception.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeDAO {

    EmployeeDTO findById(int id) throws EmployeeNotFoundException;

    List<EmployeeDTO> findAll();

    EmployeeHierarchyDTO findHierarchy() throws EmployeeNotFoundException;

    List<Integer> findHierarchyById(int id) throws EmployeeNotFoundException;
}
