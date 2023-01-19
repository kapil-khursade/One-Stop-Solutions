package com.oneStopSolutions.admin.repository;

import com.oneStopSolutions.admin.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminDao extends JpaRepository<Admin,Integer> {


}
