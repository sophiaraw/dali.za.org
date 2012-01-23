package org.za.dali

import java.util.Date

class UserProperty {

	static belongsTo = [user:User]
	
	String name
	String value
    Date dateCreated
	
	static constraints = {
		name(nullable:false, blank:false)
		value(nullable:false, blank:false)
	}
}
