package org.za.dali

import java.util.Date
import org.za.dali.User


class Supplier {

	Company company
	
	String title
	String description
	String code
	
	User createdBy
    Date dateCreated

	Collection contactDetails	
    static hasMany = [contactDetails:ContactDetail]
	
	static constraints = {
		title(nullable:false, blank:false)
		code(nullable:false, blank:false)
	}
}
