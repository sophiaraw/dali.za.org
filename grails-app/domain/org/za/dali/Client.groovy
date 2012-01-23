package org.za.dali

import java.util.Date

import org.codehaus.groovy.grails.orm.hibernate.cfg.IdentityEnumType
import org.za.dali.enums.ClientStatus
import org.za.dali.enums.ClientType

class Client {

	static auditable = true
	transient String auditLogReason
	
	static belongsTo = [costCentre:CostCentre,parent:Client]
	
	String title
	ClientStatus status = ClientStatus.ACTIVE
	ClientType type = ClientType.BILLABLE 
	String code
	String accountingCode
	String regNumber
	String vatNumber
	String vatCategory
	Boolean taxable = true
	Date dateCreated
	
	Collection clients
	Collection contactDetails
	Collection contacts
	Collection rateCards
	Collection projects

	static hasMany = [clients:Client,contactDetails:ContactDetail,contacts:Contact, rateCards:RateCard, projects:Project]

	static constraints = {
		costCentre(nullable:false)
		title(blank: false, nullable: false)
		code(blank: false, nullable: false)
		status(nullable:false, inList:ClientStatus.values().toList())
		type(nullable:false, inList:ClientType.values().toList())
	}

	static mapping = {
		sort(title: "asc")
		status(type: IdentityEnumType,sqlType: "varchar(10)")
	}
	
//	def onChange = { oldMap,newMap ->
//		println "Person was changed ..."
//		oldMap.each({ key, oldVal ->
//			if(oldVal != newMap[key]) {
//				println " * $key changed from $oldVal to " + newMap[key]
//			}
//		})
//	}
}
