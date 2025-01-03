package com.eidiko.query.mapper;

import com.eidiko.query.dto.EmployeeDTO;
import com.eidiko.query.dto.SaleDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SaleMapper implements RowMapper<SaleDTO> {

    @Override
    public SaleDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        SaleDTO saleDTO = new SaleDTO();
        saleDTO.setId(rs.getInt("id"));
        saleDTO.setSaleAmount(rs.getDouble("sales_amount"));
        saleDTO.setStocks(rs.getString("stock"));

        EmployeeDTO employeeDTO = new EmployeeMapper().mapRow(rs, rowNum);
        saleDTO.setEmployeeId(employeeDTO);

        return saleDTO;
    }

}