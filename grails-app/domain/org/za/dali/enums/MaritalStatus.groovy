package org.za.dali.enums

enum MaritalStatus {
	SINGLE('S','Single'),
	MARRIED('M','Married'),
	SEPARATED('SEP','Separated'),
	DIVORCED('D','Divorced'),
	WIDOWED('W','Widowed')
	
	String id
	String name
	
	MaritalStatus(String id, String name){
		this.id = id
		this.name = name
	}
	
	String toString() {
		name
	}
}
