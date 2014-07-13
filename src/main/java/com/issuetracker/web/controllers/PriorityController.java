package com.issuetracker.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.issuetracker.model.domains.Priority;
import com.issuetracker.model.services.interfaces.PriorityService;
import com.issuetracker.web.constants.AttributeConstants;
import com.issuetracker.web.constants.MappingConstants;
import com.issuetracker.web.constants.ViewConstants;

/**
 * Priority controller.
 * 
 * @author Illia Zharkou
 */
@Controller
public class PriorityController {
	
	@Autowired
	private PriorityService priorityService;
	
	/**
	 * Add priority form.
	 * 
	 * @return
	 */
	@PreAuthorize(MappingConstants.ACCESS_ONLY_ADMIN)
	@RequestMapping(value = MappingConstants.URL_PRIORITY_ADD, method = RequestMethod.GET)
	public String addPriorityGet() {
		return ViewConstants.PRIORITY_ADD;
	}
	
	/**
	 * Add priority.
	 * 
	 * @param priority
	 */
	@PreAuthorize(MappingConstants.ACCESS_ONLY_ADMIN)
	@RequestMapping(value = MappingConstants.URL_PRIORITY_ADD, method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void addPriorityPost(@RequestBody Priority priority) {
		priorityService.save(priority);
	}
	
	/**
	 * Edit priority form.
	 * 
	 * @return
	 */
	@PreAuthorize(MappingConstants.ACCESS_ONLY_ADMIN)
	@RequestMapping(value = MappingConstants.URL_PRIORITY_EDIT_ID, method = RequestMethod.GET)
	public String editPriorityGet(@PathVariable(MappingConstants.PARAM_ID) Priority priority,
			ModelMap model) {
		model.addAttribute(AttributeConstants.PRIORITY_ATTRIBUTE, priority);
		return ViewConstants.PRIORITY_EDIT_ID;
	}
	
	/**
	 * Edit priority.
	 * 
	 * @param priority
	 */
	@PreAuthorize(MappingConstants.ACCESS_ONLY_ADMIN)
	@RequestMapping(value = MappingConstants.URL_PRIORITY_EDIT_ID, method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void editPriorityPost(@RequestBody Priority priority) {
		priorityService.save(priority);
	}
	
	/**
	 * Priorities list.
	 * 
	 * @param model
	 * @return
	 */
	@PreAuthorize(MappingConstants.ACCESS_ONLY_ADMIN)
	@RequestMapping(value = MappingConstants.URL_PRIORITIES)
	public String showAll(ModelMap model) {
		List<Priority> priorities = priorityService.findAll();
		model.addAttribute(AttributeConstants.PRIORITIES_ATTRIBUTE, priorities);
		return ViewConstants.PRIORITIES_LIST;
	}
	
}