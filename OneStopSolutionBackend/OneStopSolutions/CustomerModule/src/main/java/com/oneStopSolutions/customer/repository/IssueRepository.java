package com.oneStopSolutions.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oneStopSolutions.customer.customerBeans.Issue;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Integer> {

}
