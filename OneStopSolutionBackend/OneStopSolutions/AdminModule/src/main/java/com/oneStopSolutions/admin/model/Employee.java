package com.oneStopSolutions.admin.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Employee {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer employeeId;
private String firstName;
private String lastName;

//bidirectional
@ManyToOne(cascade = CascadeType.ALL)
private Department department;
}
