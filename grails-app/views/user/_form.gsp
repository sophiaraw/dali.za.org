<%@ page import="org.za.dali.User" %>



<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'costCentre', 'error')} required">
	<label for="costCentre">
		<g:message code="user.costCentre.label" default="Cost Centre" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="costCentre" name="costCentre.id" from="${org.za.dali.CostCentre.list()}" optionKey="id" required="" value="${userInstance?.costCentre?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'username', 'error')} ">
	<label for="username">
		<g:message code="user.username.label" default="Username" />
		
	</label>
	<g:field type="email" name="username" value="${userInstance?.username}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'password', 'error')} ">
	<label for="password">
		<g:message code="user.password.label" default="Password" />
		
	</label>
	<g:textField name="password" value="${userInstance?.password}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'account', 'error')} ">
	<label for="account">
		<g:message code="user.account.label" default="Account" />
		
	</label>
	<g:select id="account" name="account.id" from="${org.za.dali.Account.list()}" optionKey="id" value="${userInstance?.account?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'accountExpired', 'error')} ">
	<label for="accountExpired">
		<g:message code="user.accountExpired.label" default="Account Expired" />
		
	</label>
	<g:checkBox name="accountExpired" value="${userInstance?.accountExpired}" />
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'accountLocked', 'error')} ">
	<label for="accountLocked">
		<g:message code="user.accountLocked.label" default="Account Locked" />
		
	</label>
	<g:checkBox name="accountLocked" value="${userInstance?.accountLocked}" />
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'auditLogReason', 'error')} ">
	<label for="auditLogReason">
		<g:message code="user.auditLogReason.label" default="Audit Log Reason" />
		
	</label>
	<g:textField name="auditLogReason" value="${userInstance?.auditLogReason}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'contactDetails', 'error')} ">
	<label for="contactDetails">
		<g:message code="user.contactDetails.label" default="Contact Details" />
		
	</label>
	<g:select name="contactDetails" from="${org.za.dali.ContactDetail.list()}" multiple="multiple" optionKey="id" size="5" value="${userInstance?.contactDetails*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'contacts', 'error')} ">
	<label for="contacts">
		<g:message code="user.contacts.label" default="Contacts" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${userInstance?.contacts?}" var="c">
    <li><g:link controller="userContact" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="userContact" action="create" params="['user.id': userInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'userContact.label', default: 'UserContact')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'contractEndDate', 'error')} ">
	<label for="contractEndDate">
		<g:message code="user.contractEndDate.label" default="Contract End Date" />
		
	</label>
	<g:datePicker name="contractEndDate" precision="day"  value="${userInstance?.contractEndDate}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'contractStartDate', 'error')} ">
	<label for="contractStartDate">
		<g:message code="user.contractStartDate.label" default="Contract Start Date" />
		
	</label>
	<g:datePicker name="contractStartDate" precision="day"  value="${userInstance?.contractStartDate}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'dob', 'error')} ">
	<label for="dob">
		<g:message code="user.dob.label" default="Dob" />
		
	</label>
	<g:datePicker name="dob" precision="day"  value="${userInstance?.dob}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'firstName', 'error')} ">
	<label for="firstName">
		<g:message code="user.firstName.label" default="First Name" />
		
	</label>
	<g:textField name="firstName" value="${userInstance?.firstName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'hoursPerDay', 'error')} ">
	<label for="hoursPerDay">
		<g:message code="user.hoursPerDay.label" default="Hours Per Day" />
		
	</label>
	<g:field type="number" name="hoursPerDay" value="${fieldValue(bean: userInstance, field: 'hoursPerDay')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'idNumber', 'error')} ">
	<label for="idNumber">
		<g:message code="user.idNumber.label" default="Id Number" />
		
	</label>
	<g:textField name="idNumber" value="${userInstance?.idNumber}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'lastName', 'error')} ">
	<label for="lastName">
		<g:message code="user.lastName.label" default="Last Name" />
		
	</label>
	<g:textField name="lastName" value="${userInstance?.lastName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'logins', 'error')} ">
	<label for="logins">
		<g:message code="user.logins.label" default="Logins" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${userInstance?.logins?}" var="l">
    <li><g:link controller="login" action="show" id="${l.id}">${l?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="login" action="create" params="['user.id': userInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'login.label', default: 'Login')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'martitalStatus', 'error')} ">
	<label for="martitalStatus">
		<g:message code="user.martitalStatus.label" default="Martital Status" />
		
	</label>
	<g:select name="martitalStatus" from="${org.za.dali.enums.MaritalStatus?.values()}" keys="${org.za.dali.enums.MaritalStatus.values()*.name()}" value="${userInstance?.martitalStatus?.name()}" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'otherNames', 'error')} ">
	<label for="otherNames">
		<g:message code="user.otherNames.label" default="Other Names" />
		
	</label>
	<g:textField name="otherNames" value="${userInstance?.otherNames}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'passportNumber', 'error')} ">
	<label for="passportNumber">
		<g:message code="user.passportNumber.label" default="Passport Number" />
		
	</label>
	<g:textField name="passportNumber" value="${userInstance?.passportNumber}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'passwordExpired', 'error')} ">
	<label for="passwordExpired">
		<g:message code="user.passwordExpired.label" default="Password Expired" />
		
	</label>
	<g:checkBox name="passwordExpired" value="${userInstance?.passwordExpired}" />
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'preferredName', 'error')} ">
	<label for="preferredName">
		<g:message code="user.preferredName.label" default="Preferred Name" />
		
	</label>
	<g:textField name="preferredName" value="${userInstance?.preferredName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'rateCards', 'error')} ">
	<label for="rateCards">
		<g:message code="user.rateCards.label" default="Rate Cards" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${userInstance?.rateCards?}" var="r">
    <li><g:link controller="rateCard" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="rateCard" action="create" params="['user.id': userInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'rateCard.label', default: 'RateCard')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'residency', 'error')} ">
	<label for="residency">
		<g:message code="user.residency.label" default="Residency" />
		
	</label>
	<g:textField name="residency" value="${userInstance?.residency}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'revenueOffice', 'error')} ">
	<label for="revenueOffice">
		<g:message code="user.revenueOffice.label" default="Revenue Office" />
		
	</label>
	<g:textField name="revenueOffice" value="${userInstance?.revenueOffice}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'roles', 'error')} ">
	<label for="roles">
		<g:message code="user.roles.label" default="Roles" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${userInstance?.roles?}" var="r">
    <li><g:link controller="userRole" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="userRole" action="create" params="['user.id': userInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'userRole.label', default: 'UserRole')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'status', 'error')} ">
	<label for="status">
		<g:message code="user.status.label" default="Status" />
		
	</label>
	<g:select name="status" from="${org.za.dali.enums.UserStatus?.values()}" keys="${org.za.dali.enums.UserStatus.values()*.name()}" value="${userInstance?.status?.name()}" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'taxNumber', 'error')} ">
	<label for="taxNumber">
		<g:message code="user.taxNumber.label" default="Tax Number" />
		
	</label>
	<g:textField name="taxNumber" value="${userInstance?.taxNumber}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'teams', 'error')} ">
	<label for="teams">
		<g:message code="user.teams.label" default="Teams" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${userInstance?.teams?}" var="t">
    <li><g:link controller="userTeam" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="userTeam" action="create" params="['user.id': userInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'userTeam.label', default: 'UserTeam')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'title', 'error')} ">
	<label for="title">
		<g:message code="user.title.label" default="Title" />
		
	</label>
	<g:textField name="title" value="${userInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'type', 'error')} ">
	<label for="type">
		<g:message code="user.type.label" default="Type" />
		
	</label>
	<g:select name="type" from="${org.za.dali.enums.UserType?.values()}" keys="${org.za.dali.enums.UserType.values()*.name()}" value="${userInstance?.type?.name()}" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'userNumber', 'error')} ">
	<label for="userNumber">
		<g:message code="user.userNumber.label" default="User Number" />
		
	</label>
	<g:textField name="userNumber" value="${userInstance?.userNumber}"/>
</div>

