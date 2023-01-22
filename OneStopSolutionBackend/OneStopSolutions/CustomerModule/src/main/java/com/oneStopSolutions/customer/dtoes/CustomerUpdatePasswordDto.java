package com.oneStopSolutions.customer.dtoes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerUpdatePasswordDto {
	
	// GETS THE DATA FROM USER TO CHANGE THE PASSWORD

	private String oldPassword;
	private String newPassword;

}
