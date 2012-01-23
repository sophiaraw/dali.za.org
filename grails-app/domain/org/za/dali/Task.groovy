package org.za.dali

import org.codehaus.groovy.grails.orm.hibernate.cfg.IdentityEnumType
import org.za.dali.enums.TaskStatus
import org.za.dali.enums.TaskType

class Task {

	static belongsTo = [project:Project]
	
	User user
	
	TaskType type
	TaskStatus status
	ServiceLine serviceLine
	String title
	String description
	Date startDate
	Date deliveryDate
	BigDecimal allocatedTime
	Boolean reoccuring = false
	Date reocurringEndDate
	BigDecimal progress = 0
		
	Date dateCreated
	User createdBy
	
	Collection taskDetails
    static hasMany = [taskDetails:TaskDetail]
	
	static constraints = {
		type(nullable:false,inList:TaskType.values().toList())
		status(nullable:false,inList:TaskStatus.values().toList())
		serviceLine(nullable:false)
		title(nullable:false)
		progress(min:0, max:100)
	}

	static mapping = {
		type(type: IdentityEnumType,sqlType: "varchar(10)")
		status(type: IdentityEnumType,sqlType: "varchar(10)")
	}
}
