package com.oneStopSolutions.customer.service;

import java.util.List;

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
		/*private Integer customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String mobile;
	private String city;*/
		
		customerRepository.save(customer);
		
		customer.getLogin().setType(UserType.CUSTOMER);
		
		customer.getLogin().setActive(true);
		
		loginRepository.save(customer.getLogin());
		
		Output output = new Output();
		output.setMessage("Customer Registered");
		
		return output;
	}

	@Override
	public List<Issue> getAllIssuesByCustomerId(Integer Id) throws IssueException {
		// TODO Auto-generated method stub
		return null;
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
	public Output createIssue(Issue issue) throws IssueException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Issue getIssueId(Integer Id) throws IssueException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Output deleteIssueId(Integer Id) throws IssueException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Output reopenIssueById(Integer Id) throws IssueException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Output updatePassword(Integer id, String oldPassword, String newPassword) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

}