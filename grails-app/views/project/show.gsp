
<%@ page import="org.za.dali.Project" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'project.label', default: 'Project')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-project" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-project" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list project">
			
				<g:if test="${projectInstance?.type}">
				<li class="fieldcontain">
					<span id="type-label" class="property-label"><g:message code="project.type.label" default="Type" /></span>
					
						<span class="property-value" aria-labelledby="type-label"><g:fieldValue bean="${projectInstance}" field="type"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.status}">
				<li class="fieldcontain">
					<span id="status-label" class="property-label"><g:message code="project.status.label" default="Status" /></span>
					
						<span class="property-value" aria-labelledby="status-label"><g:fieldValue bean="${projectInstance}" field="status"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.trafficManager}">
				<li class="fieldcontain">
					<span id="trafficManager-label" class="property-label"><g:message code="project.trafficManager.label" default="Traffic Manager" /></span>
					
						<span class="property-value" aria-labelledby="trafficManager-label"><g:link controller="user" action="show" id="${projectInstance?.trafficManager?.id}">${projectInstance?.trafficManager?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.projectOwner}">
				<li class="fieldcontain">
					<span id="projectOwner-label" class="property-label"><g:message code="project.projectOwner.label" default="Project Owner" /></span>
					
						<span class="property-value" aria-labelledby="projectOwner-label"><g:link controller="user" action="show" id="${projectInstance?.projectOwner?.id}">${projectInstance?.projectOwner?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.PONumber}">
				<li class="fieldcontain">
					<span id="PONumber-label" class="property-label"><g:message code="project.PONumber.label" default="PON umber" /></span>
					
						<span class="property-value" aria-labelledby="PONumber-label"><g:fieldValue bean="${projectInstance}" field="PONumber"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.actualDeliveryDate}">
				<li class="fieldcontain">
					<span id="actualDeliveryDate-label" class="property-label"><g:message code="project.actualDeliveryDate.label" default="Actual Delivery Date" /></span>
					
						<span class="property-value" aria-labelledby="actualDeliveryDate-label"><g:formatDate date="${projectInstance?.actualDeliveryDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.auditLogReason}">
				<li class="fieldcontain">
					<span id="auditLogReason-label" class="property-label"><g:message code="project.auditLogReason.label" default="Audit Log Reason" /></span>
					
						<span class="property-value" aria-labelledby="auditLogReason-label"><g:fieldValue bean="${projectInstance}" field="auditLogReason"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.budgetAdjustments}">
				<li class="fieldcontain">
					<span id="budgetAdjustments-label" class="property-label"><g:message code="project.budgetAdjustments.label" default="Budget Adjustments" /></span>
					
						<g:each in="${projectInstance.budgetAdjustments}" var="b">
						<span class="property-value" aria-labelledby="budgetAdjustments-label"><g:link controller="budgetAdjustment" action="show" id="${b.id}">${b?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.client}">
				<li class="fieldcontain">
					<span id="client-label" class="property-label"><g:message code="project.client.label" default="Client" /></span>
					
						<span class="property-value" aria-labelledby="client-label"><g:link controller="client" action="show" id="${projectInstance?.client?.id}">${projectInstance?.client?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.contacts}">
				<li class="fieldcontain">
					<span id="contacts-label" class="property-label"><g:message code="project.contacts.label" default="Contacts" /></span>
					
						<g:each in="${projectInstance.contacts}" var="c">
						<span class="property-value" aria-labelledby="contacts-label"><g:link controller="contact" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.createdBy}">
				<li class="fieldcontain">
					<span id="createdBy-label" class="property-label"><g:message code="project.createdBy.label" default="Created By" /></span>
					
						<span class="property-value" aria-labelledby="createdBy-label"><g:link controller="user" action="show" id="${projectInstance?.createdBy?.id}">${projectInstance?.createdBy?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="project.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${projectInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="project.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${projectInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.emailAlias}">
				<li class="fieldcontain">
					<span id="emailAlias-label" class="property-label"><g:message code="project.emailAlias.label" default="Email Alias" /></span>
					
						<span class="property-value" aria-labelledby="emailAlias-label"><g:fieldValue bean="${projectInstance}" field="emailAlias"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.expiresOn}">
				<li class="fieldcontain">
					<span id="expiresOn-label" class="property-label"><g:message code="project.expiresOn.label" default="Expires On" /></span>
					
						<span class="property-value" aria-labelledby="expiresOn-label"><g:formatDate date="${projectInstance?.expiresOn}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.jobNumber}">
				<li class="fieldcontain">
					<span id="jobNumber-label" class="property-label"><g:message code="project.jobNumber.label" default="Job Number" /></span>
					
						<span class="property-value" aria-labelledby="jobNumber-label"><g:fieldValue bean="${projectInstance}" field="jobNumber"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.opportunity}">
				<li class="fieldcontain">
					<span id="opportunity-label" class="property-label"><g:message code="project.opportunity.label" default="Opportunity" /></span>
					
						<span class="property-value" aria-labelledby="opportunity-label"><g:fieldValue bean="${projectInstance}" field="opportunity"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.parent}">
				<li class="fieldcontain">
					<span id="parent-label" class="property-label"><g:message code="project.parent.label" default="Parent" /></span>
					
						<span class="property-value" aria-labelledby="parent-label"><g:link controller="project" action="show" id="${projectInstance?.parent?.id}">${projectInstance?.parent?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.rateCards}">
				<li class="fieldcontain">
					<span id="rateCards-label" class="property-label"><g:message code="project.rateCards.label" default="Rate Cards" /></span>
					
						<g:each in="${projectInstance.rateCards}" var="r">
						<span class="property-value" aria-labelledby="rateCards-label"><g:link controller="rateCard" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.requestedDeliveryDate}">
				<li class="fieldcontain">
					<span id="requestedDeliveryDate-label" class="property-label"><g:message code="project.requestedDeliveryDate.label" default="Requested Delivery Date" /></span>
					
						<span class="property-value" aria-labelledby="requestedDeliveryDate-label"><g:formatDate date="${projectInstance?.requestedDeliveryDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.retainer}">
				<li class="fieldcontain">
					<span id="retainer-label" class="property-label"><g:message code="project.retainer.label" default="Retainer" /></span>
					
						<span class="property-value" aria-labelledby="retainer-label"><g:formatBoolean boolean="${projectInstance?.retainer}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.retainerEndDate}">
				<li class="fieldcontain">
					<span id="retainerEndDate-label" class="property-label"><g:message code="project.retainerEndDate.label" default="Retainer End Date" /></span>
					
						<span class="property-value" aria-labelledby="retainerEndDate-label"><g:formatDate date="${projectInstance?.retainerEndDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.retainerStartDate}">
				<li class="fieldcontain">
					<span id="retainerStartDate-label" class="property-label"><g:message code="project.retainerStartDate.label" default="Retainer Start Date" /></span>
					
						<span class="property-value" aria-labelledby="retainerStartDate-label"><g:formatDate date="${projectInstance?.retainerStartDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.title}">
				<li class="fieldcontain">
					<span id="title-label" class="property-label"><g:message code="project.title.label" default="Title" /></span>
					
						<span class="property-value" aria-labelledby="title-label"><g:fieldValue bean="${projectInstance}" field="title"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${projectInstance?.id}" />
					<g:link class="edit" action="edit" id="${projectInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
