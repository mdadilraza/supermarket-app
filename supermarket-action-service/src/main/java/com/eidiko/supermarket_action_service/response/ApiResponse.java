package com.eidiko.supermarket_action_service.response;

import com.eidiko.supermarket_action_service.model.Employee;
import org.springframework.http.HttpStatus;
public class ApiResponse<T> {

    private String message;
    private HttpStatus code;
    private Employee data;

    public ApiResponse(HttpStatus httpStatus, String employeeAddedSuccessfully, Employee employee) {
    this.code=httpStatus;
    this.message=employeeAddedSuccessfully;
    this.data=employee;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getCode() {
        return code;
    }

    public void setCode(HttpStatus code) {
        this.code = code;
    }

    public Employee getData() {
        return data;
    }

    public void setData(Employee data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "message='" + message + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
}
