package org.za.dali

import org.codehaus.groovy.grails.orm.hibernate.cfg.IdentityEnumType
import org.za.dali.enums.MaritalStatus
import org.za.dali.enums.UserStatus
import org.za.dali.enums.UserType

class User {

	static auditable = true
	transient String auditLogReason

	transient springSecurityService
	transient Boolean accountExpired = false
	transient Boolean accountLocked = false
	transient Boolean passwordExpired = false
	
	CostCentre costCentre
	
	String username
	String password
	
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
	//TODO avatar
	Integer hoursPerDay
	Date contractStartDate
	Date contractEndDate

	
	Collection contactDetails
	Collection contacts
	Collection rateCards
	Collection teams
	Collection roles
	Collection logins
	
	static hasOne = [account:Account]
	
	static hasMany = [contactDetails:ContactDetail, contacts:UserContact, rateCards:RateCard, teams:UserTeam, roles:UserRole, logins:Login]
	
	def getAuthorities() {
		return roles
	}
	
	Boolean isEnabled() {
		return status.is(UserStatus.ACTIVE)
	}
	
	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}
	
	static constraints = {
		costCentre(nullable: false,blank: false)
		username(email: true, blank: false, unique: true)
		password(blank: false)
		// must have at least one team
	}

	def beforeValidate() {
//		name = name?.trim()
	}
	
	static mapping = {
		password column: '`password`'
		sort(lastName: "asc")
//		childCollection(sort: 'number', order: 'desc')
		martitalStatus(type: IdentityEnumType,sqlType: "varchar(3)")
		status(type: IdentityEnumType,sqlType: "varchar(3)")
		type(type: IdentityEnumType,sqlType: "varchar(3)")
		roles(lazy: false)
	}
}

