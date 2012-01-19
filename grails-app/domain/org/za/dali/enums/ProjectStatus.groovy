package org.za.dali.enums

enum ProjectStatus {
	DRAFT('DRA','Draft'),
	REQUESTED('REQ','Requested'),
	QUOTED('QUO','Quoted'),
	ISSUED('ISS','Issued'),
	ACCEPTED('ACC','Accepted'),
	REJECTED('REJ','Rejected'),
	CANCELLED('CAN','Cancelled'),
	SCHEDULE('SCH','Schedule'),
	OPEN('OPE','Open'),
	CLOSED('CLO','Closed'),
	DELETED('DLT','Deleted')
	
	String id
	String name
	
	ProjectStatus(String id, String name) {
		this.id = id
		this.name = name
	}
	
	String toString() {
		name
	}
}
