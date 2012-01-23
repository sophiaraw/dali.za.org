package org.za.dali

import org.za.dali.enums.RoleType

class ContactService {

    def getContactsWithRole(Project project, RoleType role) {
		return Contact.findAll(new Contact(project:Project, role:RoleType))
    }
}
