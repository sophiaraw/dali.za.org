package org.za.dali

import java.util.Date

class Login {

	static belongsTo = [user:User]

	def beforeInsert = {
	}
	
	String ip
	Date dateCreated
}
