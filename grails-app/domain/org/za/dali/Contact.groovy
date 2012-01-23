package org.za.dali

import org.apache.commons.validator.EmailValidator

class Contact {

	static belongsTo = [client:Client, project:Project]
	User user
	
	String firstName
	String lastName
	String emailAddress
	String phoneNumber
	String mobileNumber
	String designation

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
		designation(nullable:false, blank:false)
	}
}
