package org.za.dali

class TaskBill {

	static belongsTo = [task:Task]
	
	Invoice invoice
	
	BigDecimal value
	BigDecimal writtenOffValue
	
	User createdBy
	User approvedBy
	Date dateCreated
	
	static constraints = {
		value(nullable:false, blank:false)
	}
}
