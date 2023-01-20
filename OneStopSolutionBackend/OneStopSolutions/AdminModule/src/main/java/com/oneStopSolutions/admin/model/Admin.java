package com.oneStopSolutions.admin.model;
import com.oneStopSolutions.customer.customerBeans.Login;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminId;
    private String firstName;
    private String lastName;
    private String email;

    @ManyToOne
    private Department department;

    @OneToOne(cascade = CascadeType.ALL)
    @Transient
    private Login login;
}
