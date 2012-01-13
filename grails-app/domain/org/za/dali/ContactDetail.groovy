package org.za.dali

import org.codehaus.groovy.grails.orm.hibernate.cfg.IdentityEnumType
import org.za.dali.enums.ContactDetailType

class ContactDetail {

	static belongsTo = [costCentre:CostCentre,client:Client]
	
	ContactDetailType type
	String name
	String value

	static constraints = {
		value(blank:false, nullable:false)
		costCentre(nullable:true)
		client(nullable:true)
	}

	static mapping = {
		sort name: "asc"
		type(type: IdentityEnumType,sqlType: "varchar(8)")
		value(type:'text')
	}
	
	String toString(){
		"$name"
	}
}
