package com.oneStopSolutions.customer.customerBeans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Issue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer issueId;
	public String issueType;
	public String issueDescription;
	public boolean issueStatus;
	
	public Issue() {
		// TODO Auto-generated constructor stub
	}

	public Issue(Integer issueId, String issueType, String issueDescription, boolean issueStatus) {
		super();
		this.issueId = issueId;
		this.issueType = issueType;
		this.issueDescription = issueDescription;
		this.issueStatus = issueStatus;
	}

	public Integer getIssueId() {
		return issueId;
	}

	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}

	public String getIssueType() {
		return issueType;
	}

	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}

	public String getIssueDescription() {
		return issueDescription;
	}

	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}

	public boolean isIssueStatus() {
		return issueStatus;
	}

	public void setIssueStatus(boolean issueStatus) {
		this.issueStatus = issueStatus;
	}

	@Override
	public String toString() {
		return "Issue [issueId=" + issueId + ", issueType=" + issueType + ", issueDescription=" + issueDescription
				+ ", issueStatus=" + issueStatus + "]";
	}
	
}
