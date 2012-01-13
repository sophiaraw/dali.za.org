package org.za.dali

import org.codehaus.groovy.grails.orm.hibernate.cfg.IdentityEnumType
import org.za.dali.enums.ClientStatus

class Client {

	static belongsTo = [costCentre:CostCentre,parent:Client]
	
	String name
	ClientStatus status
	String clientCode
	String accountingCode
	String regNumber
	String vatNumber
	Boolean taxable = true

	Collection clients
	Collection contactDetails
	Collection contacts

	static hasMany = [clients:Client,contactDetails:ContactDetail,contacts:Contact]

	static constraints = {
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
