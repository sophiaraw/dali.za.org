package org.za.dali.enums

enum AccountingSoftware {
	ACCPAC('ACCPAC', ['vatCategoryList'])
	
	String id
	
	AccountingSoftware(String id) {
		this.id = id
	}
	
	String getId() {
		id
	}
}
