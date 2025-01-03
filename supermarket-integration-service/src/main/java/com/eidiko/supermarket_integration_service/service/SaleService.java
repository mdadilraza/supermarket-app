package com.eidiko.supermarket_integration_service.service;

import com.eidiko.supermarket_integration_service.dto.SaleRequest;
import com.eidiko.supermarket_integration_service.exception.InsufficientStockException;
import com.eidiko.supermarket_integration_service.exception.StockNotFoundException;
import com.eidiko.supermarket_integration_service.model.Sale;

public interface SaleService {
    Sale buySales(SaleRequest sales) throws StockNotFoundException, InsufficientStockException;
}
