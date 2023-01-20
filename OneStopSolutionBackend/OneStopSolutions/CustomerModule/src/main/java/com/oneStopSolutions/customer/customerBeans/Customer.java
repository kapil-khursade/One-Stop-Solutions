package com.oneStopSolutions.customer.customerBeans;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String mobile;
	private String city;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Login login;
	
	@OneToMany(targetEntity = Issue.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "ci_fk", referencedColumnName = "customerId")
	private List<Issue> issues = new ArrayList<>();
	
}
