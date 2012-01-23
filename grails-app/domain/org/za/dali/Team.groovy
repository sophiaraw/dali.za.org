package org.za.dali

class Team {

	static belongsTo = [costCentre:CostCentre, parent:Team]
	
	String title
	User leader
	String colour
	Integer hoursPerDay
	
	Collection teams
	Collection rateCards
	Collection serviceLines
	Collection levels
	Collection roles
	
    static hasMany = [teams:Team, rateCards:RateCard, serviceLines:ServiceLine, levels:TeamLevel, roles:TeamRole]
	
	static constraints = {
		costCentre(nullable:false)
		parent(nullable:true)
		title(nullable:false)
		leader(nullable:false)
	}

	static mapping = {
		sort(title: "asc")
		teams(sort: 'title', order: 'asc')
	}
}
