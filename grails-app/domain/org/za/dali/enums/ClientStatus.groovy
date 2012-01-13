package org.za.dali.enums

enum ClientStatus {
	ACTIVE('A','Active'),
	INACTIVE('IA','Inactive')

	String id
	String name

	ClientStatus(String id, name){
		this.id = id
		this.name = name
	}
}
