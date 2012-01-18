
<%@ page import="org.za.dali.Project" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'project.label', default: 'Project')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-project" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-project" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="type" title="${message(code: 'project.type.label', default: 'Type')}" />
					
						<g:sortableColumn property="status" title="${message(code: 'project.status.label', default: 'Status')}" />
					
						<th><g:message code="project.trafficManager.label" default="Traffic Manager" /></th>
					
						<th><g:message code="project.projectOwner.label" default="Project Owner" /></th>
					
						<g:sortableColumn property="PONumber" title="${message(code: 'project.PONumber.label', default: 'PO Number')}" />
					
						<g:sortableColumn property="actualDeliveryDate" title="${message(code: 'project.actualDeliveryDate.label', default: 'Actual Delivery Date')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${projectInstanceList}" status="i" var="projectInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${projectInstance.id}">${fieldValue(bean: projectInstance, field: "type")}</g:link></td>
					
						<td>${fieldValue(bean: projectInstance, field: "status")}</td>
					
						<td>${fieldValue(bean: projectInstance, field: "trafficManager")}</td>
					
						<td>${fieldValue(bean: projectInstance, field: "projectOwner")}</td>
					
						<td>${fieldValue(bean: projectInstance, field: "PONumber")}</td>
					
						<td><g:formatDate date="${projectInstance.actualDeliveryDate}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${projectInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
