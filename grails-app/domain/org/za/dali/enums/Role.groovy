package org.za.dali.enums

enum Role {
	TRAFFIC('TM','Traffic manager')
	
	String id
	String name
	
	Role(String id, String name) {
		this.id = id
		this.name = name
	}
	
	String toString() {
		name
	}
}
