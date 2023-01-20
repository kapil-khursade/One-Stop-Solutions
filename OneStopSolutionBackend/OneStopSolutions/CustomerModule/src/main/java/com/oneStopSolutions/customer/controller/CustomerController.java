package com.oneStopSolutions.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oneStopSolutions.customer.customerBeans.Customer;
import com.oneStopSolutions.customer.customerBeans.Issue;
import com.oneStopSolutions.customer.customerBeans.Login;
import com.oneStopSolutions.customer.customerBeans.Output;
import com.oneStopSolutions.customer.dtoes.CustomerUpdatePasswordDto;
import com.oneStopSolutions.customer.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/customers")
	public ResponseEntity<Output> registerCustomerHandler(@RequestBody Customer customer) {
		Output output = customerService.registerCustomer(customer);
		
		return new ResponseEntity<Output>(output, HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Customer> loginCustomerHandler(@RequestBody Login login) {
		Customer output = customerService.customerLogin(login);
		
		return new ResponseEntity<Customer>(output, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/issue/{customerId}")
	public ResponseEntity<Output> createIssueHandler(@PathVariable("customerId") Integer customerId, @RequestBody Issue issue) {
		Output output = customerService.createIssue(issue, customerId);
		
		return new ResponseEntity<Output>(output, HttpStatus.CREATED);
	}
	
	@GetMapping("/issue/{customerId}")
	public ResponseEntity<List<Issue>> getAllIssueByCustomerIdHandler(@PathVariable("customerId") Integer customerId) {
		List<Issue> issues = customerService.getAllIssuesByCustomerId(customerId);
		
		return new ResponseEntity<List<Issue>>(issues, HttpStatus.OK);
	}
	
	@GetMapping("/issue/{issueId}")
	public ResponseEntity<Issue> getIssueByIssueIdHandler(@PathVariable("issueId") Integer issueId) {
		Issue issue2 = customerService.getIssueId(issueId);
		
		return new ResponseEntity<Issue>(issue2, HttpStatus.OK);
	}
	
	@DeleteMapping("/issue/{issueId}")
	public ResponseEntity<Output> deleteIssueByIssueIdHandler(@PathVariable("issueId") Integer issueId) {
		Output output = customerService.deleteIssueId(issueId);
		
		return new ResponseEntity<Output>(output, HttpStatus.OK);
	}
	
	@PutMapping("/issue/{issueId}")
	public ResponseEntity<Output> reopenIssueByIssueIdHandler(@PathVariable("issueId") Integer issueId) {
		Output output = customerService.reopenIssueById(issueId);
		
		return new ResponseEntity<Output>(output, HttpStatus.OK);
	}
	
	@PutMapping("/customers/changepassword/{customerId}")
	public ResponseEntity<Output> updatePasswordHandler(@PathVariable("customerId") Integer customerId, @RequestBody CustomerUpdatePasswordDto dto) {
		Output output = customerService.updatePassword(dto, customerId);
		
		return new ResponseEntity<Output>(output, HttpStatus.OK);
	}

}
