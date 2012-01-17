package org.za.dali

import org.za.dali.enums.TaskStatus
import org.za.dali.enums.TaskType

class Task {

	static belongsTo = [project:Project, owner:User]

	TaskType type
	TaskStatus status
	ServiceLine serviceLine
	String title
	String description
	Date startDate
	Date deliveryDate
	Integer allocatedTime
	Boolean reoccuring = false
	Date reocurringEndDate
		
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
