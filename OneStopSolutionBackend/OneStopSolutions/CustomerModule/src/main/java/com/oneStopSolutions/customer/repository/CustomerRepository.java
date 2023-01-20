package com.oneStopSolutions.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.oneStopSolutions.customer.customerBeans.Customer;
import com.oneStopSolutions.customer.customerBeans.Issue;
import com.oneStopSolutions.customer.customerBeans.Login;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	public Customer findByLogin(Login login);
	
//	@Query("select c.issues from Customer c where c.customerId=?1")
//	public List<Issue> getIssuesByCustomerId(Integer customerId);

}
