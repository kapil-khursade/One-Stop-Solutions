package com.oneStopSolutions.customer.service;

import java.util.List;

import com.oneStopSolutions.customer.customerBeans.Customer;
import com.oneStopSolutions.customer.customerBeans.Issue;
import com.oneStopSolutions.customer.customerBeans.Login;
import com.oneStopSolutions.customer.customerBeans.Output;
import com.oneStopSolutions.customer.exception.CustomerException;
import com.oneStopSolutions.customer.exception.IssueException;
import com.oneStopSolutions.customer.exception.LoginException;

public interface CustomerService {

	public Output registerCustomer(Customer customer) throws CustomerException;

	public Customer customerLogin(Login login) throws LoginException;

	public Output createIssue(Issue issue) throws IssueException;

	public List<Issue> getAllIssuesByCustomerId(Integer Id) throws IssueException;

	public Issue getIssueId(Integer Id) throws IssueException;

	public Output deleteIssueId(Integer Id) throws IssueException;

	public Output reopenIssueById(Integer Id) throws IssueException;

	public Output updatePassword(Integer id, String oldPassword, String newPassword) throws CustomerException;

}
