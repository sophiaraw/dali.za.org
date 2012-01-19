package org.za.dali

class AuthoriseService {

	/*
	 * @Authorise("hasRole('ADMIN')")
	 */
    def hasRole(String role) {
//	    return adminRoles.contains(role)
		println 'TODO AuthoriseService.hasRole' 
		
		return true
	}
	
	/*
	 * @Authorise("canEdit(project)")
	 */
	def canEdit(Project project) {
		println 'TODO AuthoriseServic.canEdit'
		
		return true
	}
}
