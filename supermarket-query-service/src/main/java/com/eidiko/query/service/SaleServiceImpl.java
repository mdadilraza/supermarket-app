package com.eidiko.query.service;

import com.eidiko.query.dao.SaleDAO;
import com.eidiko.query.dto.SaleDTO;
import com.eidiko.query.exception.EmployeeNotFoundException;
import com.eidiko.query.exception.SaleNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleDAO saleDAO;

    @Override
    public SaleDTO getSaleById(int id) throws SaleNotFoundException {
        return saleDAO.findById(id);
    }

    @Override
    public List<SaleDTO> getSalesByEmployeeId(int employeeId) throws EmployeeNotFoundException {
        return saleDAO.findByEmployeeId(employeeId);
    }

    @Override
    public List<SaleDTO> getAllSales() {
        return saleDAO.findAll();
    }

}
