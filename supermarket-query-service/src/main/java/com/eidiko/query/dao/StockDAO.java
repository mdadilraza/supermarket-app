package com.eidiko.query.dao;

import com.eidiko.query.exception.StockNotFoundException;
import com.eidiko.query.model.Stock;

import java.util.List;

public interface StockDAO {

    Stock findById(int id) throws StockNotFoundException;

    List<Stock> findAll();

}
