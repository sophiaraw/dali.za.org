package org.za.dali

import java.util.Date

import org.codehaus.groovy.grails.orm.hibernate.cfg.IdentityEnumType
import org.za.dali.enums.OpportunityLevel
import org.za.dali.enums.ProjectStatus
import org.za.dali.enums.ProjectType

class Project {
	
	static auditable = true
	transient String auditLogReason
	
	static belongsTo = [client:Client, parent:Project]
	User trafficManager
	ProjectType type = ProjectType.QUOTE
	ProjectStatus status = ProjectStatus.DRAFT
	String number
	String PONumber
	String title
	String description
	String emailAlias
	Opportunity opportunity
	Boolean retainer
	Date retainerStartDate
	Date retainerEndDate
	
	Date requestedDeliveryDate
	Date actualDeliveryDate
	
	User createdBy
    Date dateCreated
	Date expiresOn
	
	Collection contacts
	Collection budgetAdjustments
	Collection rateCards
    static hasMany = [contacts:Contact, budgetAdjustments:BudgetAdjustment, rateCards:RateCard]

	static constraints = {
//     	status(nullable: false)
	}

	static mapping = {
		sort(dateCreated: "desc")
		type(type: IdentityEnumType,sqlType: "varchar(3)")
		status(type: IdentityEnumType,sqlType: "varchar(3)")
	}
	
	static embedded = ['opportunity']
}

class Opportunity {
	OpportunityLevel level
	Long percentage
	Date date
}