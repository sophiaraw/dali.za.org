package org.za.dali.enums

enum Role {
	TRAFFIC('Traffic - manager'),
	FINANCE_MNG('Finance - Manager'),
	CLIENT_SERVICE_MANAGER('Client Service - Manager'),
	TEAM_EDIT('Team - Edit'),
	RATE_EDIT('Rate - Edit'),
	USER_EDIT('User - Edit'),
	PROJECT_EDIT('Project - Edit'),
	PROJECT_APPROVE('Project - Approve'),
	QUOTE_EDIT('Quote - Edit'),
	QUOTE_APPROVAL('Quote - Approve'),
	TASK_ASSIGN('Task - Assign')
	
	
	String id
	
	Role(String id) {
		this.id = id
	}
	
	String toString() {
		id
	}
}
