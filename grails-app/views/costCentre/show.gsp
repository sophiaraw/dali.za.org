
<%@ page import="org.za.dali.CostCentre" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'costCentre.label', default: 'CostCentre')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-costCentre" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-costCentre" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list costCentre">
			
				<g:if test="${costCentreInstance?.parent}">
				<li class="fieldcontain">
					<span id="parent-label" class="property-label"><g:message code="costCentre.parent.label" default="Parent" /></span>
					
						<span class="property-value" aria-labelledby="parent-label"><g:link controller="costCentre" action="show" id="${costCentreInstance?.parent?.id}">${costCentreInstance?.parent?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${costCentreInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="costCentre.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${costCentreInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${costCentreInstance?.registeredName}">
				<li class="fieldcontain">
					<span id="registeredName-label" class="property-label"><g:message code="costCentre.registeredName.label" default="Registered Name" /></span>
					
						<span class="property-value" aria-labelledby="registeredName-label"><g:fieldValue bean="${costCentreInstance}" field="registeredName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${costCentreInstance?.prefix}">
				<li class="fieldcontain">
					<span id="prefix-label" class="property-label"><g:message code="costCentre.prefix.label" default="Prefix" /></span>
					
						<span class="property-value" aria-labelledby="prefix-label"><g:fieldValue bean="${costCentreInstance}" field="prefix"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${costCentreInstance?.vatPercentage}">
				<li class="fieldcontain">
					<span id="vatPercentage-label" class="property-label"><g:message code="costCentre.vatPercentage.label" default="Vat Percentage" /></span>
					
						<span class="property-value" aria-labelledby="vatPercentage-label"><g:fieldValue bean="${costCentreInstance}" field="vatPercentage"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${costCentreInstance?.invoiceDay}">
				<li class="fieldcontain">
					<span id="invoiceDay-label" class="property-label"><g:message code="costCentre.invoiceDay.label" default="Invoice Day" /></span>
					
						<span class="property-value" aria-labelledby="invoiceDay-label"><g:fieldValue bean="${costCentreInstance}" field="invoiceDay"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${costCentreInstance?.accSoftware}">
				<li class="fieldcontain">
					<span id="accSoftware-label" class="property-label"><g:message code="costCentre.accSoftware.label" default="Acc Software" /></span>
					
						<span class="property-value" aria-labelledby="accSoftware-label"><g:fieldValue bean="${costCentreInstance}" field="accSoftware"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${costCentreInstance?.clients}">
				<li class="fieldcontain">
					<span id="clients-label" class="property-label"><g:message code="costCentre.clients.label" default="Clients" /></span>
					
						<g:each in="${costCentreInstance.clients}" var="c">
						<span class="property-value" aria-labelledby="clients-label"><g:link controller="client" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${costCentreInstance?.contactDetails}">
				<li class="fieldcontain">
					<span id="contactDetails-label" class="property-label"><g:message code="costCentre.contactDetails.label" default="Contact Details" /></span>
					
						<g:each in="${costCentreInstance.contactDetails}" var="c">
						<span class="property-value" aria-labelledby="contactDetails-label"><g:link controller="contactDetail" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${costCentreInstance?.currency}">
				<li class="fieldcontain">
					<span id="currency-label" class="property-label"><g:message code="costCentre.currency.label" default="Currency" /></span>
					
						<span class="property-value" aria-labelledby="currency-label"><g:fieldValue bean="${costCentreInstance}" field="currency"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${costCentreInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="costCentre.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:dateMedium date="${costCentreInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${costCentreInstance?.geoLocation}">
				<li class="fieldcontain">
					<span id="geoLocation-label" class="property-label"><g:message code="costCentre.geoLocation.label" default="Geo Location" /></span>
					
						<span class="property-value" aria-labelledby="geoLocation-label"><g:fieldValue bean="${costCentreInstance}" field="geoLocation"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${costCentreInstance?.id}" />
					<g:link class="edit" action="edit" id="${costCentreInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
