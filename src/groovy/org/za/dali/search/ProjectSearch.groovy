package org.za.dali.search

import org.za.dali.enums.OperatorType
import org.za.dali.enums.ProjectStatus
import org.za.dali.enums.ProjectType

class ProjectSearch extends DomainSearch {
	Long clientId
	Long projectId
	ProjectType type
	ProjectStatus status
	String jobNumber
	String PONumber
	String title
	Boolean retainer = null
	OperatorType operatorType
	Long budget
	
	def searchCriteria = {
		if(clientId) {
			client {
				eq('id', Long.parseLong(clientId))
			  }
		}
		
		if(projectId) {
			project {
				eq('id', Long.parseLong(projectId))
			  }
		}
		
		if(type) {
			eqProperty("type",type)
		}
		
		if(status) {
			eqProperty("status",status)
		}
		
		if(jobNumber) {
			ilike("jobNumber",jobNumber)
		}
		
		if(PONumber) {
			ilike("PONumber",PONumber)
		}
		
		if(title) {
			ilike("title",title)
		}
		
		if(retainer) {
			eq("retainer",retainer)
		}
		
//		if(budget && budget > 0) {
//			
//			if( operatorType.is(OperatorType.GREATER_THAN)) {
//				gt("budget",budget)
//			}
//		}

		super.searchCriteria
	 }
}
