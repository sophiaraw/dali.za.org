package org.za.dali

import org.codehaus.groovy.grails.orm.hibernate.cfg.IdentityEnumType
import org.za.dali.enums.OpportunityLevel
import org.za.dali.enums.ProjectStatus
import org.za.dali.enums.ProjectType
import org.za.dali.enums.TransactionType


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
	Boolean taxable = true
	
	Date requestedDeliveryDate
	Date actualDeliveryDate
	
	User trafficManager
	User projectOwner
	
	User createdBy
    Date dateCreated
	Date expiresOn //used for type=Quote
	
	Collection contacts
	Collection budgetAdjustments
	Collection rateCards
    static hasMany = [contacts:Contact, budgetAdjustments:BudgetAdjustment, rateCards:RateCard]

	transient BigDecimal totalBudget

	String getTitle() {
		return (!title) ? "${status.name}: ${type.name}" : title 
	}
	
	BigDecimal getBudget() {
	  if(!totalBudget) {
		  budgetAdjustments.each() {
			  if(TransactionType.DEBIT.is( it.type)) {
				  totalBudget.add(it.value)
			  }
			  else {
				  totalBudget.subtract(it.type)
			  }
		  }
	  }
	}
	
	def beforeInsert() {
//		generateJobNumber()
		if(!createdBy)
		{
			println 'TODO "domain/Project add loggedin user as createBy'
//			createdBy = userService.getLoggedInUser()
		}
		
		jobNumber = 'jobNumber'
	}
	
	static constraints = {
		client(nullable:false, blank:false)
		type(nullable:false,inList:ProjectType.values().toList())
		status(nullable:false,inList:ProjectStatus.values().toList())
		jobNumber(nullable:false, blank:false, unique:true)
		title(nullable:false, blank:false)
		trafficManager(nullable:false)
		projectOwner(nullable:false)
		//Can you invoice without a PONumber?
		//if retainer then startdate and end date required
	}

	static mapping = {
		client(fetch: 'join')
		parent(fetch: 'join')
		trafficManager(fetch: 'join')
		projectOwner(fetch: 'join')
		createdBy(fetch: 'join')
		
		sort(dateCreated: "desc")
		type(type: IdentityEnumType,sqlType: "varchar(10)")
		status(type: IdentityEnumType,sqlType: "varchar(10)")
	}
	
	static embedded = ['opportunity']
}

class Opportunity {
	OpportunityLevel level
	Long percentage
	Date date
}