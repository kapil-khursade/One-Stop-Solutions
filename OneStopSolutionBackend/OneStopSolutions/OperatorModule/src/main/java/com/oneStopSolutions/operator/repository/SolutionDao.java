package com.oneStopSolutions.operator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oneStopSolutions.operator.Beans.Solution;

@Repository
public interface SolutionDao extends JpaRepository<Solution, Integer> {

}
