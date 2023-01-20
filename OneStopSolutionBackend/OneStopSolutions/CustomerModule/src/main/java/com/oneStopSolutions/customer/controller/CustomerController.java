package com.oneStopSolutions.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oneStopSolutions.customer.customerBeans.Customer;
import com.oneStopSolutions.customer.customerBeans.Login;
import com.oneStopSolutions.customer.customerBeans.Output;
import com.oneStopSolutions.customer.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/customers")
	public ResponseEntity<Output> registerCustomerHandler(@RequestBody Customer customer) {
		Output output = customerService.registerCustomer(customer);
		
		return new ResponseEntity<Output>(output, HttpStatus.CREATED);
	}
	
	@GetMapping("/login")
	public ResponseEntity<Customer> loginCustomerHandler(@RequestBody Login login) {
		Customer output = customerService.customerLogin(login);
		
		return new ResponseEntity<Customer>(output, HttpStatus.ACCEPTED);
	}

}
