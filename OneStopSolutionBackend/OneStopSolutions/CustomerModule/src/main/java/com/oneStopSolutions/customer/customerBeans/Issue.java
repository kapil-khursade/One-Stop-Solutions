package com.oneStopSolutions.customer.customerBeans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Issue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer issueId;
	public String issueType;
	public String issueDescription;
	public boolean issueStatus;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "issues")
	private List<Customer> customers = new ArrayList<>();

}