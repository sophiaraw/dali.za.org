package org.za.dali.enums

enum TaskStatus {
	DRAFT('DFT','Draft'),
	OPEN('OPN','Open'),
	CLOSED('CLO','Closed'),
	CANCELLED('CAN','Cancelled')
	
	String id
	String name
	
	TaskStatus(String id, String name) {
		this.id = id
		this.name = name
	}
	
	String toString() {
		name
	}
}
