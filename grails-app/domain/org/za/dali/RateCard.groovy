package org.za.dali

import org.codehaus.groovy.grails.orm.hibernate.cfg.IdentityEnumType
import org.za.dali.enums.RateCardStatus

class RateCard {
	
	Project project
	Client client
	User user
	Team team
	
    String title
	String description
	RateCardStatus status = RateCardStatus.DRAFT
	
	Collection rates
    static hasMany = [rates:Rate]
	
	static constraints = {
		name(nullable:false, blank:false)
	}

	static mapping = {
		sort(startDate: "asc")
		status(type: IdentityEnumType,sqlType: "varchar(3)")
	}
}
