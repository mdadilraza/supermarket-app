package com.eidiko.supermarket_action_service.exceptions;

public class StockNotFoundException extends Exception{

    public StockNotFoundException(String message)
    {
        super(message);
    }
}
