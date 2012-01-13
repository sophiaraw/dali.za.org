package org.za.dali

import org.springframework.dao.DataIntegrityViolationException

class ContactDetailController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [contactDetailInstanceList: ContactDetail.list(params), contactDetailInstanceTotal: ContactDetail.count()]
    }

    def create() {
        [contactDetailInstance: new ContactDetail(params)]
    }

    def save() {
        def contactDetailInstance = new ContactDetail(params)
        if (!contactDetailInstance.save(flush: true)) {
            render(view: "create", model: [contactDetailInstance: contactDetailInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'contactDetail.label', default: 'ContactDetail'), contactDetailInstance.id])
        redirect(action: "show", id: contactDetailInstance.id)
    }

    def show() {
        def contactDetailInstance = ContactDetail.get(params.id)
        if (!contactDetailInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'contactDetail.label', default: 'ContactDetail'), params.id])
            redirect(action: "list")
            return
        }

        [contactDetailInstance: contactDetailInstance]
    }

    def edit() {
        def contactDetailInstance = ContactDetail.get(params.id)
        if (!contactDetailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'contactDetail.label', default: 'ContactDetail'), params.id])
            redirect(action: "list")
            return
        }

        [contactDetailInstance: contactDetailInstance]
    }

    def update() {
        def contactDetailInstance = ContactDetail.get(params.id)
        if (!contactDetailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'contactDetail.label', default: 'ContactDetail'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (contactDetailInstance.version > version) {
                contactDetailInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'contactDetail.label', default: 'ContactDetail')] as Object[],
                          "Another user has updated this ContactDetail while you were editing")
                render(view: "edit", model: [contactDetailInstance: contactDetailInstance])
                return
            }
        }

        contactDetailInstance.properties = params

        if (!contactDetailInstance.save(flush: true)) {
            render(view: "edit", model: [contactDetailInstance: contactDetailInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'contactDetail.label', default: 'ContactDetail'), contactDetailInstance.id])
        redirect(action: "show", id: contactDetailInstance.id)
    }

    def delete() {
        def contactDetailInstance = ContactDetail.get(params.id)
        if (!contactDetailInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'contactDetail.label', default: 'ContactDetail'), params.id])
            redirect(action: "list")
            return
        }

        try {
            contactDetailInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'contactDetail.label', default: 'ContactDetail'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'contactDetail.label', default: 'ContactDetail'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
