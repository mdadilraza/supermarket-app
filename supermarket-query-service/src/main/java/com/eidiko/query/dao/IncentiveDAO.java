package com.eidiko.query.dao;

import com.eidiko.query.dto.IncentiveDTO;
import com.eidiko.query.exception.IncentiveNotFoundException;

import java.util.List;

public interface IncentiveDAO {

    IncentiveDTO findById(int id) throws IncentiveNotFoundException;

    List<IncentiveDTO> findAll();

}
