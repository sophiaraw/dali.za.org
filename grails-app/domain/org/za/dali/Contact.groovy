package org.za.dali

import org.apache.commons.validator.EmailValidator
import org.codehaus.groovy.grails.orm.hibernate.cfg.IdentityEnumType
import org.za.dali.enums.ContactRole

class Contact {

	static belongsTo = [client:Client, project:Project]
	User user
	
	String firstName
	String lastName
	String emailAddress
	String phoneNumber
	String mobileNumber
	ContactRole role

	static constraints = {
		emailAddress(validator: { val, obj ->
			if (!obj.user) {
				def emailValidator = EmailValidator.getInstance()

				return emailValidator.isValid(val)
			}
			else {
				return true
			}
		})
	}

	static mapping = {
		role(type: IdentityEnumType,sqlType: 'varchar(3)')
	}
}
