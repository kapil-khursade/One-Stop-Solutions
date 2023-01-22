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
import com.oneStopSolutions.customer.dtoes.CreateIssueDto;
import com.oneStopSolutions.customer.dtoes.CustomerUpdatePasswordDto;
import com.oneStopSolutions.customer.dtoes.LoginDto;
import com.oneStopSolutions.customer.dtoes.RegisterCustomerDto;
import com.oneStopSolutions.customer.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
<<<<<<< HEAD
	
	
	// Register A Customer
	@PostMapping("/customers")
=======

	@PostMapping("/register")
>>>>>>> branch 'main' of https://github.com/kapil-khursade/brisk-desire-6503.git
	public ResponseEntity<Output> registerCustomerHandler(@RequestBody RegisterCustomerDto customerDto) {
		Output output = customerService.registerCustomer(customerDto);

		return new ResponseEntity<Output>(output, HttpStatus.CREATED);
	}
<<<<<<< HEAD
	
	
	// Customer Login
=======

>>>>>>> branch 'main' of https://github.com/kapil-khursade/brisk-desire-6503.git
	@PostMapping("/login")
	public ResponseEntity<Customer> loginCustomerHandler(@RequestBody LoginDto dto) {
		Customer customer = customerService.customerLogin(dto);

		return new ResponseEntity<Customer>(customer, HttpStatus.ACCEPTED);
	}

<<<<<<< HEAD
	
	// Create An Issue 
=======
>>>>>>> branch 'main' of https://github.com/kapil-khursade/brisk-desire-6503.git
	@PostMapping("/issue/{customerId}")
	public ResponseEntity<Output> createIssueHandler(@PathVariable("customerId") Integer customerId,
			@RequestBody CreateIssueDto dto) {
		Output output = customerService.createIssue(dto, customerId);

		return new ResponseEntity<Output>(output, HttpStatus.CREATED);
	}

<<<<<<< HEAD
	
	// Get All Issue
=======
>>>>>>> branch 'main' of https://github.com/kapil-khursade/brisk-desire-6503.git
	@GetMapping("/issue/all/{customerId}")
	public ResponseEntity<List<Issue>> getAllIssueByCustomerIdHandler(@PathVariable("customerId") Integer customerId) {
		List<Issue> issues = customerService.getAllIssuesByCustomerId(customerId);

		return new ResponseEntity<List<Issue>>(issues, HttpStatus.OK);
	}

<<<<<<< HEAD
	
	// Get Issue By IssueID
=======
>>>>>>> branch 'main' of https://github.com/kapil-khursade/brisk-desire-6503.git
	@GetMapping("/issue/one/{issueId}")
	public ResponseEntity<Issue> getIssueByIssueIdHandler(@PathVariable("issueId") Integer issueId) {
		Issue issue2 = customerService.getIssueId(issueId);

		return new ResponseEntity<Issue>(issue2, HttpStatus.OK);
	}

<<<<<<< HEAD
	
	// Delete Issue By IssueID
=======
>>>>>>> branch 'main' of https://github.com/kapil-khursade/brisk-desire-6503.git
	@DeleteMapping("/issue/{issueId}")
	public ResponseEntity<Output> deleteIssueByIssueIdHandler(@PathVariable("issueId") Integer issueId) {
		Output output = customerService.deleteIssueId(issueId);

		return new ResponseEntity<Output>(output, HttpStatus.OK);
	}

<<<<<<< HEAD
	
	// Reopen An Issue By IssueID
=======
>>>>>>> branch 'main' of https://github.com/kapil-khursade/brisk-desire-6503.git
	@PutMapping("/issue/{issueId}")
	public ResponseEntity<Output> reopenIssueByIssueIdHandler(@PathVariable("issueId") Integer issueId) {
		Output output = customerService.reopenIssueById(issueId);

		return new ResponseEntity<Output>(output, HttpStatus.OK);
	}

<<<<<<< HEAD
	
	// Update Customer's Password
=======
>>>>>>> branch 'main' of https://github.com/kapil-khursade/brisk-desire-6503.git
	@PutMapping("/customers/changepassword/{customerId}")
	public ResponseEntity<Output> updatePasswordHandler(@PathVariable("customerId") Integer customerId,
			@RequestBody CustomerUpdatePasswordDto dto) {
		Output output = customerService.updatePassword(dto, customerId);

		return new ResponseEntity<Output>(output, HttpStatus.OK);
	}

}
