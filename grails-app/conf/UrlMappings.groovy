import javassist.NotFoundException

import org.springframework.security.access.AccessDeniedException

class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/login/$action?"(controller: "login")
		"/logout/$action?"(controller: "logout")
		
		"/"(view:"/index")
	   "403"(controller: "errors", action: "error403")
	   "404"(controller: "errors", action: "error404")
	   "500"(controller: "errors", action: "error500")
	   "500"(controller: "errors", action: "error403", exception: AccessDeniedException)
	   "500"(controller: "errors", action: "error403", exception: NotFoundException)
	}
}
