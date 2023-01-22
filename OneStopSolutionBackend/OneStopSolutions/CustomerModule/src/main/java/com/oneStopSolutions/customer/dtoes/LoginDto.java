package com.oneStopSolutions.customer.dtoes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginDto {

	// GETS THE DATA FROM USER FOR LOGIN
	
	private String username;
	private String password;
	
}
