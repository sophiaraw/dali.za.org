
import org.za.dali.Client
import org.za.dali.Company
import org.za.dali.Project
import org.za.dali.ServiceLine
import org.za.dali.Team
import org.za.dali.TeamLevel
import org.za.dali.TeamRole
import org.za.dali.User
import org.za.dali.UserRole
import org.za.dali.enums.AccountingSoftware
import org.za.dali.enums.ClientStatus
import org.za.dali.enums.Currency
import org.za.dali.enums.RoleType
import org.za.dali.enums.UserStatus

class BootStrap {
	User userA
	User userB
	User userC
    def init = { servletContext ->

		createCompany()
//		
//		println cc
//		
//		Contact contact = new Contact(firstName:'Sophia',lastName:'Raw',emailAddress:'soph@quirk.biz')
//		contact.save(flush:true)
//		def emailValidator = EmailValidator.getInstance()
//		
//		println contact.validate()
    }
	
	private void createCompany() {
		Company cc = new Company()
		cc.setTitle("Quirk Cape Town")
		cc.setRegisteredName("Quirk Cape Town PTY")
		cc.setCurrency( Currency.RAND )
		cc.setAccSoftware(AccountingSoftware.ACCPAC)
		cc.vatPercentage = 14
		cc.invoiceDay = 1
		cc.setPrefix("CTN")
		
		cc.save()

		createTeam(cc)
		createClient(cc)
	}
	
	private void createTeam(Company cc) {
		Team team = new Team(costCentre:cc)
		team.title = 'Engineering'
		
		createTeamLeader(team)
		createServiceLine(team)
		createLevel(team)
		createRoles(team)
		createUsers(team)
		
		team.save()
	}
	
	private void createTeamLeader(Team team) {
		User user = new User(username:'tm@tm.com',
							 password:'tm',
							 status:UserStatus.ACTIVE,
							 team:team)
		
		user.save()
		team.setLeader(user)
	}
	
	private void createUsers(Team team) {
		userA = new User(username:'aa@aa.com',
							 password:'aa',
							 status:UserStatus.ACTIVE,
							 team:team)
		UserRole.create(userA, RoleType.QUOTE_EDIT.id)
		 
		userA.save()
		
		userB = new User(username:'bb@bb.com',
			password:'bb',
			status:UserStatus.ACTIVE,
			team:team)

		userB.save()
		
		userC = new User(username:'cc@cc.com',
			password:'cc',
			status:UserStatus.ACTIVE,
			team:team)
		
		userC.save()
	}
	
	private void createServiceLine(Team team) {
		ServiceLine serviceLine = new ServiceLine(title:'Java Development',
												  description:'Everything java related',
												  active:true)
		team.addToServiceLines(serviceLine)
		
	}
	
	private void createLevel(Team team) {
		TeamLevel level = new TeamLevel(title:'Senior',
									    description:'The leaders in the team',
								        active:true)
		team.addToLevels(level)
	}
	
	private void createRoles(Team team) {
		TeamRole teamRole = new TeamRole(role:RoleType.TRAFFIC_MANAGER)
		team.addToRoles(teamRole)
	}
	
	private void createClient(Company cc) {
		Client client = new Client(costCentre:cc,
								   name:'Distell',
								   status:ClientStatus.ACTIVE,
								   clientCode:'DIST01AA',
								   accountingCode:'ACC-DIST01AA',
								   prefix:'DIST01AA',
								   regNumber:'reg-number',
								   vatNumber:'vat-number',
								   taxable:true)

		createProjects(client)

		client.save(flush:true,failOnError:true)		
	}
	
	private void createProjects(Client client) {
		Project pa = new Project(client:client,
			                     jobNumber:'job-number-pa',
								 title:'New website',
								 trafficManager:userA,
								 projectOwner:userB)
//		pa.save(failOnError:true)
		client.addToProjects(pa)
	}
	
    def destroy = {
    }
}
