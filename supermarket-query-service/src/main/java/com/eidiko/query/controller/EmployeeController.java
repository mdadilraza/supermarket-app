package com.eidiko.query.controller;

import com.eidiko.query.dto.EmployeeDTO;
import com.eidiko.query.dto.EmployeeHierarchyDTO;
import com.eidiko.query.exception.EmployeeNotFoundException;
import com.eidiko.query.response.ApiResponseEntity;
import com.eidiko.query.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Tag(name = "Employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    @Operation(
            summary = "gets employee using employee id",
            description = "this end point allows to fetch employee data by using employee id",
            parameters = {
                    @Parameter(name = "id", description = "Employee Id", required = true, in = ParameterIn.PATH)
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Ok"),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    public ResponseEntity<ApiResponseEntity<EmployeeDTO>> getEmployeeById(@PathVariable int id)
            throws EmployeeNotFoundException {
        return ResponseEntity.ok(new ApiResponseEntity<>(
                HttpStatus.OK,
                "Employee Fetched",
                employeeService.getEmployeeById(id)
        ));
    }

    @GetMapping
    @Operation(
            summary = "gets all employees",
            description = "this end point allows to fetch all employees data",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Ok"),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    public ResponseEntity<ApiResponseEntity<List<EmployeeDTO>>> getAllEmployees() {
        return ResponseEntity.ok(new ApiResponseEntity<>(
                HttpStatus.OK,
                "Employees Fetched",
                employeeService.getAllEmployees()
        ));
    }

    @GetMapping("/hierarchy")
    @Operation(
            summary = "gets all employee hierarchy",
            description = "this end point allows to fetch all employee hierarchy",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Ok"),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    public ResponseEntity<ApiResponseEntity<EmployeeHierarchyDTO>> getHierarchy() throws EmployeeNotFoundException {
        return ResponseEntity.ok(new ApiResponseEntity<>(
                HttpStatus.OK,
                "Hierarchy Fetched",
                employeeService.getAllEmployeesHierarchy()
        ));
    }

    @GetMapping("/hierarchy/{id}")
    @Operation(
            summary = "gets employee hierarchy employee id",
            description = "this end point allows to fetch employee hierarchy by using employee id",
            parameters = {
                    @Parameter(name = "id", description = "Employee Id", required = true, in = ParameterIn.PATH)
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Ok"),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    public ResponseEntity<ApiResponseEntity<List<Integer>>> getHierarchyById(@PathVariable int id)
            throws EmployeeNotFoundException {
        return ResponseEntity.ok(new ApiResponseEntity<>(
                HttpStatus.OK,
                "Hierarchy Fetched",
                employeeService.getEmployeeHierarchyById(id)
        ));
    }

}
