package org.za.dali

class TaskDetail {

	static belongsTo = [task:Task, parent:TaskDetail]
	
	String title
	String description
	Date startDate
	Date endDate
	
	Collection taskDetails
    static hasMany = [taskDetails:TaskDetail]
	
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
	
	static embedded = ['somePOGO']
}
