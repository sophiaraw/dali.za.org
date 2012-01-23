package org.za.dali.enums

enum RoleType {
	TRAFFIC_MANAGER('Traffic - manager'),
	TASK_ASSIGN('Task - Assign'),
	
	FINANCE_MANAGER('Finance - Manager'),
	
	CLIENT_SERVICE_MANAGER('Client Service - Manager'),
	
	TEAM_EDIT('Team - Edit'),
	
	RATE_EDIT('Rate - Edit'),
	
	USER_EDIT('User - Edit'),
	
	PROJECT_EDIT('Project - Edit'),
	PROJECT_APPROVE('Project - Approve'),
	
	QUOTE_EDIT('Quote - Edit'),
	QUOTE_APPROVAL('Quote - Approve')
	
	
	String id
	
	RoleType(String id) {
		this.id = id
	}
	
	String toString() {
		id
	}
}
