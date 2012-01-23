package org.za.dali

import java.util.Date

import org.codehaus.groovy.grails.orm.hibernate.cfg.IdentityEnumType
import org.za.dali.enums.RateType

class Rate {

	static auditable = true
	transient String auditLogReason
	
	static belongsTo = [rateCard:RateCard, project:Project, client:Client, user:User, team:Team]

	ServiceLine serviceLine
	TeamLevel level
	RateType type = RateType.HOURLY
	BigDecimal value
	Boolean active = false
	
	Date dateCreated
	
	static constraints = {
		rateCard(nullable:false)
		serviceLine(nullable:false)
		level(nullable:false)
		type(nullable:false,inList:RateType.values().toList())
		value(nullable:false, blank:false)
	}

	static mapping = {
		type(type: IdentityEnumType,sqlType: "varchar(10)")
	}
}
