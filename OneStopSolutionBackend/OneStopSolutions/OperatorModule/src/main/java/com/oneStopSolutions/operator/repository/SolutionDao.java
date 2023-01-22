package com.oneStopSolutions.operator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oneStopSolutions.customer.customerBeans.Issue;
import com.oneStopSolutions.operator.Beans.Solution;

@Repository
public interface SolutionDao extends JpaRepository<Solution, Integer> {
	public List<Solution> findByIssue(Issue issue);
}
