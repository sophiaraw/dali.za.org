package org.za.dali

class UserContact {

	static belongsTo = [user:User]
	
	String firstName
	String lastName
	Character gender
	Date dob
	String relationship
	String address
	String phoneNumber
	String mobileNumber
	String emailAddress
		
	static constraints = {
		firstName(nullable:false, blank:false)
		lastName(nullable:false, blank:false)
		relationship(nullable:false, blank:false)
		emailAddress(email: true, blank: true)
	}

	def beforeValidate() {
//		name = name?.trim()
	}
	
	static mapping = {
		sort(relationship: "asc")
	}
}
