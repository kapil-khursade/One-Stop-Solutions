package com.oneStopSolutions.customer.customerBeans;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Output {

	private String message;
	private LocalDateTime timestamp = LocalDateTime.now(); // STORES THE CURRENT DATE & TIME

}
