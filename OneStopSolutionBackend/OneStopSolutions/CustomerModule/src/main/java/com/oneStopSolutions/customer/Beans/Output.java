package com.oneStopSolutions.customer.Beans;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Output {

	private String message;
	private LocalDateTime timestamp;
	
}
