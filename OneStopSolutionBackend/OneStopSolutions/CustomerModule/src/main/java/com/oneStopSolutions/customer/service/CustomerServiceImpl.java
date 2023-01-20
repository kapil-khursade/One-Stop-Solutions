package com.oneStopSolutions.customer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneStopSolutions.customer.customerBeans.Customer;
import com.oneStopSolutions.customer.customerBeans.Issue;
import com.oneStopSolutions.customer.customerBeans.Login;
import com.oneStopSolutions.customer.customerBeans.Output;
import com.oneStopSolutions.customer.customerBeans.UserType;
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
		if (customer.getCity() != null && customer.getFirstName() != null && customer.getLastName() != null
				&& customer.getMobile().length() == 10 && customer.getEmail().contains("@gmail.com")
				&& customer.getLogin().getUsername() != null && customer.getLogin().getPassword() != null) {

			customerRepository.save(customer);

			customer.getLogin().setType(UserType.CUSTOMER);

			customer.getLogin().setActive(true);

			loginRepository.save(customer.getLogin());

			Output output = new Output();
			output.setMessage("Customer Registered");

			return output;

		} else {
			throw new CustomerException("Fill All The Details");
		}
	}

	@Override
	public Customer customerLogin(Login login) throws LoginException {
//		Login login2 = loginRepository.findByUsername(login.getUsername());
//		
//		if(login2 == null ) {
//			throw new LoginException("No A./c Found");
//		}
//		else if(!login2.getPassword().equals(login.getPassword())) {
//			throw new LoginException("Pass Incorr");
//		}
//		
//		Customer customer = customerRepository.findByLogin(login2);
//		
//		if(customer == null) {
//			throw new CustomerException("Customer Not Found");
//		}

		return null;
	}

	@Override
	public Output createIssue(Issue issue, Integer customerId) throws IssueException {
		if (customerId != null) {
			Optional<Customer> optional = customerRepository.findById(customerId);

			if (optional.isPresent()) {
				Customer customer = optional.get();

				if (issue.getIssueDescription() != null && issue.getIssueType() != null) {
					customer.getIssues().add(issue);

					Output output = new Output();
					output.setMessage("Issue Added Successfully");

					return output;
				} else {
					throw new IssueException("Enter Issue Type or Issue Description");
				}

			} else {
				throw new CustomerException("No Customer Found");
			}
		} else {
			throw new CustomerException("Invalid Customer ID");
		}
	}

	@Override
	public List<Issue> getAllIssuesByCustomerId(Integer customerId) throws IssueException {
		if (customerId != null) {
			List<Issue> issues = new ArrayList<>();
			issues = customerRepository.getIssuesByCustomerId(customerId);

			if (issues != null) {
				if (issues.size() > 0) {
					return issues;
				} else {
					throw new IssueException("No Issues Found");
				}
			} else {
				throw new CustomerException("Invalid Customer ID");
			}
		} else {
			throw new CustomerException("Enter Customer ID");
		}
	}

	@Override
	public Issue getIssueId(Integer issueId) throws IssueException {
		if (issueId != null) {
			Optional<Issue> optional = issueRepository.findById(issueId);

			if (optional.isPresent()) {
				Issue issue = optional.get();

				return issue;
			} else {
				throw new IssueException("Invalid Issue ID");
			}
		} else {
			throw new IssueException("Enter Issue ID");
		}
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

		if(!issue.isIssueStatus()) {
			issue.setIssueStatus(true);
			
			issueRepository.save(issue);

			Output output = new Output();
			output.setMessage("Issue Updated Successfully");

			return output;
		}
		else {
			throw new IssueException("Issue Already Opened");
		}
		
	}

	@Override
	public Output updatePassword(Integer customerId, String oldPassword, String newPassword) throws CustomerException {
		if(customerId != null && oldPassword != null) {
//			if()
			return null;
		}
		else {
			throw new CustomerException("Enter Customer ID");
		}
		
	}

}
