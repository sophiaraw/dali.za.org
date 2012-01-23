package org.za.dali

class TeamLevel {

	static belongsTo = [team:Team]
	
	String title
	String description
	Boolean active = true
	
	
	static constraints = {
		title(nullable:false, blank:false)
		active(nullable:false)
	}

	static mapping = {
		sort(title: "asc")
	}
	
	String toString() {
		title
	}
}
