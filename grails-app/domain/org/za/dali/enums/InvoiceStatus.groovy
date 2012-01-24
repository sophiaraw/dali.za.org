package org.za.dali.enums

enum InvoiceStatus {
	CREATED('Created')
	
	String id
	
	InvoiceStatus(String id) {
		this.id = id
	}
	
	String toString() {
		id
	}
}
