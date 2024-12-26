package com.eidiko.supermarket_action_service.services;

import com.eidiko.supermarket_action_service.dao.StocksRepo;
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
    public String addStocks(Stocks stock) {
        return stocksRepo.addStocks(stock);
    }
}
