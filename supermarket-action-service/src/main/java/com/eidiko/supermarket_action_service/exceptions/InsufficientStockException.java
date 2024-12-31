package com.eidiko.supermarket_action_service.exceptions;

public class InsufficientStockException  extends Exception{

    public InsufficientStockException(String message)
    {
        super(message);
    }
}
