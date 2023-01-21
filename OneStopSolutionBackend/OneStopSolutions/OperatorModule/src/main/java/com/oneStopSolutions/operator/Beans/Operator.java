package com.oneStopSolutions.operator.Beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;

import com.oneStopSolutions.customer.customerBeans.Login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Operator {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int operatorId;
	private String operatorFirstName;
	private String operatorLastName;
	private String operatorEmail;
	private String operatorMobile;
	private String operatorType;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Login login;
	
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "operator")
	private Set<Solution> solutions=new HashSet<Solution>();
}
