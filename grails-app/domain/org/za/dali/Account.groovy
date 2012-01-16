package org.za.dali

class Account {

	static belongsTo = [user:User]
	
	String institute
	String branch
	String branchCode
	String accountType
	String accountNumber
		
	static constraints = {
//		emailAddress(email: true, blank: false)
	}

	def beforeValidate() {
//		name = name?.trim()
	}
	
	static embedded = ['somePOGO']
}
