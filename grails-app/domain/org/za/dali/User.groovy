package org.za.dali

import org.codehaus.groovy.grails.orm.hibernate.cfg.IdentityEnumType
import org.za.dali.enums.MaritalStatus
import org.za.dali.enums.UserStatus
import org.za.dali.enums.UserType

class User {

	static auditable = true
	transient String auditLogReason

	static belongsTo = [team:Team]
	
	String title
	String firstName
	String lastName
	String otherNames
	String preferredName
	MaritalStatus martitalStatus
	String userNumber
	String residency
	String idNumber
	String passportNumber
	String revenueOffice
	String taxNumber
	Date dob
	UserStatus status
	UserType type
	TeamLevel level
	Date contractStartDate
	Date contractEndDate

	
	Collection contactDetails
	Collection contacts
	Collection rateCards
	Collection teams
	Collection roles
	
	static hasOne = [account:Account]
	
	static hasMany = [contactDetails:ContactDetail, contacts:UserContact, rateCards:RateCard, teams:UserTeam, roles:UserRole]
	
	static constraints = {
//		emailAddress(email: true, blank: false)
	}

	def beforeValidate() {
//		name = name?.trim()
	}
	
	static mapping = {
		sort(lastName: "asc")
//		childCollection(sort: 'number', order: 'desc')
		martitalStatus(type: IdentityEnumType,sqlType: "varchar(3)")
		status(type: IdentityEnumType,sqlType: "varchar(3)")
		type(type: IdentityEnumType,sqlType: "varchar(3)")
	}
}

