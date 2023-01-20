package com.oneStopSolutions.operator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oneStopSolutions.customer.customerBeans.Login;
import com.oneStopSolutions.operator.Beans.Operator;

@Repository
public interface OperatorDao extends JpaRepository<Operator, Integer> {

	public Operator findByLogin(Login login);
}
