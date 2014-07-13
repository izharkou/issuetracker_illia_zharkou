package com.issuetracker.web.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.issuetracker.model.constants.GeneralConstants;
import com.issuetracker.model.domains.Build;
import com.issuetracker.model.domains.Project;
import com.issuetracker.model.domains.User;
import com.issuetracker.model.services.interfaces.BuildService;
import com.issuetracker.model.services.interfaces.ProjectService;
import com.issuetracker.model.services.interfaces.UserService;
import com.issuetracker.web.constants.AttributeConstants;
import com.issuetracker.web.constants.MappingConstants;
import com.issuetracker.web.constants.ViewConstants;

/**
 * Project controller.
 * 
 * @author Illia Zharkou
 */
@Controller
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	@Autowired
	private UserService userService;
	@Autowired
	private BuildService buildService;
	
	/**
	 * Projects list.
	 * 
	 * @param model
	 * @return
	 */
	@PreAuthorize(MappingConstants.ACCESS_ONLY_ADMIN)
	@RequestMapping(value = MappingConstants.URL_PROJECTS, method = RequestMethod.GET)
	public String projectsList(@PathVariable(MappingConstants.PARAM_PAGE) Integer page,
			ModelMap model) {
		if(page == null || page < 1) {
			page = 1;
		}
		// set sorting params
		Sort sort = new Sort(Sort.Direction.DESC, GeneralConstants.SORT_COLUMN_NAME);
		// set which page with projects to display
		PageRequest pageRequest = new PageRequest(page - GeneralConstants.PAGE_OFFSET, 
				GeneralConstants.ITEMS_PER_PAGE, sort);
		Page<Project> projects = projectService.findAllByPage(pageRequest);
		model.addAttribute(AttributeConstants.PROJECTS_ATTRIBUTE, projects);
		return ViewConstants.PROJECTS_LIST;
	}
	
	/**
	 * Edit project form.
	 * 
	 * @param project
	 * @param model
	 * @return
	 */
	@PreAuthorize(MappingConstants.ACCESS_ONLY_ADMIN)
	@RequestMapping(value = MappingConstants.URL_PROJECT_EDIT_ID, method = RequestMethod.GET)
	public String editProjectGet(@PathVariable(MappingConstants.PARAM_ID) Project project,
			ModelMap model) {
		List<User> managers = userService.findAll();
		model.addAttribute(AttributeConstants.PROJECT_ATTRIBUTE, project);
		model.addAttribute(AttributeConstants.MANAGERS_ATTRIBUTE, managers);
		return ViewConstants.PROJECT_EDIT_ID;
	}
	
	/**
	 * Edit project
	 * 
	 * @param project
	 */
	@PreAuthorize(MappingConstants.ACCESS_ONLY_ADMIN)
	@RequestMapping(value = MappingConstants.URL_PROJECT_EDIT_ID, method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void editProjectPost(@RequestBody Project project) {
		projectService.save(project);
	}
	
	/**
	 * Add new build.
	 * 
	 * @param build
	 */
	@PreAuthorize(MappingConstants.ACCESS_ONLY_ADMIN)
	@RequestMapping(value = MappingConstants.URL_PROJECT_BUILD_ADD, method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Build addBuild(@RequestParam(MappingConstants.PARAM_ID) Long projectId,
			@RequestBody Build build) {
		Project project = new Project();
		project.setId(projectId);
		build.setProject(project);
	    return buildService.save(build);
	}
	
	/**
	 * Add project form.
	 * 
	 * @param project
	 * @param model
	 * @return
	 */
	@PreAuthorize(MappingConstants.ACCESS_ONLY_ADMIN)
	@RequestMapping(value = MappingConstants.URL_PROJECT_ADD, method = RequestMethod.GET)
	public String addProjectGet(ModelMap model) {
		List<User> managers = userService.findAll();
		model.addAttribute(AttributeConstants.MANAGERS_ATTRIBUTE, managers);
		return ViewConstants.PROJECT_ADD;
	}
	
	/**
	 * Add project.
	 * 
	 * @param project
	 * @param model
	 * @return
	 */
	@PreAuthorize(MappingConstants.ACCESS_ONLY_ADMIN)
	@RequestMapping(value = MappingConstants.URL_PROJECT_ADD, method = RequestMethod.POST)
	public void addProjectPost(@RequestBody Project project) {
		projectService.save(project);
	}
	
	/**
	 * Get project builds.
	 * 
	 * @param project
	 * @return
	 */
	@PreAuthorize(MappingConstants.ACCESS_ANY_AUTHORIZED)
	@RequestMapping(value = MappingConstants.URL_GET_BUILDS, method = RequestMethod.GET)
	public @ResponseBody Set<Build> getBuilds(
			@PathVariable(MappingConstants.PARAM_ID) Project project) {
		return project.getBuilds();
	}
	
}
