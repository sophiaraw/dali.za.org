package org.za.dali

class ServiceLine {

	static belongsTo = [team:Team]
	
	String title
	String description
	Boolean active = true
	
	
	static constraints = {
		title(nullable:false, blank:false)
	}

	static mapping = {
		sort(title: "asc")
	}
}
