
<%@ page import="org.za.dali.ContactDetail" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'contactDetail.label', default: 'ContactDetail')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-contactDetail" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-contactDetail" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list contactDetail">
			
				<g:if test="${contactDetailInstance?.value}">
				<li class="fieldcontain">
					<span id="value-label" class="property-label"><g:message code="contactDetail.value.label" default="Value" /></span>
					
						<span class="property-value" aria-labelledby="value-label"><g:fieldValue bean="${contactDetailInstance}" field="value"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${contactDetailInstance?.costCentre}">
				<li class="fieldcontain">
					<span id="costCentre-label" class="property-label"><g:message code="contactDetail.costCentre.label" default="Cost Centre" /></span>
					
						<span class="property-value" aria-labelledby="costCentre-label"><g:link controller="costCentre" action="show" id="${contactDetailInstance?.costCentre?.id}">${contactDetailInstance?.costCentre?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${contactDetailInstance?.client}">
				<li class="fieldcontain">
					<span id="client-label" class="property-label"><g:message code="contactDetail.client.label" default="Client" /></span>
					
						<span class="property-value" aria-labelledby="client-label"><g:link controller="client" action="show" id="${contactDetailInstance?.client?.id}">${contactDetailInstance?.client?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${contactDetailInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="contactDetail.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${contactDetailInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${contactDetailInstance?.type}">
				<li class="fieldcontain">
					<span id="type-label" class="property-label"><g:message code="contactDetail.type.label" default="Type" /></span>
					
						<span class="property-value" aria-labelledby="type-label"><g:fieldValue bean="${contactDetailInstance}" field="type"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${contactDetailInstance?.id}" />
					<g:link class="edit" action="edit" id="${contactDetailInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
