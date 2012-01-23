
<%@ page import="org.za.dali.User" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-user" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list user">
			
				<g:if test="${userInstance?.costCentre}">
				<li class="fieldcontain">
					<span id="costCentre-label" class="property-label"><g:message code="user.costCentre.label" default="Cost Centre" /></span>
					
						<span class="property-value" aria-labelledby="costCentre-label"><g:link controller="costCentre" action="show" id="${userInstance?.costCentre?.id}">${userInstance?.costCentre?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.username}">
				<li class="fieldcontain">
					<span id="username-label" class="property-label"><g:message code="user.username.label" default="Username" /></span>
					
						<span class="property-value" aria-labelledby="username-label"><g:fieldValue bean="${userInstance}" field="username"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.password}">
				<li class="fieldcontain">
					<span id="password-label" class="property-label"><g:message code="user.password.label" default="Password" /></span>
					
						<span class="property-value" aria-labelledby="password-label"><g:fieldValue bean="${userInstance}" field="password"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.account}">
				<li class="fieldcontain">
					<span id="account-label" class="property-label"><g:message code="user.account.label" default="Account" /></span>
					
						<span class="property-value" aria-labelledby="account-label"><g:link controller="account" action="show" id="${userInstance?.account?.id}">${userInstance?.account?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.accountExpired}">
				<li class="fieldcontain">
					<span id="accountExpired-label" class="property-label"><g:message code="user.accountExpired.label" default="Account Expired" /></span>
					
						<span class="property-value" aria-labelledby="accountExpired-label"><g:formatBoolean boolean="${userInstance?.accountExpired}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.accountLocked}">
				<li class="fieldcontain">
					<span id="accountLocked-label" class="property-label"><g:message code="user.accountLocked.label" default="Account Locked" /></span>
					
						<span class="property-value" aria-labelledby="accountLocked-label"><g:formatBoolean boolean="${userInstance?.accountLocked}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.auditLogReason}">
				<li class="fieldcontain">
					<span id="auditLogReason-label" class="property-label"><g:message code="user.auditLogReason.label" default="Audit Log Reason" /></span>
					
						<span class="property-value" aria-labelledby="auditLogReason-label"><g:fieldValue bean="${userInstance}" field="auditLogReason"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.contactDetails}">
				<li class="fieldcontain">
					<span id="contactDetails-label" class="property-label"><g:message code="user.contactDetails.label" default="Contact Details" /></span>
					
						<g:each in="${userInstance.contactDetails}" var="c">
						<span class="property-value" aria-labelledby="contactDetails-label"><g:link controller="contactDetail" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.contacts}">
				<li class="fieldcontain">
					<span id="contacts-label" class="property-label"><g:message code="user.contacts.label" default="Contacts" /></span>
					
						<g:each in="${userInstance.contacts}" var="c">
						<span class="property-value" aria-labelledby="contacts-label"><g:link controller="userContact" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.contractEndDate}">
				<li class="fieldcontain">
					<span id="contractEndDate-label" class="property-label"><g:message code="user.contractEndDate.label" default="Contract End Date" /></span>
					
						<span class="property-value" aria-labelledby="contractEndDate-label"><g:formatDate date="${userInstance?.contractEndDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.contractStartDate}">
				<li class="fieldcontain">
					<span id="contractStartDate-label" class="property-label"><g:message code="user.contractStartDate.label" default="Contract Start Date" /></span>
					
						<span class="property-value" aria-labelledby="contractStartDate-label"><g:formatDate date="${userInstance?.contractStartDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.dob}">
				<li class="fieldcontain">
					<span id="dob-label" class="property-label"><g:message code="user.dob.label" default="Dob" /></span>
					
						<span class="property-value" aria-labelledby="dob-label"><g:formatDate date="${userInstance?.dob}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.firstName}">
				<li class="fieldcontain">
					<span id="firstName-label" class="property-label"><g:message code="user.firstName.label" default="First Name" /></span>
					
						<span class="property-value" aria-labelledby="firstName-label"><g:fieldValue bean="${userInstance}" field="firstName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.hoursPerDay}">
				<li class="fieldcontain">
					<span id="hoursPerDay-label" class="property-label"><g:message code="user.hoursPerDay.label" default="Hours Per Day" /></span>
					
						<span class="property-value" aria-labelledby="hoursPerDay-label"><g:fieldValue bean="${userInstance}" field="hoursPerDay"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.idNumber}">
				<li class="fieldcontain">
					<span id="idNumber-label" class="property-label"><g:message code="user.idNumber.label" default="Id Number" /></span>
					
						<span class="property-value" aria-labelledby="idNumber-label"><g:fieldValue bean="${userInstance}" field="idNumber"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.lastName}">
				<li class="fieldcontain">
					<span id="lastName-label" class="property-label"><g:message code="user.lastName.label" default="Last Name" /></span>
					
						<span class="property-value" aria-labelledby="lastName-label"><g:fieldValue bean="${userInstance}" field="lastName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.logins}">
				<li class="fieldcontain">
					<span id="logins-label" class="property-label"><g:message code="user.logins.label" default="Logins" /></span>
					
						<g:each in="${userInstance.logins}" var="l">
						<span class="property-value" aria-labelledby="logins-label"><g:link controller="login" action="show" id="${l.id}">${l?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.martitalStatus}">
				<li class="fieldcontain">
					<span id="martitalStatus-label" class="property-label"><g:message code="user.martitalStatus.label" default="Martital Status" /></span>
					
						<span class="property-value" aria-labelledby="martitalStatus-label"><g:fieldValue bean="${userInstance}" field="martitalStatus"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.otherNames}">
				<li class="fieldcontain">
					<span id="otherNames-label" class="property-label"><g:message code="user.otherNames.label" default="Other Names" /></span>
					
						<span class="property-value" aria-labelledby="otherNames-label"><g:fieldValue bean="${userInstance}" field="otherNames"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.passportNumber}">
				<li class="fieldcontain">
					<span id="passportNumber-label" class="property-label"><g:message code="user.passportNumber.label" default="Passport Number" /></span>
					
						<span class="property-value" aria-labelledby="passportNumber-label"><g:fieldValue bean="${userInstance}" field="passportNumber"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.passwordExpired}">
				<li class="fieldcontain">
					<span id="passwordExpired-label" class="property-label"><g:message code="user.passwordExpired.label" default="Password Expired" /></span>
					
						<span class="property-value" aria-labelledby="passwordExpired-label"><g:formatBoolean boolean="${userInstance?.passwordExpired}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.preferredName}">
				<li class="fieldcontain">
					<span id="preferredName-label" class="property-label"><g:message code="user.preferredName.label" default="Preferred Name" /></span>
					
						<span class="property-value" aria-labelledby="preferredName-label"><g:fieldValue bean="${userInstance}" field="preferredName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.rateCards}">
				<li class="fieldcontain">
					<span id="rateCards-label" class="property-label"><g:message code="user.rateCards.label" default="Rate Cards" /></span>
					
						<g:each in="${userInstance.rateCards}" var="r">
						<span class="property-value" aria-labelledby="rateCards-label"><g:link controller="rateCard" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.residency}">
				<li class="fieldcontain">
					<span id="residency-label" class="property-label"><g:message code="user.residency.label" default="Residency" /></span>
					
						<span class="property-value" aria-labelledby="residency-label"><g:fieldValue bean="${userInstance}" field="residency"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.revenueOffice}">
				<li class="fieldcontain">
					<span id="revenueOffice-label" class="property-label"><g:message code="user.revenueOffice.label" default="Revenue Office" /></span>
					
						<span class="property-value" aria-labelledby="revenueOffice-label"><g:fieldValue bean="${userInstance}" field="revenueOffice"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.roles}">
				<li class="fieldcontain">
					<span id="roles-label" class="property-label"><g:message code="user.roles.label" default="Roles" /></span>
					
						<g:each in="${userInstance.roles}" var="r">
						<span class="property-value" aria-labelledby="roles-label"><g:link controller="userRole" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.status}">
				<li class="fieldcontain">
					<span id="status-label" class="property-label"><g:message code="user.status.label" default="Status" /></span>
					
						<span class="property-value" aria-labelledby="status-label"><g:fieldValue bean="${userInstance}" field="status"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.taxNumber}">
				<li class="fieldcontain">
					<span id="taxNumber-label" class="property-label"><g:message code="user.taxNumber.label" default="Tax Number" /></span>
					
						<span class="property-value" aria-labelledby="taxNumber-label"><g:fieldValue bean="${userInstance}" field="taxNumber"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.teams}">
				<li class="fieldcontain">
					<span id="teams-label" class="property-label"><g:message code="user.teams.label" default="Teams" /></span>
					
						<g:each in="${userInstance.teams}" var="t">
						<span class="property-value" aria-labelledby="teams-label"><g:link controller="userTeam" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.title}">
				<li class="fieldcontain">
					<span id="title-label" class="property-label"><g:message code="user.title.label" default="Title" /></span>
					
						<span class="property-value" aria-labelledby="title-label"><g:fieldValue bean="${userInstance}" field="title"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.type}">
				<li class="fieldcontain">
					<span id="type-label" class="property-label"><g:message code="user.type.label" default="Type" /></span>
					
						<span class="property-value" aria-labelledby="type-label"><g:fieldValue bean="${userInstance}" field="type"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.userNumber}">
				<li class="fieldcontain">
					<span id="userNumber-label" class="property-label"><g:message code="user.userNumber.label" default="User Number" /></span>
					
						<span class="property-value" aria-labelledby="userNumber-label"><g:fieldValue bean="${userInstance}" field="userNumber"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${userInstance?.id}" />
					<g:link class="edit" action="edit" id="${userInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
