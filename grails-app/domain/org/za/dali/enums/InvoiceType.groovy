package org.za.dali.enums

enum InvoiceType {
	INVOICE('Invoice'),
	CREDIT_NOTE('Credit note')
	
	String id
	
	InvoiceType(String id) {
		this.id = id
	}
	
	String toString() {
		id
	}
}
