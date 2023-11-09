package com.example.MIS.results;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class StudentsFailedIn {
	
	private Integer sub1;
	private Integer sub2;
	private Integer sub3;
	private Integer subMoreThan3;
	private Integer subFailed;
	
}
