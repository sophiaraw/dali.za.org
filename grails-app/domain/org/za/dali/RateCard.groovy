package org.za.dali

import java.util.Date

import org.codehaus.groovy.grails.orm.hibernate.cfg.IdentityEnumType
import org.za.dali.enums.RateCardStatus

class RateCard {
	
	static auditable = true
	transient String auditLogReason
	
	Project project
	Client client
	User user
	Team team
	
    String title
	String description
	RateCardStatus status = RateCardStatus.DRAFT
	Date activeDate
	Date expiryDate
	
	Collection rates
    static hasMany = [rates:Rate]
	
	static constraints = {
		title(nullable:false, blank:false)
		status(nullable:false,inList:RateCardStatus.values().toList())
	}

	static mapping = {
		sort(startDate: "asc")
		status(type: IdentityEnumType,sqlType: "varchar(10)")
	}
	
	String toString() {
		title
	}
}
