package com.oneStopSolutions.operator.Beans;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oneStopSolutions.customer.customerBeans.Issue;

import lombok.AllArgsConstructor;
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
public class Solution {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int solutionId;
	private String solutionDescription;
	private LocalDate solutionDate;
	
	@JsonIgnore
	@ManyToOne
	private Operator operator;
	
	@JsonIgnore
	@ManyToOne
	private Issue issue;
}
