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
	Boolean recordable = true
		
	Date dateCreated
	User createdBy
	
	QuoteTag quoteTag
	
	Collection tasks
    static hasMany = [tasks:Task]
	
	static constraints = {
		type(nullable:false,inList:TaskType.values().toList())
		status(nullable:false,inList:TaskStatus.values().toList())
		serviceLine(nullable:false)
		title(nullable:false)
		progress(min:new BigDecimal(0), max:new BigDecimal(100))
	}

	static mapping = {
		type(type: IdentityEnumType,sqlType: "varchar(10)")
		status(type: IdentityEnumType,sqlType: "varchar(10)")
	}
}

/*
 * when closing the task, update progress to 100
 * When the parent task gets closed, 
 * 		close all the children
 *      notify - either Project owner
 *             - or tasks waiting on this one
 * 
 */
