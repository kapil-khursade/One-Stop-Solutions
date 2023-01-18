package com.oneStopSolutions.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oneStopSolutions.customer.Beans.Issue;

public interface IssueRepository extends JpaRepository<Issue, Integer> {

}
