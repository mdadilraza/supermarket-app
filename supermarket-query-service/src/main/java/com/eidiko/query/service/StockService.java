package com.eidiko.query.service;

import com.eidiko.query.exception.StockNotFoundException;
import com.eidiko.query.model.Stock;

import java.util.List;

public interface StockService {

    Stock getStockById(int id) throws StockNotFoundException;
    List<Stock> getAllStocks();

}
