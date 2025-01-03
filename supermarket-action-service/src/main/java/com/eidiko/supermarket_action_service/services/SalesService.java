package com.eidiko.supermarket_action_service.services;
import com.eidiko.supermarket_action_service.dao.SalesRepo;
import com.eidiko.supermarket_action_service.dto.SaleRequest;
import com.eidiko.supermarket_action_service.exceptions.EmployeeNotFoundException;
import com.eidiko.supermarket_action_service.model.Sales;
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

   public Sales addSales(SaleRequest saleRequest) throws EmployeeNotFoundException {
      return salesRepo.addSales(saleRequest);
   }

}
