package org.za.dali.search

class DomainSearch {
	Integer max = 10
	Integer offset = 0
	String sort = "dateCreated"
	String order = "asc"
  
	def searchCriteria = {
	  order(sort, order)
	}
}
