package com.oneStopSolutions.admin.repository;

import com.oneStopSolutions.admin.model.Department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDao extends JpaRepository<Department,Integer> {
	
}
