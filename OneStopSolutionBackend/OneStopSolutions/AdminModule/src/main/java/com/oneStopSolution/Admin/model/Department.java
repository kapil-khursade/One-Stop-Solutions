package com.oneStopSolution.Admin.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Department {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer departmentId;
private String departmentName;
}
