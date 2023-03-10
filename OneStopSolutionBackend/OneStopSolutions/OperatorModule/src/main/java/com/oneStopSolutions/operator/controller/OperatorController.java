package com.oneStopSolutions.operator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
import com.oneStopSolutions.operator.Beans.Operator;
import com.oneStopSolutions.operator.Beans.Solution;
import com.oneStopSolutions.operator.dtos.CreateSolutionDto;
import com.oneStopSolutions.operator.dtos.ModifyIssueDto;
import com.oneStopSolutions.operator.service.OperatorService;

@RestController
@RequestMapping("/operator")
public class OperatorController {
	
	@Autowired
	private OperatorService operatorService;
	
	//Operator login
	@PostMapping("/operatorLogin")
	public ResponseEntity<Operator> loginOperatorHandler(@RequestBody Login login){
		Operator operator=operatorService.loginOperator(login);
		return new ResponseEntity<Operator>(operator, HttpStatus.CREATED);
	}
	
	//To get Issues By Customer Id
	@GetMapping("issues/id/{customerId}")
	public ResponseEntity<List<Issue>> getIssueByCustomerIdHandler(@PathVariable("customerId") Integer customerId){
		List<Issue> issues=operatorService.getIssueByCustomerId(customerId);
		return new ResponseEntity<List<Issue>>(issues, HttpStatus.OK);
	}
	
	//To get Issue By Type
	@GetMapping("/issues/{type}")
	public ResponseEntity<List<Issue>> getIssueByTypeHandler(@PathVariable("type") String issueType){
		List<Issue> issues=operatorService.getIssueByType(issueType);
		return new ResponseEntity<List<Issue>>(issues, HttpStatus.OK);
	}
	
	//To modify Issue By Id
	@PutMapping("/issue/{issueId}")
	public ResponseEntity<Output> modifyIssueByIdHandler(@PathVariable("issueId") Integer issueId, @RequestBody ModifyIssueDto dto){
		Output output = operatorService.modifyIssueById(issueId, dto);
		return new ResponseEntity<Output>(output, HttpStatus.ACCEPTED);
	}
	
	//To close Issue By Id
	@PatchMapping("issue/{issueId}")
	public ResponseEntity<Output> closeIssueByIdHandler(@PathVariable("issueId") Integer issueId){
		Output output = operatorService.closeIssueById(issueId);
		return new ResponseEntity<Output>(output, HttpStatus.ACCEPTED);
	}
	
	//To get customer by ID
	@GetMapping("/customer/id/{customerId}")
	public ResponseEntity<Customer> getCustomrByIdHandler(@PathVariable("customerId") Integer customerId){
		Customer customer = operatorService.getCustomerById(customerId);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	//To get Customer By FirstName
	@GetMapping("/customer/fn/{firstName}")
	public ResponseEntity<List<Customer>> getCustomerByFirstNameHandler(@PathVariable("firstName") String firstName){
		List<Customer> customers=operatorService.getCustomerByFirstName(firstName);
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
	//To get Customer By Email
	@GetMapping("/customer/e/{email}")
	public ResponseEntity<Customer> getCustomerByEmailHandler(@PathVariable("email") String email){
		Customer customer=operatorService.getCustomerByEmail(email);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	//To lockCustomerById(Integer customerId)
	@PatchMapping("/customer/{customerId}")
	public ResponseEntity<Output> lockCustomerByIdHandler(@PathVariable("customerId") Integer customerId){
		Output output=operatorService.lockCustomerById(customerId);
		return new ResponseEntity<Output>(output, HttpStatus.ACCEPTED);
	}
	
	//To create Solution To Issue by Id
	@PostMapping("/solution/{issueId}/{operatorId}")
	public ResponseEntity<Output> createSolutionToIssueHandler(@PathVariable("issueId") Integer issueId, @PathVariable("operatorId") Integer operatorId, @RequestBody CreateSolutionDto dto){
		Output output = operatorService.createSolutionToIssue(issueId, operatorId, dto);
		return new ResponseEntity<Output>(output, HttpStatus.CREATED);
	}
	
	//To get All Solution To Issue by Id
	@GetMapping("/solutions/{issueId}")
	public ResponseEntity<List<Solution>> getAllSolutionToIssueHandler(@PathVariable("issueId") Integer issueId){
		List<Solution> solutions=operatorService.getAllSolutionToIssue(issueId);
		return new ResponseEntity<List<Solution>>(solutions, HttpStatus.OK);
	}
	
	//To delete Solution By Id
	@DeleteMapping("/solution/{solutionId}")
	public ResponseEntity<Output> deleteSolutionByIdHandler(@PathVariable("solutionId") Integer solutionId){
		Output output = operatorService.deleteSolutionById(solutionId);
		return new ResponseEntity<Output>(output, HttpStatus.ACCEPTED);
	}

}
