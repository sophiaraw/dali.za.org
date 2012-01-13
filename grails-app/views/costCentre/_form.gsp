<%@ page import="org.za.dali.CostCentre" %>



<div class="fieldcontain ${hasErrors(bean: costCentreInstance, field: 'parent', 'error')} ">
	<label for="parent">
		<g:message code="costCentre.parent.label" default="Parent" />
		
	</label>
	<g:select id="parent" name="parent.id" from="${org.za.dali.CostCentre.list()}" optionKey="id" value="${costCentreInstance?.parent?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: costCentreInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="costCentre.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${costCentreInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: costCentreInstance, field: 'registeredName', 'error')} required">
	<label for="registeredName">
		<g:message code="costCentre.registeredName.label" default="Registered Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="registeredName" required="" value="${costCentreInstance?.registeredName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: costCentreInstance, field: 'prefix', 'error')} required">
	<label for="prefix">
		<g:message code="costCentre.prefix.label" default="Prefix" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="prefix" required="" value="${costCentreInstance?.prefix}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: costCentreInstance, field: 'vatPercentage', 'error')} required">
	<label for="vatPercentage">
		<g:message code="costCentre.vatPercentage.label" default="Vat Percentage" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="vatPercentage" required="" value="${fieldValue(bean: costCentreInstance, field: 'vatPercentage')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: costCentreInstance, field: 'invoiceDay', 'error')} ">
	<label for="invoiceDay">
		<g:message code="costCentre.invoiceDay.label" default="Invoice Day" />
		
	</label>
	<g:select name="invoiceDay" from="${1..31}" value="${fieldValue(bean: costCentreInstance, field: 'invoiceDay')}"
          noSelection="['':'Please select']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: costCentreInstance, field: 'accSoftware', 'error')} ">
	<label for="accSoftware">
		<g:message code="costCentre.accSoftware.label" default="Acc Software" />
		
	</label>
	<g:select name="accSoftware" from="${org.za.dali.enums.AccountingSoftware?.values()}" keys="${org.za.dali.enums.AccountingSoftware.values()*.name()}" value="${costCentreInstance?.accSoftware?.name()}" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: costCentreInstance, field: 'clients', 'error')} ">
	<label for="clients">
		<g:message code="costCentre.clients.label" default="Clients" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${costCentreInstance?.clients?}" var="c">
    <li><g:link controller="client" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="client" action="create" params="['costCentre.id': costCentreInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'client.label', default: 'Client')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: costCentreInstance, field: 'contactDetails', 'error')} ">
	<label for="contactDetails">
		<g:message code="costCentre.contactDetails.label" default="Contact Details" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${costCentreInstance?.contactDetails?}" var="c">
    <li><g:link controller="contactDetail" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="contactDetail" action="create" params="['costCentre.id': costCentreInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'contactDetail.label', default: 'ContactDetail')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: costCentreInstance, field: 'currency', 'error')} ">
	<label for="currency">
		<g:message code="costCentre.currency.label" default="Currency" />
		
	</label>
	<g:select name="currency" from="${org.za.dali.enums.Currency?.values()}" keys="${org.za.dali.enums.Currency.values()*.name()}" value="${costCentreInstance?.currency?.name()}" noSelection="['': '']"/>
</div>
<fieldset class="embedded"><legend><g:message code="costCentre.geoLocation.label" default="Geo Location" /></legend>
<div class="fieldcontain ${hasErrors(bean: costCentreInstance, field: 'geoLocation.latitude', 'error')} ">
	<label for="geoLocation.latitude">
		<g:message code="costCentre.geoLocation.latitude.label" default="Latitude" />
		
	</label>
	<g:field type="number" name="latitude" value="${fieldValue(bean: geoLocationInstance, field: 'latitude')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: costCentreInstance, field: 'geoLocation.longitued', 'error')} ">
	<label for="geoLocation.longitued">
		<g:message code="costCentre.geoLocation.longitued.label" default="Longitued" />
		
	</label>
	<g:field type="number" name="longitued" value="${fieldValue(bean: geoLocationInstance, field: 'longitued')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: costCentreInstance, field: 'geoLocation.zoomLevel', 'error')} ">
	<label for="geoLocation.zoomLevel">
		<g:message code="costCentre.geoLocation.zoomLevel.label" default="Zoom Level" />
		
	</label>
	<g:field type="number" name="zoomLevel" value="${fieldValue(bean: geoLocationInstance, field: 'zoomLevel')}"/>
</div>
</fieldset>
