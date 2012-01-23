package org.za.dali.enums

enum TaskStatus {
	DRAFT('Draft'),
	OPEN('Open'),
	CLOSED('Closed'),
	CANCELLED('Cancelled')
	
	String id
	
	TaskStatus(String id) {
		this.id = id
	}
	
	String toString() {
		id
	}
}
