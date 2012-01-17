package org.za.dali.enums

enum UserStatus {
	ACTIVE('ACT','Active')
	
	String id
	String name
	
	UserStatus(String id, String name) {
		this.id = id
		this.name = name
	}
	
	String toString() {
		name
	}
}
