package com.eidiko.supermarket_action_service.services;

import com.eidiko.supermarket_action_service.dao.StocksRepo;
import com.eidiko.supermarket_action_service.exceptions.EmployeeNotFoundException;
import com.eidiko.supermarket_action_service.exceptions.InsufficientStockException;
import com.eidiko.supermarket_action_service.exceptions.StockNotFoundException;
import com.eidiko.supermarket_action_service.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StocksService {

  private final StocksRepo stocksRepo;

    @Autowired
    public StocksService(StocksRepo stocksRepo) {
        this.stocksRepo=stocksRepo;
    }
    public Stock addStocks(Stock stock) {
        return stocksRepo.addStocks(stock);
    }

    public Stock updateStocks(int id, Stock stock)
    {
         return stocksRepo.updateStocks(id, stock);
    }

    public String deleteStock(int id) throws EmployeeNotFoundException {
        return stocksRepo.deleteStock(id);
    }

    public Stock updateStockQuantity(int stockId, int stockQuantity) throws InsufficientStockException, StockNotFoundException {
        return stocksRepo.updateStockQuantity(stockId,stockQuantity);
    }



}
