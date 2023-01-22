package com.oneStopSolutions.customer.dtoes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateIssueDto {
	
	// GETS THE DATA FROM USER TO CREATE AN ISSUE
	
	private String issueType;
	private String issueDescription;

}
