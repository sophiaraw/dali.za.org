package org.za.dali

import java.util.Date

class UserTeam {

	static belongsTo = [user:User, team:Team]
	
	TeamLevel level
	Boolean defaultTeam = false
	Date dateCreated
	
	static constraints = {
		level(nullable:false, blank: false)
	}
}
