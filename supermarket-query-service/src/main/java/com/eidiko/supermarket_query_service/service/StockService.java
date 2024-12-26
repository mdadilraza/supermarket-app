package com.eidiko.supermarket_query_service.service;

import com.eidiko.supermarket_query_service.exception.StockNotFoundException;
import com.eidiko.supermarket_query_service.model.Stock;

import java.util.List;

public interface StockService {

    Stock getStockById(int id) throws StockNotFoundException;
    List<Stock> getAllStocks();

}
