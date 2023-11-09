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
public class NoOfStudentsFailedIn {
	
	private Integer thisSemOnly;
	private Integer prevSem_PassInCurrentSem;

}
