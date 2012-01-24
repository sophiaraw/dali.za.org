package org.za.dali

import java.util.Date;

import org.codehaus.groovy.grails.orm.hibernate.cfg.IdentityEnumType;
import org.za.dali.User;
import org.za.dali.enums.InvoiceStatus;
import org.za.dali.enums.InvoiceType;


class Invoice {

	static belongsTo = [project:Project]
	
	Client client
	Invoice parent
	
	String number
	InvoiceType type
	InvoiceStatus status
	
	User createdBy
    Date dateCreated
	
	Collection invoices
    static hasMany = [invoices:Invoice]
	
	static constraints = {
		type(nullable:false, inList:InvoiceType.values().toList())
		status(nullable:false, inList:InvoiceStatus.values().toList())
	}

	static mapping = {
		sort(dateCreated: "asc")
		type(type: IdentityEnumType,sqlType: "varchar(10)")
		status(type: IdentityEnumType,sqlType: "varchar(10)")
	}
}
