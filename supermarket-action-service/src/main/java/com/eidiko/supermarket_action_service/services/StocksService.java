package com.eidiko.supermarket_action_service.services;

import com.eidiko.supermarket_action_service.dao.StocksRepo;
import com.eidiko.supermarket_action_service.exceptions.EmployeeNotFoundException;
import com.eidiko.supermarket_action_service.exceptions.StockNotFoundException;
import com.eidiko.supermarket_action_service.model.Stocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StocksService {

  private final StocksRepo stocksRepo;

    @Autowired
    public StocksService(StocksRepo stocksRepo) {
        this.stocksRepo=stocksRepo;
    }
    public Stocks addStocks(Stocks stock) {
        return stocksRepo.addStocks(stock);
    }

    public void updateStocks(int id,Stocks stocks)
    {
         stocksRepo.updateStocks(id,stocks);
    }

    public String deleteStock(int id) throws StockNotFoundException, EmployeeNotFoundException {
        return stocksRepo.deleteStock(id);
    }

    public String updateStockQuantity(int stockId,int stockQuantity)
    {
        return stocksRepo.updateStockQuantity(stockId,stockQuantity);
    }



}
