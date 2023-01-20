package com.oneStopSolutions.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneStopSolutions.customer.customerBeans.Customer;
import com.oneStopSolutions.customer.customerBeans.Issue;
import com.oneStopSolutions.customer.customerBeans.Login;
import com.oneStopSolutions.customer.customerBeans.Output;
import com.oneStopSolutions.customer.customerBeans.UserType;
import com.oneStopSolutions.customer.dtoes.CustomerUpdatePasswordDto;
import com.oneStopSolutions.customer.exception.CustomerException;
import com.oneStopSolutions.customer.exception.IssueException;
import com.oneStopSolutions.customer.exception.LoginException;
import com.oneStopSolutions.customer.repository.CustomerRepository;
import com.oneStopSolutions.customer.repository.IssueRepository;
import com.oneStopSolutions.customer.repository.LoginRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private IssueRepository issueRepository;

	@Autowired
	private LoginRepository loginRepository;

	@Override
	public Output registerCustomer(Customer customer) throws CustomerException {

		customerRepository.save(customer);

		customer.getLogin().setType(UserType.CUSTOMER);

		customer.getLogin().setActive(true);

		loginRepository.save(customer.getLogin());

		Output output = new Output();
		output.setMessage("Customer Registered");

		return output;

	}

	@Override
	public Customer customerLogin(Login login) throws LoginException {

		Login login2 = loginRepository.findByUsername(login.getUsername());

		if (login2 == null) {
			throw new LoginException("No A./c Found");
		} else if (!login2.getPassword().equals(login.getPassword())) {
			throw new LoginException("Password Incorrect");
		} else {

			Customer customer = customerRepository.findByLogin(login2);

			if (customer == null) {
				throw new CustomerException("Customer Not Found");
			} else {
				return customer;
			}

		}

	}

	@Override
	public Output createIssue(Issue issue, Integer customerId) throws IssueException {

		Optional<Customer> optional = customerRepository.findById(customerId);

		Customer customer = optional.get();

		if (customer == null) {
			throw new CustomerException("No Customer Found");
		}
		
		issue.setIssueStatus(false);

		customer.getIssues().add(issue);

		customerRepository.save(customer);

		Output output = new Output();
		output.setMessage("Issue Added Successfully");

		return output;
	}

	@Override
	public List<Issue> getAllIssuesByCustomerId(Integer customerId) throws IssueException {

		Optional<Customer> optional = customerRepository.findById(customerId);

		if (optional.isEmpty()) {
			throw new CustomerException("Customer Not Found");
		}

		List<Issue> issues = optional.get().getIssues();

		if (issues.size() == 0) {
			throw new IssueException("No Issues Found");
		}

		return issues;

	}

	@Override
	public Issue getIssueId(Integer issueId) throws IssueException {

		Optional<Issue> optional = issueRepository.findById(issueId);

		if (optional.isEmpty()) {
			throw new IssueException("Invalid Issue ID");
		}

		Issue issue = optional.get();

		return issue;

	}

	@Override
	public Output deleteIssueId(Integer issueId) throws IssueException {

		Issue issue = issueRepository.findById(issueId).orElseThrow(() -> new IssueException("Invalid Issue ID"));

		issueRepository.delete(issue);

		Output output = new Output();
		output.setMessage("Issue Deleted Successfully");

		return output;

	}

	@Override
	public Output reopenIssueById(Integer issueId) throws IssueException {

		Issue issue = issueRepository.findById(issueId).orElseThrow(() -> new IssueException("Invalid Issue ID"));

		if (!issue.isIssueStatus()) {

			issue.setIssueStatus(true);

			issueRepository.save(issue);

			Output output = new Output();
			output.setMessage("Issue Updated Successfully");

			return output;

		} else {
			throw new IssueException("Issue Already Opened");
		}

	}

	@Override
	public Output updatePassword(CustomerUpdatePasswordDto dto, Integer customerId) throws CustomerException {

		Optional<Customer> optional = customerRepository.findById(customerId);

		if (optional.isEmpty()) {
			throw new CustomerException("No Customer Found");
		}

		Customer customer = optional.get();

		if (dto != null && dto.getNewPassword() != null && dto.getOldPassword() != null) {
			
			if (customer.getLogin().getPassword().equals(dto.getOldPassword())) {
				
				customer.getLogin().setPassword(dto.getNewPassword());

				customerRepository.save(customer);

				Output output = new Output();
				output.setMessage("Password Changed Successfully");

				return output;
				
			} else {
				throw new CustomerException("Wrong Password Entered");
			}
			
		} else {
			throw new CustomerException("Fill All The Fields");
		}

	}

}
