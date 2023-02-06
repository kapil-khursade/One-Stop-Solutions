package com.oneStopSolutions.operator.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateSolutionDto {
	
	private String solutionDescription;
	private LocalDate solutionDate;

}
