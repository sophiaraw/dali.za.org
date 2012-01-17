import java.util.Date;

@artifact.package@class @artifact.name@ {

	static belongsTo = []
	
	Date dateCreated
	
    static hasMany = []
	
	static constraints = {
//		emailAddress(email: true, blank: false)
	}

	def beforeValidate() {
//		name = name?.trim()
	}
	
	static mapping = {
//		sort(name: "asc")
//		childCollection(sort: 'number', order: 'desc')
//		enumName(type: IdentityEnumType,sqlType: "varchar(3)")

	}
	
	static embedded = ['somePOGO']
}
