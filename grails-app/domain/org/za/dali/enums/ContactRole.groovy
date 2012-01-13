package org.za.dali.enums

enum ContactRole {
	FINANCE('FIN','Finance'),
	PROJECT_OWNER('PO','Project owner'),

	String id
	String name

	ContactRole(String id, String name){
		this.id = id
		this.name = name
	}
}
