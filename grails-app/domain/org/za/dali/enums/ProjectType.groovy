package org.za.dali.enums

enum ProjectType {
	QUOTE('Q','Quote'),
	PROJECT('P','Project')
	
	String id
	String name
	
	ProjectType(String id, String name) {
		this.id = id
		this.name = name
	}
	
	String toString() {
		name
	}
}
