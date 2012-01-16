package org.za.dali

import org.codehaus.groovy.grails.orm.hibernate.cfg.IdentityEnumType
import org.za.dali.enums.AccountingSoftware
import org.za.dali.enums.Currency

class CostCentre {
	
	static auditable = true
	transient String auditLogReason
	
	static belongsTo = [parent:CostCentre]
	
	String name
	String registeredName
	String prefix
	Currency currency
	AccountingSoftware accSoftware
	GeoLocation geoLocation
	Long vatPercentage
	Integer invoiceDay
    Date dateCreated
	
	Collection<Client> clients
	Collection<ContactDetail> contactDetails

	static hasMany = [clients:Client, contactDetails:ContactDetail]

	static constraints = {
		parent(nullable:true)
		name(blank: false, nullable: false)
		registeredName(blank: false, nullable: false)
		prefix(blank: false, nullable: false)
		vatPercentage(blank: false, nullable: false)
		invoiceDay(nullable:true,min:1,max:31)
	}

	static mapping = {
		sort name: "asc"
		currency(type: IdentityEnumType,sqlType: "varchar(3)")
		accSoftware(type: IdentityEnumType,sqlType: "varchar(6)")
	}

	static embedded = ['geoLocation']

	String toString() {
		"$prefix: $name"
	}
	
//	def onChange = { oldMap,newMap ->
//		newMap.put('ALReason','This is my reason for the change')
//		println "CostCentre was changed ..."
//		oldMap.each({ key, oldVal ->
//			if(oldVal != newMap[key]) {
//				println " * $key changed from $oldVal to " + newMap[key]
//			}
//		})
//		newMap.each({ key, val ->
//		  println val
//		})
//	}
}

class GeoLocation {
	Long latitude
	Long longitude
	Integer zoomLevel
}
