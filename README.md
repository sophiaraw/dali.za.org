Dali Notes
==========

User getTrafficManager() {
		if(!trafficManager) {
			trafficManager = contacts.find { it.role.is(ContactRole.TRAFFIC_MANAGER) }
		}
		
		return trafficManager
	}
	
SETUP:
--> each team needs a default service line for New Business, sub service line of Quoting - this line can not be edited	
	
TO SOLVE:
--> budget transfers, tasks should have a task bill that is connected to the origin project invoice	
	
IMPORT:
--> serviceLines + ACCPAC service codes


REQUEST:
--> (Rachel) Accpac vat category dropdown list


CRON:
--> Send ALERTs when retainer is about to close

COPY REQUIRED
--> Preference descriptions