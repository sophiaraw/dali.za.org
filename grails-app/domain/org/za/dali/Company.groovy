package org.za.dali

import org.codehaus.groovy.grails.orm.hibernate.cfg.IdentityEnumType
import org.za.dali.enums.AccountingSoftware
import org.za.dali.enums.Currency

class Company {
	
	static auditable = true
	transient String auditLogReason
	
	Company parent
	
	String title
	String registeredName
	String prefix
	Currency currency
	AccountingSoftware accSoftware
	GeoLocation geoLocation
    BigDecimal vatPercentage;
	Integer invoiceDay
	Integer billingDay
	String logo
    Date dateCreated
	
	Collection<Client> clients
	Collection<ContactDetail> contactDetails

	static hasMany = [clients:Client, contactDetails:ContactDetail]

	static constraints = {
		title(blank: false, nullable: false)
		registeredName(blank: false, nullable: false)
		prefix(blank: false, nullable: false)
		currency(nullable:false,inList:Currency.values().toList())
		vatPercentage(blank: false, nullable: false)
		invoiceDay(nullable:true,min:1,max:31)
		billingDay(nullable:true,min:1,max:31)
	}

	static mapping = {
		sort title: "asc"
		currency(type: IdentityEnumType,sqlType: "varchar(10)")
		accSoftware(type: IdentityEnumType,sqlType: "varchar(10)")
	}

	static embedded = ['geoLocation']

	String toString() {
		"$prefix: $title"
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
