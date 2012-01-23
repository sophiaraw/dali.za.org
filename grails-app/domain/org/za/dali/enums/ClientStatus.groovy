package org.za.dali.enums

enum ClientStatus {
	ACTIVE('Active'),
	INACTIVE('Inactive')

	String id

	ClientStatus(String id){
		this.id = id
	}
	
	String toString() {
		id
	}
}
