package com.eidiko.supermarket_integration_service.service;

import com.eidiko.supermarket_integration_service.queryclient.StocksQueryClient;
import com.eidiko.supermarket_integration_service.dto.SaleDto;
import com.eidiko.supermarket_integration_service.exception.InsufficientStockException;
import com.eidiko.supermarket_integration_service.exception.StockNotFoundException;
import com.eidiko.supermarket_integration_service.model.Sale;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImpl implements SaleService {

    private final StocksQueryClient client;

    public SaleServiceImpl(StocksQueryClient client) {
        this.client = client;
    }

    @Override
    //For buying the products
    public Sale buySales(SaleDto salesDto) throws StockNotFoundException, InsufficientStockException {

//        ApiResponse<DetailsDto> apiResponse=getEmployeeApiResponse(salesDto.getEmployeeId());
//        DetailsDto detailsDTO =  apiResponse.getData();
//        salesDto.setEmployeeId(detailsDTO.getId());
//
//        List<Stock> stockList =salesDto.getStocks();
//        List<Stock>list=new ArrayList<>();
//
//        for(Stock stock : stockList)
//        {
//            ApiResponse<Stock> stockApiResponse=stockApiResponse(stock.getId());
//            if(stockApiResponse==null)
//            {
//                throw new StockNotFoundException("Stock with id " + stock.getId() + " is not found");
//            }
//            Stock stock1=stockApiResponse.getData();
//            String s=updateStockQuantity(stock.getId(),stock.getQuantity());
//            System.out.println(s);
//            if(s.contains("BAD_REQUEST"))
//            {
//                throw new InsufficientStockException("Insufficient stock Exception \nRequested quantity: "
//                        +stock1.getQuantity() +"\navailable quantity: "+stock.getQuantity());
//            }
//            list.add(stock1);
//        }
//        salesDto.setStocks(list);
//        double totalAmount=0;
//        for(Stock stock:salesDto.getStocks())
//        {
//            totalAmount=totalAmount+(stock.getPrice()*stock.getQuantity());
//        }
//        salesDto.setSalesAmount(totalAmount);
//        Sale sales=new Sale();
//        sales.setSaleAmount(salesDto.getSalesAmount());
//        sales.setStocks(salesDto.getStocks().toString());
//        sales.setEmployeeId(salesDto.getEmployeeId());
//        return salesRepo.save(sales);
//
//    }
//    //Returns Stock object based on stockId
//    public ApiResponse<Stock> stockApiResponse(int stockId)
//    {
//        Stock stock = client.getStockById(stockId);
//        ApiResponse response = new ApiResponse();
//        response.setStatus(HttpStatus.OK);
//        response.setData(stock);
//        response.setMessage(response.getMessage());
//        return response;
//    }
        return null;
    }
}
