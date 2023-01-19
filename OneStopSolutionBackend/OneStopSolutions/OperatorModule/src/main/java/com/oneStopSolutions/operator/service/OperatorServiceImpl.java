package com.oneStopSolutions.operator.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneStopSolutions.customer.customerBeans.Customer;
import com.oneStopSolutions.customer.customerBeans.Issue;
import com.oneStopSolutions.customer.customerBeans.Login;
import com.oneStopSolutions.customer.customerBeans.Output;
import com.oneStopSolutions.customer.repository.CustomerRepository;
import com.oneStopSolutions.operator.Beans.Operator;
import com.oneStopSolutions.operator.Beans.Solution;
import com.oneStopSolutions.operator.exception.OperatorException;
import com.oneStopSolutions.operator.exception.SolutionException;
import com.oneStopSolutions.operator.repository.OperatorDao;
import com.oneStopSolutions.operator.repository.SolutionDao;

@Service
public class OperatorServiceImpl implements OperatorService {

	@Autowired
	private OperatorDao operatorDao;
	
	@Autowired
	private SolutionDao solutionDao;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	@Override
	public Operator loginOperator(Login login) throws OperatorException {
		
		
		
		
		return null;
	}


	@Override
	public List<Issue> getIssueByCustomerId(Integer Id) throws OperatorException {
		
		
		
		return null;
	}


	@Override
	public List<Issue> getIssueByType(String type) throws OperatorException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Output modifyIssueById(Integer Id) throws OperatorException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Output closeIssueById(Integer Id) throws OperatorException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Customer getCustomrById(Integer Id) throws OperatorException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Customer> getCustomerByName(String name) throws OperatorException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Customer getCustomerByEmail(String email) throws OperatorException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Output lockCustomerById(Integer Id) throws OperatorException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Output createSolutionToIssue(Integer IssueId, Solution solution) throws SolutionException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Solution> getAllSolutionToIssue(Integer IssueId) throws SolutionException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Output deleteSolutionBy(Integer Id) throws SolutionException {
		// TODO Auto-generated method stub
		return null;
	}

}
