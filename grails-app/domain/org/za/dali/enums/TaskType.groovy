package org.za.dali.enums

enum TaskType {
	QUOTING('Q','Quoting'),
	PROJECT('P','Project')
	
	String id
	String name
	
	TaskType(String id, String name) {
		this.id = id
		this.name = name
	}
	
	String toString() {
		name
	}
}
