<%@ page import="org.za.dali.Project" %>



<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'type', 'error')} ">
	<label for="type">
		<g:message code="project.type.label" default="Type" />
		
	</label>
	<g:select name="type" from="${org.za.dali.enums.ProjectType?.values()}" keys="${org.za.dali.enums.ProjectType.values()*.name()}" value="${projectInstance?.type?.name()}" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'status', 'error')} ">
	<label for="status">
		<g:message code="project.status.label" default="Status" />
		
	</label>
	<g:select name="status" from="${org.za.dali.enums.ProjectStatus?.values()}" keys="${org.za.dali.enums.ProjectStatus.values()*.name()}" value="${projectInstance?.status?.name()}" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'trafficManager', 'error')} required">
	<label for="trafficManager">
		<g:message code="project.trafficManager.label" default="Traffic Manager" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="trafficManager" name="trafficManager.id" from="${org.za.dali.User.list()}" optionKey="id" required="" value="${projectInstance?.trafficManager?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'projectOwner', 'error')} required">
	<label for="projectOwner">
		<g:message code="project.projectOwner.label" default="Project Owner" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="projectOwner" name="projectOwner.id" from="${org.za.dali.User.list()}" optionKey="id" required="" value="${projectInstance?.projectOwner?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'PONumber', 'error')} ">
	<label for="PONumber">
		<g:message code="project.PONumber.label" default="PON umber" />
		
	</label>
	<g:textField name="PONumber" value="${projectInstance?.PONumber}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'actualDeliveryDate', 'error')} ">
	<label for="actualDeliveryDate">
		<g:message code="project.actualDeliveryDate.label" default="Actual Delivery Date" />
		
	</label>
	<g:datePicker name="actualDeliveryDate" precision="day"  value="${projectInstance?.actualDeliveryDate}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'auditLogReason', 'error')} ">
	<label for="auditLogReason">
		<g:message code="project.auditLogReason.label" default="Audit Log Reason" />
		
	</label>
	<g:textField name="auditLogReason" value="${projectInstance?.auditLogReason}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'budgetAdjustments', 'error')} ">
	<label for="budgetAdjustments">
		<g:message code="project.budgetAdjustments.label" default="Budget Adjustments" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${projectInstance?.budgetAdjustments?}" var="b">
    <li><g:link controller="budgetAdjustment" action="show" id="${b.id}">${b?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="budgetAdjustment" action="create" params="['project.id': projectInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'budgetAdjustment.label', default: 'BudgetAdjustment')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'client', 'error')} ">
	<label for="client">
		<g:message code="project.client.label" default="Client" />
		
	</label>
	<g:select id="client" name="client.id" from="${org.za.dali.Client.list()}" optionKey="id" value="${projectInstance?.client?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'contacts', 'error')} ">
	<label for="contacts">
		<g:message code="project.contacts.label" default="Contacts" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${projectInstance?.contacts?}" var="c">
    <li><g:link controller="contact" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="contact" action="create" params="['project.id': projectInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'contact.label', default: 'Contact')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'createdBy', 'error')} ">
	<label for="createdBy">
		<g:message code="project.createdBy.label" default="Created By" />
		
	</label>
	<g:select id="createdBy" name="createdBy.id" from="${org.za.dali.User.list()}" optionKey="id" value="${projectInstance?.createdBy?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="project.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${projectInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'emailAlias', 'error')} ">
	<label for="emailAlias">
		<g:message code="project.emailAlias.label" default="Email Alias" />
		
	</label>
	<g:textField name="emailAlias" value="${projectInstance?.emailAlias}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'expiresOn', 'error')} ">
	<label for="expiresOn">
		<g:message code="project.expiresOn.label" default="Expires On" />
		
	</label>
	<g:datePicker name="expiresOn" precision="day"  value="${projectInstance?.expiresOn}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'jobNumber', 'error')} ">
	<label for="jobNumber">
		<g:message code="project.jobNumber.label" default="Job Number" />
		
	</label>
	<g:textField name="jobNumber" value="${projectInstance?.jobNumber}"/>
</div>
<fieldset class="embedded"><legend><g:message code="project.opportunity.label" default="Opportunity" /></legend>
<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'opportunity.date', 'error')} ">
	<label for="opportunity.date">
		<g:message code="project.opportunity.date.label" default="Date" />
		
	</label>
	<g:datePicker name="date" precision="day"  value="${opportunityInstance?.date}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'opportunity.level', 'error')} ">
	<label for="opportunity.level">
		<g:message code="project.opportunity.level.label" default="Level" />
		
	</label>
	<g:select name="level" from="${org.za.dali.enums.OpportunityLevel?.values()}" keys="${org.za.dali.enums.OpportunityLevel.values()*.name()}" value="${opportunityInstance?.level?.name()}" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'opportunity.percentage', 'error')} ">
	<label for="opportunity.percentage">
		<g:message code="project.opportunity.percentage.label" default="Percentage" />
		
	</label>
	<g:field type="number" name="percentage" value="${fieldValue(bean: opportunityInstance, field: 'percentage')}"/>
</div>
</fieldset>
<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'parent', 'error')} required">
	<label for="parent">
		<g:message code="project.parent.label" default="Parent" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="parent" name="parent.id" from="${org.za.dali.Project.list()}" optionKey="id" required="" value="${projectInstance?.parent?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'rateCards', 'error')} ">
	<label for="rateCards">
		<g:message code="project.rateCards.label" default="Rate Cards" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${projectInstance?.rateCards?}" var="r">
    <li><g:link controller="rateCard" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="rateCard" action="create" params="['project.id': projectInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'rateCard.label', default: 'RateCard')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'requestedDeliveryDate', 'error')} ">
	<label for="requestedDeliveryDate">
		<g:message code="project.requestedDeliveryDate.label" default="Requested Delivery Date" />
		
	</label>
	<g:datePicker name="requestedDeliveryDate" precision="day"  value="${projectInstance?.requestedDeliveryDate}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'retainer', 'error')} ">
	<label for="retainer">
		<g:message code="project.retainer.label" default="Retainer" />
		
	</label>
	<g:checkBox name="retainer" value="${projectInstance?.retainer}" />
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'retainerEndDate', 'error')} ">
	<label for="retainerEndDate">
		<g:message code="project.retainerEndDate.label" default="Retainer End Date" />
		
	</label>
	<g:datePicker name="retainerEndDate" precision="day"  value="${projectInstance?.retainerEndDate}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'retainerStartDate', 'error')} ">
	<label for="retainerStartDate">
		<g:message code="project.retainerStartDate.label" default="Retainer Start Date" />
		
	</label>
	<g:datePicker name="retainerStartDate" precision="day"  value="${projectInstance?.retainerStartDate}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'title', 'error')} ">
	<label for="title">
		<g:message code="project.title.label" default="Title" />
		
	</label>
	<g:textField name="title" value="${projectInstance?.title}"/>
</div>

