package com.oneStopSolutions.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.oneStopSolutions.customer.customerBeans.Customer;
import com.oneStopSolutions.customer.customerBeans.Issue;
import com.oneStopSolutions.customer.customerBeans.Output;
import com.oneStopSolutions.customer.exception.CustomerException;
import com.oneStopSolutions.customer.exception.IssueException;
import com.oneStopSolutions.customer.repository.CustomerRepository;
import com.oneStopSolutions.customer.repository.IssueRepository;

public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private IssueRepository issueRepository;
	
	@Override
	public Output registerCustomer(Customer customer) throws CustomerException {
		/*private Integer customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String mobile;
	private String city;*/
		
//		if()
		return null;
		
	}

	@Override
	public Output createIssue(Issue issue) throws IssueException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Issue> getAllIssuesByCustomerId(Integer Id) throws IssueException {
		// TODO Auto-generated method stub
		return null;
	}

}
