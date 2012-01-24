package org.za.dali.enums

enum AccountingSoftware {
	ACCPAC('ACCPAC')
	
	String id
	
	AccountingSoftware(String id) {
		this.id = id
	}
	
	String getId() {
		id
	}
}
