<%@ page import="org.za.dali.ContactDetail" %>



<div class="fieldcontain ${hasErrors(bean: contactDetailInstance, field: 'value', 'error')} required">
	<label for="value">
		<g:message code="contactDetail.value.label" default="Value" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="value" required="" value="${contactDetailInstance?.value}" rows="5" cols="40"/>
</div>

<div class="fieldcontain ${hasErrors(bean: contactDetailInstance, field: 'costCentre', 'error')} ">
	<label for="costCentre">
		<g:message code="contactDetail.costCentre.label" default="Cost Centre" />
		
	</label>
	<g:select id="costCentre" name="costCentre.id" from="${org.za.dali.CostCentre.list()}" optionKey="id" value="${contactDetailInstance?.costCentre?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: contactDetailInstance, field: 'client', 'error')} ">
	<label for="client">
		<g:message code="contactDetail.client.label" default="Client" />
		
	</label>
	<g:select id="client" name="client.id" from="${org.za.dali.Client.list()}" optionKey="id" value="${contactDetailInstance?.client?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: contactDetailInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="contactDetail.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${contactDetailInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: contactDetailInstance, field: 'type', 'error')} ">
	<label for="type">
		<g:message code="contactDetail.type.label" default="Type" />
		
	</label>
	<g:select name="type" from="${org.za.dali.enums.ContactDetailType?.values()}" keys="${org.za.dali.enums.ContactDetailType.values()*.name()}" value="${contactDetailInstance?.type?.name()}" noSelection="['': '']"/>
</div>

