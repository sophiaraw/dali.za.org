import org.za.dali.CostCentre
import org.za.dali.User
import org.za.dali.enums.AccountingSoftware
import org.za.dali.enums.Currency
import org.za.dali.enums.UserStatus


class BootStrap {

    def init = { servletContext ->
//		println Currency.values()
//		Currency.each{println "1: $it"}
//		Currency.each{println "2: ${it.name()}"}
//		Currency.values().each{println "4: $it"}
//		println "5: ${Currency.RAND.name()}"
//		println "6: ${Currency.RAND}"
		
		CostCentre cc = new CostCentre()
		cc.setName("Quirk Cape Town")
		cc.setRegisteredName("Quirk Cape Town PTY")
		cc.setCurrency( Currency.RAND )
		cc.setAccSoftware(AccountingSoftware.ACCPAC)
		cc.vatPercentage = 14
		cc.invoiceDay = 1
		cc.setPrefix("CTN")
		
		cc.save(flush:true)
		
		createUsers()
//		
//		println cc
//		
//		Contact contact = new Contact(firstName:'Sophia',lastName:'Raw',emailAddress:'soph@quirk.biz')
//		contact.save(flush:true)
//		def emailValidator = EmailValidator.getInstance()
//		
//		println contact.validate()
    }
	
	private void createUsers() {
		User user = new User(username:'aa@aa.com',
							 password:'aa',
							 status:UserStatus.ACTIVE)
		
		user.save(flush:true)
	 }
	
    def destroy = {
    }
}
