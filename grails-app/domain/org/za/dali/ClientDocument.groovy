package org.za.dali

import java.util.Date

class ClientDocument {

	Client client
	Project project
	
	String title
	String description
	String location
	
	User createdBy
    Date dateCreated

	static constraints = {
		title(nullable:false, blank:false)
		location(nullable:false, blank:false)
	}

	static mapping = {
		sort(title: "asc")
	}
}
