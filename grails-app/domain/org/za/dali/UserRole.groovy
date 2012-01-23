package org.za.dali

import org.apache.commons.lang.builder.HashCodeBuilder
import org.codehaus.groovy.grails.orm.hibernate.cfg.IdentityEnumType
import org.za.dali.enums.Role

class UserRole {
	
	static belongsTo = [user:User]
	
	Role role

	static constraints = {
		role(nullable: false)
	}

	static mapping = {
		sort(role: "asc")
		role(role: IdentityEnumType,sqlType: "varchar(6)")
	}
	
	boolean equals(other) {
		if (!(other instanceof UserRole)) {
			return false
		}

		other.user?.id == user?.id &&
			other.role?.id == role?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (user) builder.append(user.id)
		if (role) builder.append(role.id)
		builder.toHashCode()
	}

	static UserRole get(long userId, Role role) {
		find 'from UserRole where user.id=:userId and role=:role',
			[userId: userId, role: role]
	}

	static UserRole create(User user, Role role, boolean flush = false) {
		new UserRole(user: user, role: role).save(flush: flush, insert: true)
	}

	static boolean remove(User user, Role role, boolean flush = false) {
		UserRole instance = UserRole.findByUserAndRole(user, role)
		if (!instance) {
			return false
		}

		instance.delete(flush: flush)
		true
	}

	static void removeAll(User user) {
		executeUpdate 'DELETE FROM UserRole WHERE user=:user', [user: user]
	}

	static void removeAll(Role role) {
		executeUpdate 'DELETE FROM UserRole WHERE role=:role', [role: role]
	}

//	static mapping = {
//		id composite: ['role', 'user']
//		version false
//	}
}


