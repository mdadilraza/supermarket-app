package com.eidiko.supermarket_action_service.services;
import com.eidiko.supermarket_action_service.dao.SalesRepo;
import com.eidiko.supermarket_action_service.dto.SaleRequest;
import com.eidiko.supermarket_action_service.exceptions.InsufficientStockException;
import com.eidiko.supermarket_action_service.exceptions.StockNotFoundException;
import com.eidiko.supermarket_action_service.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesService {

   private final SalesRepo salesRepo;

   @Autowired
   public SalesService(SalesRepo salesRepo)
   {
       this.salesRepo=salesRepo;
   }

   public Sale addSales(SaleRequest saleRequest) throws InsufficientStockException, StockNotFoundException {
      return salesRepo.addSales(saleRequest);
   }

}
