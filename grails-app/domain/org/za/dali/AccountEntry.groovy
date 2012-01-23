package org.za.dali

import java.util.Date;
import org.za.dali.User;
import org.za.dali.enums.AccountEntryStatus;
import org.za.dali.enums.TransactionType;


class AccountEntry {

	static belongsTo = [project:Project]
	
	Supplier supplier
	
	AccountEntryStatus status
	String title
	String description
	TransactionType type
	BigDecimal value
	Boolean taxable = true
	User createdBy
    Date dateCreated

	QuoteTag quoteTag
		
	static constraints = {
		status(nullable:false, inList:AccountEntryStatus.values().toList())
		type(nullable:false, inList:TransactionType.values().toList())
		title(nullable:false, blank:false)
		value(nullable:false, blank:false)
	}

	static mapping = {
		status(type: IdentityEnumType,sqlType: "varchar(10)")
		type(type: IdentityEnumType,sqlType: "varchar(10)")
	}
}
