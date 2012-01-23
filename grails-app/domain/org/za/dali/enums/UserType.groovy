package org.za.dali.enums

enum UserType {
	INTERNAL('Internal'),
	EXTERNAL('External')
	
	String id
	
	UserType(String id) {
		this.id =id
	}
}
