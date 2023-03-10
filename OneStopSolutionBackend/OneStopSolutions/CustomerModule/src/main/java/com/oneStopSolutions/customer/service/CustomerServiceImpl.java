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
import com.oneStopSolutions.customer.dtoes.CreateIssueDto;
import com.oneStopSolutions.customer.dtoes.CustomerUpdatePasswordDto;
import com.oneStopSolutions.customer.dtoes.LoginDto;
import com.oneStopSolutions.customer.dtoes.RegisterCustomerDto;
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
	public Output registerCustomer(RegisterCustomerDto dto) throws CustomerException {

		// Extracting customer details
		Customer customer = new Customer();

		customer.setFirstName(dto.getFirstName());
		customer.setLastName(dto.getLastName());
		customer.setEmail(dto.getEmail());
		customer.setCity(dto.getCity());
		customer.setMobile(dto.getMobile());

		// Extracting login details
		customer.setLogin(new Login());
		customer.getLogin().setUsername(dto.getUsername());
		customer.getLogin().setPassword(dto.getPassword());
		customer.getLogin().setType(UserType.CUSTOMER);
		customer.getLogin().setActive(true);

		customerRepository.save(customer);

		loginRepository.save(customer.getLogin());

		Output output = new Output();
		output.setMessage("Customer Registered");

		return output;

	}

	@Override
	public Customer customerLogin(LoginDto dto) throws LoginException {

		// Extracting user-name and password
		Login login = new Login();
		login.setUsername(dto.getUsername());
		login.setPassword(dto.getPassword());
		login.setType(UserType.CUSTOMER); // Setting User Type to Customer

		// Extracting login details using user-name
		Login login2 = loginRepository.findByUsername(login.getUsername());

		if (login2 == null) {
			throw new LoginException("Account Doesn't Exist");
		} else if (!login2.getPassword().equals(login.getPassword())) {
			throw new LoginException("Password Incorrect");
		} else if (!login2.isActive()) {
			throw new CustomerException("Customer Not Active");
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
	public Output createIssue(CreateIssueDto dto, Integer customerId) throws IssueException {
		
		// Extracting Customer using Customer ID
		Optional<Customer> optional = customerRepository.findById(customerId);

		Customer customer = optional.get();

		// Checking if Customer is present or not
		if (customer == null) {
			throw new CustomerException("No Customer Found");
		}

		Issue issue = new Issue();

		//  Extracting Issue details
		issue.setIssueDescription(dto.getIssueDescription());
		issue.setIssueType(dto.getIssueType());
		issue.setIssueStatus(true);

		// Adding the Issue to Customer
		customer.getIssues().add(issue);

		// Updating the Customer Details
		customerRepository.save(customer);

		Output output = new Output();
		output.setMessage("Issue Added Successfully");

		return output;
	}

	@Override
	public List<Issue> getAllIssuesByCustomerId(Integer customerId) throws IssueException {

		// Extracting Customer using Customer ID
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

		// Extracting Issue using Issue ID
		Optional<Issue> optional = issueRepository.findById(issueId);

		// Checking if Issue is present or not
		if (optional.isEmpty()) {
			throw new IssueException("Invalid Issue ID");
		}

		Issue issue = optional.get();

		return issue;

	}

	@Override
	public Output deleteIssueId(Integer issueId) throws IssueException {

		// Extracting Issue using Issue ID
		Issue issue = issueRepository.findById(issueId).orElseThrow(() -> new IssueException("Invalid Issue ID"));

		// Deleting the Issue
		issueRepository.delete(issue);

		Output output = new Output();
		output.setMessage("Issue Deleted Successfully");

		return output;

	}

	@Override
	public Output reopenIssueById(Integer issueId) throws IssueException {

		// Extracting Issue using Issue ID
		Issue issue = issueRepository.findById(issueId).orElseThrow(() -> new IssueException("Invalid Issue ID"));

		// Checking if the issue is already open or not
		if (!issue.isIssueStatus()) {

			// Setting issue status as true[OPEN]
			issue.setIssueStatus(true);

			// Updating the Issue Details
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

		// Extracting customer using customerId
		Optional<Customer> optional = customerRepository.findById(customerId);

		// Checking if Customer is present or not
		if (optional.isEmpty()) {
			throw new CustomerException("No Customer Found");
		}

		Customer customer = optional.get();

		if (dto != null && dto.getNewPassword() != null && dto.getOldPassword() != null) {

			if (customer.getLogin().getPassword().equals(dto.getOldPassword())) {

				// Setting the new password
				customer.getLogin().setPassword(dto.getNewPassword());

				// Updating Customer's A/c
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
