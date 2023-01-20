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
	
	@Column(unique = true)
	private String username;
	
	@Column(unique = true)
	private String password;
	
	@Enumerated(EnumType.STRING)
	private UserType type;
	
	@Column(columnDefinition = "BOOLEAN")
	private boolean isActive;
	
	
}
