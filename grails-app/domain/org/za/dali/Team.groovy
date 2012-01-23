package org.za.dali

class Team {

	Company costCentre
	Team parent
	
	String title
	User leader
	String colour
	Integer hoursPerDay
	
	Collection teams
	Collection rateCards
	Collection serviceLines
	Collection levels
	Collection roles
	
    static hasMany = [teams:Team, serviceLines:ServiceLine, rateCards:RateCard, levels:TeamLevel, roles:TeamRole]
	
	static constraints = {
		costCentre(nullable:false)
		title(nullable:false, blank:false)
		leader(nullable:false)
	}

	static mapping = {
		sort(title: "asc")
		teams(sort: 'title', order: 'asc')
	}
	
	String toString() {
		title
	}
}
