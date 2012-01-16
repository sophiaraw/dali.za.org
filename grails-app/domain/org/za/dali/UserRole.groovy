package org.za.dali

import org.codehaus.groovy.grails.orm.hibernate.cfg.IdentityEnumType
import org.za.dali.enums.Role

class UserRole {
	
	static belongsTo = [user:User]
	
	Role role

	static constraints = {
		role(nullable: false)
	}

	static mapping = {
		sort(role: "asc")
		role(role: IdentityEnumType,sqlType: "varchar(6)")
	}
}


