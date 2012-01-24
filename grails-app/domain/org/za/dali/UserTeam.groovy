package org.za.dali

import java.util.Collection;
import java.util.Date

class UserTeam {

	static belongsTo = [user:User, team:Team]
	
	TeamLevel level
	Boolean defaultTeam = false
	Date dateCreated
	
	Collection rateCards
	static hasMany = [rateCards:RateCard]
	
	static constraints = {
		level(nullable:false, blank: false)
	}
}
