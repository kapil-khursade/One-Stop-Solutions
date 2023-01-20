package com.oneStopSolutions.admin.repository;

import com.oneStopSolutions.admin.model.Admin;
import com.oneStopSolutions.customer.customerBeans.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminDao extends JpaRepository<Admin,Integer> {
    public Admin findByLogin(Login login);
}
