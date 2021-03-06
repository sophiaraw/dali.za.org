package org.za.dali

import java.util.Date

import org.codehaus.groovy.grails.orm.hibernate.cfg.IdentityEnumType
import org.za.dali.enums.TransactionType

class BudgetAdjustment {

	static belongsTo = [project:Project]
	
	TransactionType type
	BigDecimal value
    Project relatedProject	
	String reason
	User createdBy
	User approvedBy
	Date dateCreated
	
	static constraints = {
		project(nullable: false)
		type(nullable: false)
		value(nullable: false)
		reason(nullable: false, blank: false)
	}

	static mapping = {
		sort(dateCreated: 'asc')
		type(type: IdentityEnumType,sqlType: 'varchar(2)')
	}
	
	String toString() {
		"${type.name} $value" 
	}
}
