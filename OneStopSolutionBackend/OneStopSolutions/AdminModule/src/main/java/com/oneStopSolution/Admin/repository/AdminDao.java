package com.oneStopSolution.Admin.repository;

import com.oneStopSolution.Admin.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDao extends JpaRepository<Admin,Integer> {

}
