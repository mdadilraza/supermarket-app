package com.eidiko.supermarket_action_service.response;
import org.springframework.http.HttpStatus;
public class ApiResponse<T> {

    private String message;
    private HttpStatus code;
    private T data;

    public ApiResponse(HttpStatus httpStatus, String employeeAddedSuccessfully,T t) {
    this.code=httpStatus;
    this.message=employeeAddedSuccessfully;
    this.data=t;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
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
