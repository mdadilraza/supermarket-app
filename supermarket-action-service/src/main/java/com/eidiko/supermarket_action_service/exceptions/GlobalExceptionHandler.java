package com.eidiko.supermarket_action_service.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ProblemDetail handleEmployeeNotFoundException(EmployeeNotFoundException exception)
    {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,exception.getMessage());
    }

    @ExceptionHandler(StockNotFoundException.class)
    public ProblemDetail handleStockNotFoundException(StockNotFoundException stockNotFoundException)
    {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,stockNotFoundException.getMessage());
    }

    @ExceptionHandler(InsufficientStockException.class)
    public ProblemDetail handleInsufficientStockException(InsufficientStockException exception)
    {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,exception.getMessage());
    }

}
