package org.za.dali.enums

enum AccountEntryStatus {
	CREATED('Created'),
	INVOICED('Invoiced')
	
	String id
	
	AccountEntryStatus(String id) {
		this.id = id
	}
	
	String toString() {
		id
	}
}
