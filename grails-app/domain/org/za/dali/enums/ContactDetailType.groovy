package org.za.dali.enums

enum ContactDetailType {
	//Max length of id 8
	PHYSICAL_ADDRESS('PHY_ADDR','Physical address'),
	POSTAL_ADDRESS('POS_ADDR','Postal address'),
	PHONE_NUMBER('PH','Phone number'),
	PHONE_NUMBER_ALT('PH_ALT','Phone number (Alternative)'),
	MOBILE_NUMBER('MOBILE','Mobile number'),
	FAX_NUMBER('FAX','Fax Number'),
	EMAIL('EMAIL','Email'),
	WEBSITE('WEB','Website'),
	SOCIAL_NETWORKS('SOCIAL','Social networks')

	String id
	String name

	ContactDetailType(String id, String name) {
		this.id = id
		this.name = name
	}
	
	String toString(){
		name
	}
}
