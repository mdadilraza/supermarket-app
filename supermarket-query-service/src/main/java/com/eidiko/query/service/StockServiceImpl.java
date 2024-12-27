package com.eidiko.query.service;

import com.eidiko.query.dao.StockDAO;
import com.eidiko.query.exception.StockNotFoundException;
import com.eidiko.query.model.Stock;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    private final StockDAO stockDAO;

    public StockServiceImpl(StockDAO stockDAO) {
        this.stockDAO = stockDAO;
    }

    @Override
    public Stock getStockById(int id) throws StockNotFoundException {
        return this.stockDAO.findById(id);
    }

    @Override
    public List<Stock> getAllStocks() {
        return this.stockDAO.findAll();
    }

}
