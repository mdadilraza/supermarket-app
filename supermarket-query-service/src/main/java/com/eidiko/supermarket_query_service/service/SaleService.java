package com.eidiko.supermarket_query_service.service;

import com.eidiko.supermarket_query_service.exception.SaleNotFoundException;
import com.eidiko.supermarket_query_service.model.Sale;

import java.util.List;

public interface SaleService {

    Sale getSaleById(int id) throws SaleNotFoundException;
    List<Sale> getAllSales();

}
