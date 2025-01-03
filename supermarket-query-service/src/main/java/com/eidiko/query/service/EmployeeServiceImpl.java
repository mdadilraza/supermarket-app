package com.eidiko.query.service;

import com.eidiko.query.dao.EmployeeDAO;
import com.eidiko.query.dto.EmployeeDTO;
import com.eidiko.query.dto.EmployeeHierarchyDTO;
import com.eidiko.query.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public EmployeeDTO getEmployeeById(int id) throws EmployeeNotFoundException {
        return employeeDAO.findById(id);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeDAO.findAll();
    }

    @Override
    public EmployeeHierarchyDTO getAllEmployeesHierarchy() throws EmployeeNotFoundException {
        EmployeeDTO employeeDTO = employeeDAO.findById(1);
        if (employeeDTO == null) {
            throw new EmployeeNotFoundException("Employee Not Found");
        }

        // To track visited employees and avoid circular references
        Set<Integer> visitedEmployees = new HashSet<>();
        return buildHierarchy(employeeDTO, visitedEmployees);
    }

    @Override
    public List<Integer> getEmployeeHierarchyById(int id) throws EmployeeNotFoundException {
        Set<Integer> visited = new HashSet<>();
        List<Integer> hierarchyList = new ArrayList<>();
        fetchEmployeeHierarchy(id, hierarchyList, visited);
        return hierarchyList;
    }

    private void fetchEmployeeHierarchy(int employeeId, List<Integer> hierarchyList, Set<Integer> visited)
            throws EmployeeNotFoundException {

        if (visited.contains(employeeId)) {
            throw new IllegalStateException(
                    "Circular dependency detected in employee hierarchy for Employee ID: " + employeeId
            );
        }

        visited.add(employeeId);

        EmployeeDTO employeeDTO = employeeDAO.findById(employeeId);
        EmployeeDTO manager = employeeDAO.findById(employeeDTO.getReportingTo());

        hierarchyList.add(manager.getId());
        if (manager.getDesignation().contains("Sales Supervisor")) {
            return;
        }

        if (manager.getReportingTo() != 0) {
            fetchEmployeeHierarchy(manager.getId(), hierarchyList, visited);
        }
    }

    private EmployeeHierarchyDTO buildHierarchy(EmployeeDTO employeeDTO, Set<Integer> visitedEmployees) {
        // Check if the employee has already been visited to avoid infinite recursion
        if (visitedEmployees.contains(employeeDTO.getId())) {
            // Return null if this employee has already been processed
            return null;
        }

        // Mark the current employee as visited
        visitedEmployees.add(employeeDTO.getId());

        return createEmployeeHierarchy(employeeDTO, visitedEmployees);
    }

    private EmployeeHierarchyDTO createEmployeeHierarchy(EmployeeDTO employeeDTO, Set<Integer> visitedEmployees) {
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
        return employeeDAO.findByReportingTo(managerId);
    }

}
