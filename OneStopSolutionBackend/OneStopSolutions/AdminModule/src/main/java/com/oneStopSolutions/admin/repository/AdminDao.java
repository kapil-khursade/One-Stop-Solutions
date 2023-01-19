package com.oneStopSolutions.admin.repository;

import com.oneStopSolutions.admin.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminDao extends JpaRepository<Admin,Integer> {

//@Query("select a from Login a where a.LoginId = :loginId and a.password =: password")
//    Admin findAdminByAdminIdAndPassword(@)
}
