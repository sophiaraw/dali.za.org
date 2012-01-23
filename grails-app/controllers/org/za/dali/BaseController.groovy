package org.za.dali

import java.sql.Time

class BaseController {

    def index() {
		String timeStrA = '309:45:00'
		String timeStrB = '5:15:00'
		
		sumTime( [Time.valueOf(timeStrA), Time.valueOf(timeStrB)])
	}
	
	def sumTime( times ) {
		long zero = Time.valueOf( '00:00:00' ).time
		new Time( zero + times.sum { it.time - zero } )
	}
}
