package com.oneStopSolutions.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oneStopSolutions.customer.customerBeans.Issue;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Integer> {
	
	public List<Issue> findByIssueType(String issueType); // FINDS THE ISSUE BY ISSUE TYPE

}
