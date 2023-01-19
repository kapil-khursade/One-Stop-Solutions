package com.oneStopSolution.Admin.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

    //bidirectional
    @ManyToOne(cascade = CascadeType.ALL)
    private Department department;
}
