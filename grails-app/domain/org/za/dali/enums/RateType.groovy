package org.za.dali.enums

enum RateType {
	HOURLY('H','Hourly'),
	FLAT('F','Flat rate')
	
	String id
	String name
	
	RateType(String id, String name) {
		this.id = id
		this.name = name
	}
	
	String toString() {
		name
	}
}
