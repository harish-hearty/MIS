package com.example.MIS.results;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class Results {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String deptWithYearSec;
	private Integer classStrength;
	private Integer studentsAppeared;
	private Integer studentsPassed;
	private Double overallPassPercentage;
	@Embedded
	private OverallPassPercentageLast3Years overallPassPercentageLast3Years ;
	@Embedded
	private StudentsFailedIn studentsFailedIn;
	@Embedded
	private NoOfStudentsFailedIn noOfStudentsFailedIn;
	private String batch;
	private String sem;
}
