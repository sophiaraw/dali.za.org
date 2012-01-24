package org.za.dali

import java.util.Date;
import org.za.dali.User;

class InvoicePayment {

	static belongsTo = [invoice:Invoice]
	
    BigDecimal value	
	
    Date dateCreated
	
	static constraints = {
		value(nullable:false, blank:false)
	}
}
