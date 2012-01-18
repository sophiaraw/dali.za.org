package org.za.dali

import org.za.dali.search.ProjectSearch

class ProjectController extends BaseController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	static defaultAction = "list"

	SearchService searchService
	ProjectSearch projectSearch = new ProjectSearch()
	
	/*
	* http://dali.za.org/project
	*/
    def index() {
        redirect(action: "list", params: params)
    }

	/*
	 * http://dali.za.org/project/list
	 */
    def list() {
		projectSearch.title = 'New website'
		List<Project> projects = searchService.getProjects(projectSearch)
//		render(view: '/project/list', model: [projectInstanceList: Project.list(params), projectInstanceTotal: Project.count()])
//        params.max = Math.min(params.max ? params.int('max') : 10, 100)
//		
		render(view: '/project/list', model: [projectInstanceList: projects, projectInstanceTotal: projects.totalCount])
	}

    def create() {
        render(view: '/project/create', model: [projectInstance: new Project(params)] )
    }
//
//    def save() {
//        def projectInstance = new Project(params)
//        if (!projectInstance.save(flush: true)) {
//            render(view: "create", model: [projectInstance: projectInstance])
//            return
//        }
//
//		flash.message = message(code: 'default.created.message', args: [message(code: 'project.label', default: 'Project'), projectInstance.id])
//        redirect(action: "show", id: projectInstance.id)
//    }
//
//    def show() {
//        def projectInstance = Project.get(params.id)
//        if (!projectInstance) {
//			flash.message = message(code: 'default.not.found.message', args: [message(code: 'project.label', default: 'Project'), params.id])
//            redirect(action: "list")
//            return
//        }
//
//        [projectInstance: projectInstance]
//    }
//
//    def edit() {
//        def projectInstance = Project.get(params.id)
//        if (!projectInstance) {
//            flash.message = message(code: 'default.not.found.message', args: [message(code: 'project.label', default: 'Project'), params.id])
//            redirect(action: "list")
//            return
//        }
//
//        [projectInstance: projectInstance]
//    }
//
//    def update() {
//        def projectInstance = Project.get(params.id)
//        if (!projectInstance) {
//            flash.message = message(code: 'default.not.found.message', args: [message(code: 'project.label', default: 'Project'), params.id])
//            redirect(action: "list")
//            return
//        }
//
//        if (params.version) {
//            def version = params.version.toLong()
//            if (projectInstance.version > version) {
//                projectInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
//                          [message(code: 'project.label', default: 'Project')] as Object[],
//                          "Another user has updated this Project while you were editing")
//                render(view: "edit", model: [projectInstance: projectInstance])
//                return
//            }
//        }
//
//        projectInstance.properties = params
//
//        if (!projectInstance.save(flush: true)) {
//            render(view: "edit", model: [projectInstance: projectInstance])
//            return
//        }
//
//		flash.message = message(code: 'default.updated.message', args: [message(code: 'project.label', default: 'Project'), projectInstance.id])
//        redirect(action: "show", id: projectInstance.id)
//    }
//
//    def delete() {
//        def projectInstance = Project.get(params.id)
//        if (!projectInstance) {
//			flash.message = message(code: 'default.not.found.message', args: [message(code: 'project.label', default: 'Project'), params.id])
//            redirect(action: "list")
//            return
//        }
//
//        try {
//            projectInstance.delete(flush: true)
//			flash.message = message(code: 'default.deleted.message', args: [message(code: 'project.label', default: 'Project'), params.id])
//            redirect(action: "list")
//        }
//        catch (DataIntegrityViolationException e) {
//			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'project.label', default: 'Project'), params.id])
//            redirect(action: "show", id: params.id)
//        }
//    }
}
