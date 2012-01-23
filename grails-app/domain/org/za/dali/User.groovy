package org.za.dali

import java.util.Date

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
	
	Company costCentre
	
	String username
	String password
	
	String title
	String firstName
	String lastName
	String otherNames
	String preferredName
	String emailAddress
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
	String avatar
	Integer hoursPerDay
	Date contractStartDate
	Date contractEndDate
	Date dateCreated
	
	
	Collection contactDetails
	Collection userProperties
	Collection contacts
	Collection rateCards
	Collection teams
	Collection roles
	Collection logins
	
	static hasOne = [account:Account]
	
	static hasMany = [contactDetails:ContactDetail, userProperties:UserProperty, contacts:UserContact, rateCards:RateCard, teams:UserTeam, roles:UserRole, logins:Login]
	
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
	

	def beforeValidate() {
//		name = name?.trim()
	}
	
	static constraints = {
		costCentre(nullable:false, blank:false)
		username(nullable:false, blank:false, unique:true)
		password(nullable:false, blank:false)
		type(nullable:false, inList:UserType.values().toList())
		status(nullable:false, inList:UserStatus.values().toList())
		firstName(nullable:false, blank:false)
		lastName(nullable:false, blank:false)
		emailAddress(nullable:false, blank:false, email:true)
		userNumber(nullable:false, blank:false)
		// must have at least one team
		//must have at least one next of kin
	}
	
	static mapping = {
//		password column: '`password`'
		sort(lastName: "asc")
		martitalStatus(type: IdentityEnumType,sqlType: "varchar(10)")
		status(type: IdentityEnumType,sqlType: "varchar(10)")
		type(type: IdentityEnumType,sqlType: "varchar(10)")
		roles(fetch: 'join')
	}
}

