package org.za.dali

class User {

    static hasMany = []
	
	static constraints = {
//		emailAddress(email: true, blank: false)
	}

	def beforeValidate() {
//		name = name?.trim()
	}
	
	static mapping = {
//		sort(name: "asc")
//		childCollection(sort: 'number', order: 'desc')
//		enumName(type: IdentityEnumType,sqlType: "varchar(3)")

	}
}