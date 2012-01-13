package org.za.dali.enums

enum TransactionType {
	DEBIT('DR','Debit'),
	CREDIT('CR','Credit')
	
	String id
	String name
	
	TransactionType(String id, String name) {
		this.id = id
		this.name = name
	}
	
	String toString() {
		name
	}
}
