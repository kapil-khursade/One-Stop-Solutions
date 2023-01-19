package com.oneStopSolutions.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneStopSolutions.customer.customerBeans.Customer;
import com.oneStopSolutions.customer.customerBeans.Issue;
import com.oneStopSolutions.customer.customerBeans.Output;
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
		/*private Integer customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String mobile;
	private String city;*/
		
		if(customer.getEmail().contains("@gmail.com")) {
			if(customer.getMobile().length() == 10) {
				int passwordLength = customer.getLogin().getPassword().length();
				if(passwordLength > 5 && passwordLength < 9) {
					customer.getLogin().setActive(true);
					customer.getLogin().setType("CUSTOMER");
					
					customerRepository.save(customer);
					
					Output output = new Output();
					output.setMessage("Customer Registered");
					return output;
				}
				else {
					throw new LoginException("Password Should Be 6 To 8 Characters Long");
				}
			}
			else {
				throw new CustomerException("Invalid Mobile Number");
			}
		}
		else {
			throw new CustomerException("Invalid Email Address");
		}
	}

	@Override
	public List<Issue> getAllIssuesByCustomerId(Integer Id) throws IssueException {
		// TODO Auto-generated method stub
		return null;
	}

}
