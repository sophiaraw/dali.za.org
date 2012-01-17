package org.za.dali

import javax.servlet.http.HttpSession

import org.springframework.web.context.request.RequestContextHolder

class UserService {

	static final String SESSION_USER_ID = 'userId'
	
    def getLoggedInUser() {
		if(!getSession().SESSION_USER_ID)
		{
			return User.get(getSession().SESSION_USER_ID)
		}
		
		return null 
    }
	
	private HttpSession getSession() {
		return RequestContextHolder.currentRequestAttributes().getSession()
	}
}
