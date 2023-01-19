package com.oneStopSolutions.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oneStopSolutions.customer.customerBeans.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
