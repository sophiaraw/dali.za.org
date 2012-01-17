package org.za.dali

import org.za.dali.enums.Role

class ContactService {

    def getContactsWithRole(Project project, Role role) {
		return Contact.findAll(new Contact(project:Project, role:Role))
    }
}
