package org.za.dali.enums

enum TransactionType {
	DEBIT('DR','Debit'), //Comes in +
	CREDIT('CR','Credit') //Goes out -
	
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
