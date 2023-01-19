package com.oneStopSolutions.operator.service;

import java.util.List;

import com.oneStopSolutions.customer.customerBeans.Customer;
import com.oneStopSolutions.customer.customerBeans.Issue;
import com.oneStopSolutions.customer.customerBeans.Login;
import com.oneStopSolutions.customer.customerBeans.Output;
import com.oneStopSolutions.operator.Beans.Operator;
import com.oneStopSolutions.operator.Beans.Solution;
import com.oneStopSolutions.operator.exception.OperatorException;
import com.oneStopSolutions.operator.exception.SolutionException;

public interface OperatorService {

	public Operator loginOperator(Login login) throws OperatorException;
	public List<Issue> getIssueByCustomerId(Integer Id) throws OperatorException;
	public List<Issue> getIssueByType(String type) throws OperatorException;
	public Output modifyIssueById(Integer Id)throws OperatorException;
	public Output closeIssueById(Integer Id)throws OperatorException;
	public Customer getCustomrById(Integer Id)throws OperatorException;
	public List<Customer> getCustomerByName(String name)throws OperatorException;
	public Customer getCustomerByEmail(String email)throws OperatorException;
	public Output lockCustomerById(Integer Id)throws OperatorException;
	public Output createSolutionToIssue(Integer IssueId, Solution solution)throws SolutionException;
	public List<Solution> getAllSolutionToIssue(Integer IssueId)throws SolutionException;
	public Output deleteSolutionBy(Integer Id)throws SolutionException;

}
