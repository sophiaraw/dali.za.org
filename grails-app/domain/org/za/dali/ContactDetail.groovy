package org.za.dali

import org.codehaus.groovy.grails.orm.hibernate.cfg.IdentityEnumType
import org.za.dali.enums.ContactDetailType

class ContactDetail {

	static belongsTo = [costCentre:Company,client:Client,user:User]
	
	ContactDetailType type
	String name
	String value

	static constraints = {
		value(blank:false, nullable:false)
		type(nullable:false, inList:ContactDetailType.values().toList())
		name(nullable:false, blank:false)
		value(nullable:false, blank:false)
	}

	static mapping = {
		sort name: "asc"
		type(type: IdentityEnumType,sqlType: "varchar(108)")
		value(type:'text')
	}
	
	String toString(){
		name
	}
}
