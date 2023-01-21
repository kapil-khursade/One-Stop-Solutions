package com.oneStopSolutions.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddOperatorDto {
	
	private String operatorFirstName;
	private String operatorLastName;
	private String operatorEmail;
	private String operatorMobile;
	private String operatorType;
	private Integer departmentId;
	private String username;
	private String password;

}
