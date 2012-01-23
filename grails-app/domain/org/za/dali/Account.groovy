package org.za.dali

class Account {

	static belongsTo = [user:User]
	
	String institute
	String branch
	String branchCode
	String accountType
	String accountNumber
		
	static constraints = {
		institute(nullable:false, blank:false)
		accountNumber(nullable:false, blank:false)
	}
}
