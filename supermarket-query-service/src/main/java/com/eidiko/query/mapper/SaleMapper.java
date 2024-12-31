package com.eidiko.query.mapper;

import com.eidiko.query.dto.EmployeeDTO;
import com.eidiko.query.dto.SaleDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SaleMapper implements RowMapper<SaleDTO> {

    @Override
    public SaleDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        SaleDTO saleDTO = new SaleDTO();
        saleDTO.setId(rs.getInt("id"));
        saleDTO.setSaleAmount(rs.getDouble("sales_amount"));
        List<Integer> numbersList = new ArrayList<>();
        Object[] numbersArray = (Object[]) rs.getArray("stock").getArray();
        if (numbersArray != null) {
            for (Object number : numbersArray) {
                if (number != null) {
                    numbersList.add((Integer) number);
                }
            }
        }
        saleDTO.setStocks(numbersList);
        saleDTO.setDate(rs.getTimestamp("date").toLocalDateTime());
        EmployeeDTO employeeDTO = new EmployeeMapper().mapRow(rs, rowNum);
        saleDTO.setEmployeeId(employeeDTO);

        return saleDTO;
    }

}
