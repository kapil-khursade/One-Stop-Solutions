package com.oneStopSolutions.customer.customerBeans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer LoginId;

	@Column(unique = true) // VALUES MUST BE UNIQUE
	private String username;

	@Column(unique = true) // VALUES MUST BE UNIQUE
	private String password;

	@Enumerated(EnumType.STRING) // VALUES : [ ADMIN / OPERATOR / CUSTOMER ]
	private UserType type;

	@Column(columnDefinition = "BOOLEAN") // STORES 1 IF true AND 0 IF false
	private boolean isActive;

}
