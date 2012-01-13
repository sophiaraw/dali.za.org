
<%@ page import="org.za.dali.ContactDetail" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'contactDetail.label', default: 'ContactDetail')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-contactDetail" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-contactDetail" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="value" title="${message(code: 'contactDetail.value.label', default: 'Value')}" />
					
						<th><g:message code="contactDetail.costCentre.label" default="Cost Centre" /></th>
					
						<th><g:message code="contactDetail.client.label" default="Client" /></th>
					
						<g:sortableColumn property="name" title="${message(code: 'contactDetail.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="type" title="${message(code: 'contactDetail.type.label', default: 'Type')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${contactDetailInstanceList}" status="i" var="contactDetailInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${contactDetailInstance.id}">${fieldValue(bean: contactDetailInstance, field: "value")}</g:link></td>
					
						<td>${fieldValue(bean: contactDetailInstance, field: "costCentre")}</td>
					
						<td>${fieldValue(bean: contactDetailInstance, field: "client")}</td>
					
						<td>${fieldValue(bean: contactDetailInstance, field: "name")}</td>
					
						<td>${fieldValue(bean: contactDetailInstance, field: "type")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${contactDetailInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
