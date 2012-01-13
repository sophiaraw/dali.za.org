package org.za.dali

import org.springframework.dao.DataIntegrityViolationException

class CostCentreController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [costCentreInstanceList: CostCentre.list(params), costCentreInstanceTotal: CostCentre.count()]
    }

    def create() {
        [costCentreInstance: new CostCentre(params)]
    }

    def save() {
        def costCentreInstance = new CostCentre(params)
        if (!costCentreInstance.save(flush: true)) {
            render(view: "create", model: [costCentreInstance: costCentreInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'costCentre.label', default: 'CostCentre'), costCentreInstance.id])
        redirect(action: "show", id: costCentreInstance.id)
    }

    def show() {
        def costCentreInstance = CostCentre.get(params.id)
        if (!costCentreInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'costCentre.label', default: 'CostCentre'), params.id])
            redirect(action: "list")
            return
        }

//		List auditLogs = AuditLogEvent.findAllByClassNameAndPersistedObjectId(costCentreInstance.getClass().getName(),costCentreInstance.id)
		
        [costCentreInstance: costCentreInstance]
    }

    def edit() {
        def costCentreInstance = CostCentre.get(params.id)
        if (!costCentreInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'costCentre.label', default: 'CostCentre'), params.id])
            redirect(action: "list")
            return
        }

        [costCentreInstance: costCentreInstance]
    }

    def update() {
        def costCentreInstance = CostCentre.get(params.id)
		costCentreInstance.auditLogReason = 'This is my reason for the change'
        if (!costCentreInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'costCentre.label', default: 'CostCentre'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (costCentreInstance.version > version) {
                costCentreInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'costCentre.label', default: 'CostCentre')] as Object[],
                          "Another user has updated this CostCentre while you were editing")
                render(view: "edit", model: [costCentreInstance: costCentreInstance])
                return
            }
        }

        costCentreInstance.properties = params

        if (!costCentreInstance.save(flush: true)) {
            render(view: "edit", model: [costCentreInstance: costCentreInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'costCentre.label', default: 'CostCentre'), costCentreInstance.id])
        redirect(action: "show", id: costCentreInstance.id)
    }

    def delete() {
        def costCentreInstance = CostCentre.get(params.id)
        if (!costCentreInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'costCentre.label', default: 'CostCentre'), params.id])
            redirect(action: "list")
            return
        }

        try {
            costCentreInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'costCentre.label', default: 'CostCentre'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'costCentre.label', default: 'CostCentre'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
