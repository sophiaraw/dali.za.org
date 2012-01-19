package org.za.dali

import org.za.dali.enums.ProjectStatus
import org.za.dali.search.ProjectSearch

class ProjectController extends BaseController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	static defaultAction = "list"

	ProjectService projectService
	SearchService searchService
	ProjectSearch projectSearch = new ProjectSearch()
	
	/*
	 * default: http://dali.za.org/project
	 * http://dali.za.org/project/list
	 */
    def list() {
//		projectSearch.title = 'New website'
		List<Project> projects = searchService.getProjects(projectSearch)
		
		render(view: '/project/list', model: [projectInstanceList: projects, projectInstanceTotal: projects.totalCount])
	}

	/*
	* http://dali.za.org/project/create
	*/
    def create() {
        render(view: '/project/create', model: [projectInstance: new Project()] )
    }

	/*
	* http://dali.za.org/project/save
	*/
	def save() {
		def projectInstance = new Project()
		
		if(projectService.save(projectInstance, params)) {
			flash.message = message(code: 'default.created.message', args: [message(code: 'project.label', default: 'Project'), projectInstance.id])
			redirect(action: "show", id: projectInstance.id)
		}
		
		render(view: '/project/create', model: [projectInstance: projectInstance] )
	}
	
	/*
	* http://dali.za.org/project/edit
	*/
    def edit() {
	    def projectInstance = Project.get(params.id)
	    if (!projectInstance) {
	        flash.message = message(code: 'default.not.found.message', args: [message(code: 'project.label', default: 'Project'), params.id])
	        redirect(action: "list")
	        return
	    }
	
	    [projectInstance: projectInstance]
    }
	
	/*
	* http://dali.za.org/project/update
	*/
	def update() {
		def projectInstance = Project.get(params.id)
		if (!projectInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'project.label', default: 'Project'), params.id])
			redirect(action: "list")
			return
		}

		if(projectService.save(projectInstance, params)) {
			redirect(action: "show", id: projectInstance.id)
		}
		
		render(view: "edit", model: [projectInstance: projectInstance])
	}
	
    def show() {
        def projectInstance = Project.get(params.id)
        if (!projectInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'project.label', default: 'Project'), params.id])
            redirect(action: "list")
            return
        }

        [projectInstance: projectInstance]
    }
    
    def delete() {
        def projectInstance = Project.get(params.id)
        if (!projectInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'project.label', default: 'Project'), params.id])
            redirect(action: "list")
            return
        }

		params.status = ProjectStatus.DELETED
		
		if(projectService.save(projectInstance, params)) {
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'project.label', default: 'Project'), params.id])
            redirect(action: "list")
		}
		
		flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'project.label', default: 'Project'), params.id])
		redirect(action: "show", id: params.id)
    }
}
