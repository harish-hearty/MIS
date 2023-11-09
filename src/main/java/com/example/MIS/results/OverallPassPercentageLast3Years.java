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
public class OverallPassPercentageLast3Years {
	private Double lastYear1;
	private Double lastYear2;
	private Double lastYear3;
}
