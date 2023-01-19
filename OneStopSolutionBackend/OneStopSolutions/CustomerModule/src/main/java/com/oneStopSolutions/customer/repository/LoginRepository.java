package com.oneStopSolutions.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oneStopSolutions.customer.customerBeans.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {

}
