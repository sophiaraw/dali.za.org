package org.za.dali

class ProjectService {

    Boolean isValid(Project project) {
		project.validate()
		println 'TODO remove errors printout'
		if(project.errors)
		{
			project.errors.allErrors.each {
				println it.defaultMessage
			}
		}
    }
	
	Boolean save(Project project, Map params) {
		if (params.version) {
			def version = params.version.toLong()
			if (project.version > version) {
				project.errors.rejectValue("version", "default.optimistic.locking.failure",
						  [message(code: 'project.label', default: 'Project')] as Object[],
						  "Another user has updated this Project while you were editing")
				
				return false
			}
		}

		project.properties = params

		if(isValid(project) && project.save(flush: true)) {
			flash.message = message(code: 'default.updated.message', args: [message(code: 'project.label', default: 'Project'), projectInstance.id])
			
			return true
		}
		
		return false
	}
}


//holidayQueryCommand.errors.rejectValue("property","message.code","default error message");