package org.za.dali

import java.sql.Time

class BaseController {

    def index() {
	}
	
	def sumTime( times ) {
		long zero = Time.valueOf( '00:00:00' ).time
		new Time( zero + times.sum { it.time - zero } )
	}
}
