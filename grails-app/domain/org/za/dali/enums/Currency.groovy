package org.za.dali.enums

enum Currency {
	RAND('ZAR'),
	POUND('GBP')
	
	String id
 
   Currency(String id) {
     this.id = id
   }
   
   String getId() {
	   id
   }
}
