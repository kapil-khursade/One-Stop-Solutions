package com.oneStopSolutions.operator.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModifyIssueDto {
	
	public String issueType;
	public String issueDescription;
	
}
