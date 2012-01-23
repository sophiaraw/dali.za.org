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
	ClientStatus status
	ClientType type = ClientType.BILLABLE 
	String clientCode
	String accountingCode
	String regNumber
	String vatNumber
	//Enum vatCategory
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
		prefix(nullable:false,unique:true,size:1..8)
	}

	static mapping = {
		sort(name: "asc")
		clients(sort: 'name', order: 'desc')
		contacts(sort: 'role')
		//		contacts(sort: 'role, lastName', order: 'desc')
		status(type: IdentityEnumType,sqlType: "varchar(3)")
		prefix(sqlType:"varchar(8)",unique:true)
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
