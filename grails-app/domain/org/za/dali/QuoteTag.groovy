package org.za.dali

import java.util.Date;
import org.za.dali.User;

class QuoteTag {

    QuoteTag parent
		
	String title
	User createdBy
    Date dateCreated
	
	Collection quoteTags
    static hasMany = [quoteTags:QuoteTag]
	
	static constraints = {
		title(nullable:false, blank:false)
	}
}
