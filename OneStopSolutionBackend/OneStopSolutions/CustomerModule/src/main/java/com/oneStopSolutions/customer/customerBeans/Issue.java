package com.oneStopSolutions.customer.customerBeans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter

@Getter

@AllArgsConstructor

@NoArgsConstructor

@ToString
@Entity
public class Issue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer issueId;
	public String issueType;
	public String issueDescription;
	
	@Column(columnDefinition = "BOOLEAN") // STORES 1 IF true AND 0 IF false
	public boolean issueStatus;

}