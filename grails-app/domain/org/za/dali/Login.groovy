package org.za.dali

import java.util.Date

class Login {

	static belongsTo = [user:User]

	String ip
	Date dateCreated
}
