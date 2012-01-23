package org.za.dali

class ServiceLine {

	static belongsTo = [team:Team]
	
	String title
	String description
	String code
	Boolean active = true
	
	
	static constraints = {
		title(nullable:false, blank:false)
		code(nullable:false, blank:false)
		active(nullable:false)
	}

	static mapping = {
		sort(title: "asc")
	}
	
	String toString() {
		title
	}
}
