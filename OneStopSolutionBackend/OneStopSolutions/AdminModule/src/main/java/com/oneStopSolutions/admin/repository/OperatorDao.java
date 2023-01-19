package com.oneStopSolutions.admin.repository;

import com.oneStopSolutions.operator.Beans.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorDao extends JpaRepository<Operator, Integer> {

}