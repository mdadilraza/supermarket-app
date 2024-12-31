package com.eidiko.query.dao;

import com.eidiko.query.dto.EmployeeDTO;
import com.eidiko.query.dto.EmployeeHierarchyDTO;
import com.eidiko.query.exception.EmployeeNotFoundException;
import com.eidiko.query.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO {

    private final JdbcTemplate postgresqlJdbcTemplate;

    public EmployeeDaoImpl(@Qualifier("postgresqlJdbcTemplate") JdbcTemplate jdbcTemplate) {
        this.postgresqlJdbcTemplate = jdbcTemplate;
    }

    @Override
    public EmployeeDTO findById(int id) throws EmployeeNotFoundException {
        String query = "SELECT * FROM employees WHERE id=?";
        try {
            return postgresqlJdbcTemplate.queryForObject(query, new EmployeeMapper(), id);
        } catch (EmptyResultDataAccessException e) {
            throw new EmployeeNotFoundException("Employee Not Found");
        }
    }

    @Override
    public List<EmployeeDTO> findAll() {
        String query = "SELECT * FROM employees";
        return postgresqlJdbcTemplate.query(query, new EmployeeMapper());
    }

    @Override
    public EmployeeHierarchyDTO findHierarchy() throws EmployeeNotFoundException {
        EmployeeDTO employeeDTO = findById(1);
        if (employeeDTO == null) {
            throw new EmployeeNotFoundException("Employee Not Found");
        }

        // To track visited employees and avoid circular references
        Set<Integer> visitedEmployees = new HashSet<>();
        return buildHierarchy(employeeDTO, visitedEmployees);
    }

    private EmployeeHierarchyDTO buildHierarchy(EmployeeDTO employeeDTO, Set<Integer> visitedEmployees) {
        // Check if the employee has already been visited to avoid infinite recursion
        if (visitedEmployees.contains(employeeDTO.getId())) {
            // Return null if this employee has already been processed
            return null;
        }

        // Mark the current employee as visited
        visitedEmployees.add(employeeDTO.getId());

        // Create EmployeeHierarchyDTO for the employee
        EmployeeHierarchyDTO employeeHierarchyDTO = new EmployeeHierarchyDTO();
        employeeHierarchyDTO.setId(employeeDTO.getId());
        employeeHierarchyDTO.setName(employeeDTO.getName());
        employeeHierarchyDTO.setEmail(employeeDTO.getEmail());
        employeeHierarchyDTO.setDesignation(employeeDTO.getDesignation());
        employeeHierarchyDTO.setRole(employeeDTO.getRole());
        employeeHierarchyDTO.setPhoneNumber(employeeDTO.getPhoneNumber());
        employeeHierarchyDTO.setJoiningDate(employeeDTO.getJoiningDate());
        employeeHierarchyDTO.setSalary(employeeDTO.getSalary());

        // Get the subordinates (employees who report to this one)
        List<EmployeeDTO> subordinates = findSubordinates(employeeDTO.getId());

        // Recursively build hierarchy for each subordinate
        List<EmployeeHierarchyDTO> subordinateHierarchyList = new ArrayList<>();
        for (EmployeeDTO subordinate : subordinates) {
            EmployeeHierarchyDTO subordinateHierarchy = buildHierarchy(subordinate, visitedEmployees);
            if (subordinateHierarchy != null) {
                subordinateHierarchyList.add(subordinateHierarchy);
            }
        }

        // Set the subordinates in the employee hierarchy DTO
        employeeHierarchyDTO.setEmployees(subordinateHierarchyList);
        return employeeHierarchyDTO;
    }

    // Helper method to find subordinates (employees reporting to a specific employee)
    private List<EmployeeDTO> findSubordinates(int managerId) {
        // Assuming this is where you'd fetch subordinates from the database based on the manager's ID.
        String query = "SELECT * FROM employees WHERE reporting_to = ?";
        return postgresqlJdbcTemplate.query(query, new EmployeeMapper(), managerId);
    }

}
