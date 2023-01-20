package com.oneStopSolutions.admin.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oneStopSolutions.operator.Beans.Operator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Department {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer departmentId;
private String departmentName;

//bidirection
    @JsonIgnore
@OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
private List<Admin> adminList = new ArrayList<>();

//unidirectional
@OneToMany(cascade = CascadeType.ALL)
@JsonIgnore
@JoinColumn(name = "department_id")
private List<Operator> operatorList = new ArrayList<>();

//bidirectional
@OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
@JsonIgnore
private List<Admin> employeeList = new ArrayList<>();

//    private Admin admin;

}
