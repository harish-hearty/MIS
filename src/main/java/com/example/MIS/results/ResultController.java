package com.example.MIS.results;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/srm/mis/results")
@RequiredArgsConstructor
public class ResultController {
	
	@Autowired
	ResultsService resultService;
	
	@PostMapping("/addData")
	ResponseEntity<String> addData(@RequestBody Results result){
		if(resultService.addNewData(result))
			return new ResponseEntity<>("Data stored", HttpStatus.OK);	
		else 
			return new ResponseEntity<>("Data already stored", HttpStatus.CONFLICT);		
	}
	
	@GetMapping("/getData")
	ResponseEntity<List<Results>> getData(){
		return ResponseEntity.ok(resultService.getData());
	}
	
	@PutMapping("/modify")
	ResponseEntity<String> modify(@RequestBody Results result){
		
		return new ResponseEntity<>("data modified", HttpStatus.OK);
	}
	

}
