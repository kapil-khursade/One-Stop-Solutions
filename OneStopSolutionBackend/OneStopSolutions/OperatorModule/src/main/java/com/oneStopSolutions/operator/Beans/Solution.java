package com.oneStopSolutions.operator.Beans;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Solution {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int solutionId;
	private String solutionDescription;
	private Date solutionDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Operator operator;
}
