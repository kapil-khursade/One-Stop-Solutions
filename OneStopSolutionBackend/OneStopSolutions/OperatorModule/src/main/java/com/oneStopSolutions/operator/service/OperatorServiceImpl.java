package com.oneStopSolutions.operator.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneStopSolutions.customer.customerBeans.Customer;
import com.oneStopSolutions.customer.customerBeans.Issue;
import com.oneStopSolutions.customer.customerBeans.Login;
import com.oneStopSolutions.customer.customerBeans.Output;
import com.oneStopSolutions.customer.exception.IssueException;
import com.oneStopSolutions.customer.repository.CustomerRepository;
import com.oneStopSolutions.customer.repository.IssueRepository;
import com.oneStopSolutions.customer.repository.LoginRepository;
import com.oneStopSolutions.operator.Beans.Operator;
import com.oneStopSolutions.operator.Beans.Solution;
import com.oneStopSolutions.operator.dtos.CreateSolutionDto;
import com.oneStopSolutions.operator.dtos.ModifyIssueDto;
import com.oneStopSolutions.operator.exception.OperatorException;
import com.oneStopSolutions.operator.exception.SolutionException;
import com.oneStopSolutions.operator.repository.OperatorDao;
import com.oneStopSolutions.operator.repository.SolutionDao;

@Service
public class OperatorServiceImpl implements OperatorService {

	@Autowired
	private OperatorDao operatorDao;

	@Autowired
	private SolutionDao solutionDao;

	@Autowired
	private CustomerRepository customerDao;

	@Autowired
	private LoginRepository loginDao;

	@Autowired
	private IssueRepository issueDao;

	@Override
	public Operator loginOperator(Login login) throws OperatorException {

		Login login2=loginDao.findByUsername(login.getUsername());
		if(login2==null) {
			throw new OperatorException("Account doesn't exist.");
		}else if(!login2.getPassword().equals(login.getPassword())) {
			throw new OperatorException("Wrong password");
		}
		else {
			Operator operator=operatorDao.findByLogin(login2);
			if(operator==null) {
				throw new OperatorException("Account doesn't exist.");
			}else {
				return operator;
			}
			
		}
		
	}

	@Override
	public List<Issue> getIssueByCustomerId(Integer customerId) throws OperatorException {

		Optional<Customer> opt = customerDao.findById(customerId);

		if (opt.isPresent()) {
			Customer customer = opt.get();
			return customer.getIssues();
		} else {
			throw new OperatorException("Customer doesn't exist with id " + customerId);
		}
	}

	@Override
	public List<Issue> getIssueByType(String issueType) throws OperatorException {
	
		List<Issue> issues=issueDao.findByIssueType(issueType);
		
		if(!issues.isEmpty())
			return issues;
		else
			throw new OperatorException("No issue found with "+issueType);
		
	}

	@Override
	public Output modifyIssueById(Integer issueId, ModifyIssueDto dto) throws OperatorException {

		Optional<Issue> opt = issueDao.findById(issueId);

		if (opt.isPresent()) {
			Issue existingIssue=opt.get();
			
			if(dto != null) {
				
				if(dto.getIssueDescription() != null) {
					existingIssue.setIssueDescription(dto.getIssueDescription());
				}
				if(dto.getIssueType() != null) {
					existingIssue.setIssueType(dto.getIssueType());
				}
				
				issueDao.save(existingIssue);
				
			}
			
			return new Output("Issue modified successfully.", LocalDateTime.now());
		} else {
			throw new OperatorException("Issue doen't exist with id " + issueId);
		}
	}

	@Override
	public Output closeIssueById(Integer issueId) throws OperatorException {

		Optional<Issue> opt = issueDao.findById(issueId);

		if (opt.isPresent()) {
			Issue issue = opt.get();
			if(issue.isIssueStatus()) {
				issue.setIssueStatus(false);
				issueDao.save(issue);
				return new Output("Issue id " + issueId + " closed successfully.", LocalDateTime.now());
			}
			else {
				throw new IssueException("Issue Already Closed");
			}
			
		} else {
			throw new OperatorException("Issue doen't exist with id " + issueId);
		}
	}

	@Override
	public Customer getCustomerById(Integer customerId) throws OperatorException {

		Optional<Customer> opt = customerDao.findById(customerId);

		if (opt.isPresent()) {
			Customer customer = opt.get();
			return customer;
		} else
			throw new OperatorException("Customer does not exist with Id " + customerId);

	}

	@Override
	public List<Customer> getCustomerByFirstName(String firstName) throws OperatorException {
		
		
		List<Customer> customers = customerDao.findByFirstName(firstName);
		if(!customers.isEmpty())
			return customers;
		else
			throw new OperatorException("No customer found with "+firstName);
	}

	@Override
	public Customer getCustomerByEmail(String email) throws OperatorException {
		
		Customer customer=customerDao.findByEmail(email);
		if(customer==null) {
			throw new OperatorException("No customer found with email "+email);
		}
		
		return customer;
	}

	@Override
	public Output lockCustomerById(Integer customerId) throws OperatorException {

		Optional<Customer> opt = customerDao.findById(customerId);

		if (opt.isEmpty()) {
			throw new OperatorException("No customer found.");
		}
		Customer customer=opt.get();
		customer.getLogin().setActive(false);
		customerDao.save(customer);

		return new Output("Account locked", LocalDateTime.now());
	}

	@Override
	public Output createSolutionToIssue(Integer issueId, Integer operatorId, CreateSolutionDto dto) throws SolutionException {
		
		Optional<Issue> opt = issueDao.findById(issueId);
		
		if(opt.isEmpty()) {
			throw new IssueException("No Issue Found With issueId : " + issueId);
		}
		else {
			Issue issue=opt.get();
			
			Optional<Operator> opt1 = operatorDao.findById(operatorId);
			
			if(opt1.isEmpty()) {
				throw new OperatorException("No Operator Found With Operator Id : " + operatorId);
			}
			else {
				Operator operator = opt1.get();
				
				Solution solution = new Solution();
				
				solution.setIssue(issue);
				solution.setSolutionDate(dto.getSolutionDate());
				solution.setSolutionDescription(dto.getSolutionDescription());
				solution.setOperator(operator);
				
				operator.getSolutions().add(solution);
				
				operatorDao.save(operator);
				
				return new Output("Solution is created for issue id "+issueId, LocalDateTime.now());
			}
		}
		
	}

	@Override
	public List<Solution> getAllSolutionToIssue(Integer issueId) throws SolutionException {
		
		Optional<Issue> opt = issueDao.findById(issueId);
		
		if(opt.isEmpty()) {
			throw new SolutionException("Issue doen't exist with id " + issueId);
		} 
		Issue issue=opt.get();
		List<Solution> solutions = solutionDao.findByIssue(issue);
		
		if(solutions.size()==0) {
			throw new OperatorException("No solution found for "+issueId);
		}
		
		return solutions;
	
	}

	@Override
	public Output deleteSolutionById(Integer solutionId) throws SolutionException {

		Optional<Solution> opt = solutionDao.findById(solutionId);
		Output output = new Output();

		if (opt.isPresent()) {
			Solution solution = opt.get();
			solutionDao.delete(solution);

			output.setMessage("Solution id " + solutionId + " deleted successfully.");
			output.setTimestamp(LocalDateTime.now());

			return output;
		} else {
			throw new SolutionException("Solution doesn't exist with id " + solutionId);
		}
	}

}
