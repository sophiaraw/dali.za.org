package org.za.dali

import org.codehaus.groovy.grails.orm.hibernate.cfg.IdentityEnumType
import org.za.dali.enums.OpportunityLevel
import org.za.dali.enums.ProjectStatus
import org.za.dali.enums.ProjectType


class Project {
	
	def userService
	static transients = ['userService']
	
	static auditable = true
	transient String auditLogReason
	
	static belongsTo = [client:Client, parent:Project]
	
	ProjectType type = ProjectType.QUOTE
	ProjectStatus status = ProjectStatus.DRAFT
	
	String jobNumber
	String PONumber
	String title
	String description
	String emailAlias
	Opportunity opportunity
	Boolean retainer = false
	Date retainerStartDate
	Date retainerEndDate
	
	Date requestedDeliveryDate
	Date actualDeliveryDate
	
	User trafficManager
	User projectOwner
	
	User createdBy
    Date dateCreated
	Date expiresOn
	
	Collection contacts
	Collection budgetAdjustments
	Collection rateCards
    static hasMany = [contacts:Contact, budgetAdjustments:BudgetAdjustment, rateCards:RateCard]

	String getTitle() {
		return (!title) ? "${status.name}: ${type.name}" : title 
	}
	
	def beforeInsert() {
//		generateJobNumber()
		if(!createdBy)
		{
			println 'TODO'
//			createdBy = userService.getLoggedInUser()
		}
		
		jobNumber = 'jobNumber'
	}
	
	static constraints = {
//		type(inList:ProjectType.values()*.name)
//		status(inList:ProjectStatus.values()*.name)
		trafficManager(nullable:false)
		projectOwner(nullable:false)
	}

	static mapping = {
		client(fetch: 'join')
		parent(fetch: 'join')
		trafficManager(fetch: 'join')
		projectOwner(fetch: 'join')
		createdBy(fetch: 'join')
		
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