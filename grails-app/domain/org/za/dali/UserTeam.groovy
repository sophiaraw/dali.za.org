package org.za.dali

class UserTeam {

	static belongsTo = [user:User, team:Team]
	
	TeamLevel level
		
	static constraints = {
		level(nullable:false, blank: false)
	}
}
