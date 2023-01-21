package com.oneStopSolutions.customer.dtoes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegisterCustomerDto {

	private String firstName;
	private String lastName;
	private String email;
	private String city;
	private String username;
	private String password;

}
