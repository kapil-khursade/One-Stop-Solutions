package com.oneStopSolutions.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegisterAdminDto {
	
	private Integer departmentId;
	private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;

}
