package org.za.dali

import java.util.Date

import org.codehaus.groovy.grails.orm.hibernate.cfg.IdentityEnumType
import org.za.dali.enums.RateType

class Rate {

	static auditable = true
	transient String auditLogReason
	
	static belongsTo = [rateCard:RateCard, project:Project, client:Client, user:User, team:Team]
	
	RateType type = RateType.HOURLY
	ServiceLine serviceLine
	TeamLevel level
	Boolean active = false
	
	Date activeDate
	Date expiryDate
	Date dateCreated
	
	static constraints = {
		type(nullable:false)
		rateCard(nullable:false)
		serviceLine(nullable:false)
		level(nullable:false)
	}

	static mapping = {
		type(type: IdentityEnumType,sqlType: "varchar(3)")
	}
}
