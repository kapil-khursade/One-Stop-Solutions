package com.oneStopSolutions.customer.service;

import java.util.List;

import com.oneStopSolutions.customer.customerBeans.Customer;
import com.oneStopSolutions.customer.customerBeans.Issue;
import com.oneStopSolutions.customer.customerBeans.Output;
import com.oneStopSolutions.customer.dtoes.CreateIssueDto;
import com.oneStopSolutions.customer.dtoes.CustomerUpdatePasswordDto;
import com.oneStopSolutions.customer.dtoes.LoginDto;
import com.oneStopSolutions.customer.dtoes.RegisterCustomerDto;
import com.oneStopSolutions.customer.exception.CustomerException;
import com.oneStopSolutions.customer.exception.IssueException;
import com.oneStopSolutions.customer.exception.LoginException;

public interface CustomerService {

	public Output registerCustomer(RegisterCustomerDto dto) throws CustomerException;

	public Customer customerLogin(LoginDto dto) throws LoginException;

	public Output createIssue(CreateIssueDto dto, Integer customerId) throws IssueException;

	public List<Issue> getAllIssuesByCustomerId(Integer customerId) throws IssueException;

	public Issue getIssueId(Integer issueId) throws IssueException;

	public Output deleteIssueId(Integer issueId) throws IssueException;

	public Output reopenIssueById(Integer issueId) throws IssueException;

	public Output updatePassword(CustomerUpdatePasswordDto dto, Integer customerId) throws CustomerException;

}
