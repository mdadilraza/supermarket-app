package com.eidiko.supermarket_integration_service.service;

import com.eidiko.supermarket_integration_service.actionClient.SaleActionClient;
import com.eidiko.supermarket_integration_service.dto.SaleRequest;
import com.eidiko.supermarket_integration_service.exception.InsufficientStockException;
import com.eidiko.supermarket_integration_service.exception.StockNotFoundException;
import com.eidiko.supermarket_integration_service.helper.ApiResponseEntity;
import com.eidiko.supermarket_integration_service.model.Sale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleActionClient saleActionClient;

    public SaleServiceImpl(SaleActionClient saleActionClient) {
        this.saleActionClient = saleActionClient;
    }
    Logger logger = LoggerFactory.getLogger(SaleServiceImpl.class);
    @Override
    //For buying the products
    public Sale buySales(SaleRequest sales) throws StockNotFoundException, InsufficientStockException {
        ResponseEntity<ApiResponseEntity<Sale>> apiResponseEntityResponseEntity = saleActionClient.addSales(sales);
        logger.info("sales : {}" ,sales);
        return apiResponseEntityResponseEntity.getBody().getData();
    }
}
