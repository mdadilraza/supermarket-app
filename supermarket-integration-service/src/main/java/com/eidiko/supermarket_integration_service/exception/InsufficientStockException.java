package com.eidiko.supermarket_integration_service.exception;

public class InsufficientStockException extends RuntimeException {
    public InsufficientStockException(String s) {
        super(s);
    }
}
