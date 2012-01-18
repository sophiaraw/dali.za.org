package org.za.dali

import org.za.dali.search.ProjectSearch

class SearchService {

	boolean transactional = false
	
	public List<Project> getProjects(ProjectSearch ps) {
		def projectCriteria = Project.createCriteria()
		
		Closure searchCriteria = ps.searchCriteria
		searchCriteria.delegate = projectCriteria //set searchCriteria builder to projectCriteria builder
		
		return projectCriteria.list([max: ps.max, offset: ps.offset]) {
		  searchCriteria()
		}
	}
}

