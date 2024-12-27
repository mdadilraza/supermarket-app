package com.eidiko.supermarket_integration_service.service;

import com.eidiko.supermarket_integration_service.dto.SaleDto;
import com.eidiko.supermarket_integration_service.exception.InsufficientStockException;
import com.eidiko.supermarket_integration_service.exception.StockNotFoundException;
import com.eidiko.supermarket_integration_service.model.Sale;

public interface SaleService {
    Sale buySales(SaleDto sales) throws StockNotFoundException, InsufficientStockException;
}
