<%@ page import="org.za.dali.Contact" %>



<div class="fieldcontain ${hasErrors(bean: contactInstance, field: 'emailAddress', 'error')} ">
	<label for="emailAddress">
		<g:message code="contact.emailAddress.label" default="Email Address" />
		
	</label>
	<g:textField name="emailAddress" value="${contactInstance?.emailAddress}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: contactInstance, field: 'client', 'error')} ">
	<label for="client">
		<g:message code="contact.client.label" default="Client" />
		
	</label>
	<g:select id="client" name="client.id" from="${org.za.dali.Client.list()}" optionKey="id" value="${contactInstance?.client?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: contactInstance, field: 'firstName', 'error')} ">
	<label for="firstName">
		<g:message code="contact.firstName.label" default="First Name" />
		
	</label>
	<g:textField name="firstName" value="${contactInstance?.firstName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: contactInstance, field: 'lastName', 'error')} ">
	<label for="lastName">
		<g:message code="contact.lastName.label" default="Last Name" />
		
	</label>
	<g:textField name="lastName" value="${contactInstance?.lastName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: contactInstance, field: 'mobileNumber', 'error')} ">
	<label for="mobileNumber">
		<g:message code="contact.mobileNumber.label" default="Mobile Number" />
		
	</label>
	<g:textField name="mobileNumber" value="${contactInstance?.mobileNumber}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: contactInstance, field: 'phoneNumber', 'error')} ">
	<label for="phoneNumber">
		<g:message code="contact.phoneNumber.label" default="Phone Number" />
		
	</label>
	<g:textField name="phoneNumber" value="${contactInstance?.phoneNumber}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: contactInstance, field: 'role', 'error')} ">
	<label for="role">
		<g:message code="contact.role.label" default="Role" />
		
	</label>
	<g:select name="role" from="${org.za.dali.enums.ContactRole?.values()}" keys="${org.za.dali.enums.ContactRole.values()*.name()}" value="${contactInstance?.role?.name()}" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: contactInstance, field: 'user', 'error')} ">
	<label for="user">
		<g:message code="contact.user.label" default="User" />
		
	</label>
	<g:select id="user" name="user.id" from="${org.za.dali.User.list()}" optionKey="id" value="${contactInstance?.user?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

