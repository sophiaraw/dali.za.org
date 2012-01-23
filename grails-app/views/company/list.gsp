
<%@ page import="org.za.dali.Company" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'costCentre.label', default: 'CostCentre')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-costCentre" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-costCentre" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="costCentre.parent.label" default="Parent" /></th>
					
						<g:sortableColumn property="name" title="${message(code: 'costCentre.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="registeredName" title="${message(code: 'costCentre.registeredName.label', default: 'Registered Name')}" />
					
						<g:sortableColumn property="prefix" title="${message(code: 'costCentre.prefix.label', default: 'Prefix')}" />
					
						<g:sortableColumn property="vatPercentage" title="${message(code: 'costCentre.vatPercentage.label', default: 'Vat Percentage')}" />
					
						<g:sortableColumn property="invoiceDay" title="${message(code: 'costCentre.invoiceDay.label', default: 'Invoice Day')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${costCentreInstanceList}" status="i" var="costCentreInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td>${fieldValue(bean: costCentreInstance, field: "parent")}</td>
					
						<td><g:link action="show" id="${costCentreInstance.id}">${fieldValue(bean: costCentreInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: costCentreInstance, field: "registeredName")}</td>
					
						<td>${fieldValue(bean: costCentreInstance, field: "prefix")}</td>
					
						<td>${fieldValue(bean: costCentreInstance, field: "vatPercentage")}</td>
					
						<td>${fieldValue(bean: costCentreInstance, field: "invoiceDay")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${costCentreInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
