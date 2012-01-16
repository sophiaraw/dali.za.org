package org.za.dali.enums

enum RateCardStatus {
	DRAFT('DRF','Draft'),
	ACTIVE('ACT', 'Active'),
	EXPIRED('EXP','Expired'),
	CANCELLED('CNL','Cancelled')
	
	String id
	String name
	
	RateCardStatus(String id, String name) {
		this.id = id
		this.name = name
	}
	
	String toString() {
		name
	}
}
