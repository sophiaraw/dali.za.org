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
	}
	
	static mapping = {
		sort(relationship: "asc")
	}
}
