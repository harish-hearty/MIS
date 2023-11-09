package com.example.MIS.results;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultsRepo extends JpaRepository<Results, String> {
	
	Optional<Results> findByDeptWithYearSecAndBatchAndSem(String deptWithYearSec, String batch, String sem);
	
}
