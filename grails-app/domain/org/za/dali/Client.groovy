package org.za.dali

import java.util.Date

import org.codehaus.groovy.grails.orm.hibernate.cfg.IdentityEnumType
import org.za.dali.enums.ClientStatus

class Client {

	static auditable = true
	transient String auditLogReason
	
	static belongsTo = [costCentre:CostCentre,parent:Client]
	
	String name
	ClientStatus status
	String clientCode
	String accountingCode
	String regNumber
	String vatNumber
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
		parent(nullable:true)
		name(blank: false, nullable: false)
		clientCode(blank: false, nullable: false)
	}

	static mapping = {
		sort(name: "asc")
		clients(sort: 'name', order: 'desc')
		contacts(sort: 'role')
		//		contacts(sort: 'role, lastName', order: 'desc')
		status(type: IdentityEnumType,sqlType: "varchar(3)")
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
