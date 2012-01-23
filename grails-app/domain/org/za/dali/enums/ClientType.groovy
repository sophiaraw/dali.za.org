package org.za.dali.enums

enum ClientType {
	BILLABLE('Billable'),
	NON_BILLABLE('Non-Billable')
	
	String id
	
	ClientType(String id) {
		this.id = id
	}
	
	String toString() {
		return id
	}
}
