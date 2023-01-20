package com.oneStopSolutions.customer.customerBeans;

public enum UserType {
	
	ADMIN("admin"),
	OPERATOR("operator"),
	CUSTOMER("customer");
	
	private final String value;

	private UserType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
}
