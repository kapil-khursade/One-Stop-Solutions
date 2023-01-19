package com.oneStopSolutions.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oneStopSolutions.customer.customerBeans.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
