package com.oneStopSolutions.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oneStopSolutions.customer.customerBeans.Customer;
import com.oneStopSolutions.customer.customerBeans.Login;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	public Customer findByLogin(Login login);
	
	public List<Customer> findByFirstName(String name);
	
	public Customer findByEmail(String email);


}
