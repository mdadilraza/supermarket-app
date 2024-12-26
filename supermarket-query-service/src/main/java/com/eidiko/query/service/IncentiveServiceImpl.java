package com.eidiko.query.service;

import com.eidiko.query.dao.IncentiveDAO;
import com.eidiko.query.dto.IncentiveDTO;
import com.eidiko.query.exception.IncentiveNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncentiveServiceImpl implements IncentiveService {

    private final IncentiveDAO incentiveDAO;

    public IncentiveServiceImpl(IncentiveDAO incentiveDAO) {
        this.incentiveDAO = incentiveDAO;
    }

    @Override
    public IncentiveDTO getIncentiveById(int id) throws IncentiveNotFoundException {
        return incentiveDAO.findById(id);
    }

    @Override
    public List<IncentiveDTO> getAllIncentives() {
        return incentiveDAO.findAll();
    }

}
