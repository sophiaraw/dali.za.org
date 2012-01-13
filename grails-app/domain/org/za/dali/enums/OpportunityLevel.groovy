package org.za.dali.enums

enum OpportunityLevel {
	A('A'),
	B('B'),
	C('C'),
	D('D')
	
	String id
	
	OpportunityLevel(String id) {
		this.id = id
	}
	
	String toString() {
		id
	}
}
