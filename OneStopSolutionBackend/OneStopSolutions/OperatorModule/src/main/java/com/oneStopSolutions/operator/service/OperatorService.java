package com.oneStopSolutions.operator.service;

import java.util.List;

import com.oneStopSolutions.customer.customerBeans.Customer;
import com.oneStopSolutions.customer.customerBeans.Issue;
import com.oneStopSolutions.customer.customerBeans.Login;
import com.oneStopSolutions.customer.customerBeans.Output;
import com.oneStopSolutions.operator.Beans.Operator;
import com.oneStopSolutions.operator.Beans.Solution;
import com.oneStopSolutions.operator.dtos.CreateSolutionDto;
import com.oneStopSolutions.operator.dtos.ModifyIssueDto;
import com.oneStopSolutions.operator.exception.OperatorException;
import com.oneStopSolutions.operator.exception.SolutionException;

public interface OperatorService {

	public Operator loginOperator(Login login) throws OperatorException;
	public List<Issue> getIssueByCustomerId(Integer customerId) throws OperatorException;
	public List<Issue> getIssueByType(String issueType) throws OperatorException;
	public Output modifyIssueById(Integer issueId,ModifyIssueDto dto)throws OperatorException;
	public Output closeIssueById(Integer issueId)throws OperatorException;
	public Customer getCustomerById(Integer customerId)throws OperatorException;
	public List<Customer> getCustomerByFirstName(String firstName)throws OperatorException;
	public Customer getCustomerByEmail(String email)throws OperatorException;
	public Output lockCustomerById(Integer customerId)throws OperatorException;
	public Output createSolutionToIssue(Integer issueId, Integer operatorId, CreateSolutionDto dto)throws SolutionException;
	public List<Solution> getAllSolutionToIssue(Integer issueId)throws SolutionException;
	public Output deleteSolutionById(Integer solutionId)throws SolutionException;

}
