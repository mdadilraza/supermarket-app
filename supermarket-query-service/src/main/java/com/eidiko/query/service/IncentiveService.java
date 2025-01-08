package com.eidiko.query.service;

import com.eidiko.query.dto.IncentiveDTO;
import com.eidiko.query.exception.IncentiveNotFoundException;

import java.util.List;

public interface IncentiveService {

    List<IncentiveDTO> getIncentiveById(int id) throws IncentiveNotFoundException;

    List<IncentiveDTO> getAllIncentives();

}
