package com.oneStopSolutions.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oneStopSolutions.customer.customerBeans.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
	
	

}
