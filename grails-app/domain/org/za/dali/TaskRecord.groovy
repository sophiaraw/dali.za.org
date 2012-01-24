package org.za.dali

import java.sql.Time;

import org.za.dali.Task

class TaskRecord {

	static belongsTo = [task:Task]
	
	String description
	Time time
	
	Date dateCreated
	
	static constraints = {
		time(nullable:false, blank:false)
	}
}
