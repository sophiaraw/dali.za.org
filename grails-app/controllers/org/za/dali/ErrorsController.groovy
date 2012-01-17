package org.za.dali


class ErrorsController {

    def index() { }
	
	def error403 = {}
	def error404 = {}
	def error500 = {
	   render view: '/error'
	}
}
