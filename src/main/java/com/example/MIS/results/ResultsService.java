package com.example.MIS.results;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ResultsService {
	
	@Autowired
	ResultsRepo repo;
	
	@Transactional
	public boolean addNewData(Results result) throws DataAccessException{	
		Optional<Results> res	= repo.findByDeptWithYearSecAndBatchAndSem(
				result.getDeptWithYearSec(),
				result.getBatch(),
				result.getSem());
		if(res.isPresent())
			return false;
		else {
			repo.save(result);
			return true;
		}	
	}
	
	@Transactional
	public List<Results> getData() throws DataAccessException {
		return repo.findAll();
	}
	
//	@Transactional
//	public boolean updateData(Results result) throws DataAccessException{
//		
//	}
}
