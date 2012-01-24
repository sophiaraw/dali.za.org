package org.za.dali

import java.util.Collection;
import java.util.Date;
import org.za.dali.User;


class InvoiceTag {

	InvoiceTag parent
		
	String title
	User createdBy
    Date dateCreated
	
	Collection invoiceTags
    static hasMany = [invoiceTags:InvoiceTag]
	
	static constraints = {
		title(nullable:false, blank:false)
	}
}
