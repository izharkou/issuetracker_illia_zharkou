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

import com.issuetracker.model.domains.Status;
import com.issuetracker.model.services.interfaces.StatusService;
import com.issuetracker.web.constants.AttributeConstants;
import com.issuetracker.web.constants.MappingConstants;
import com.issuetracker.web.constants.ViewConstants;

/**
 * Status controller.
 * 
 * @author Illia Zharkou
 */
@Controller
public class StatusController {
	
	@Autowired
	private StatusService statusService;
	
	/**
	 * Edit status form.
	 * 
	 * @return
	 */
	@PreAuthorize(MappingConstants.ACCESS_ONLY_ADMIN)
	@RequestMapping(value = MappingConstants.URL_STATUS_EDIT_ID, method = RequestMethod.GET)
	public String editStatusGet(@PathVariable(MappingConstants.PARAM_ID) Status status,
			ModelMap model) {
		model.addAttribute(AttributeConstants.STATUS_ATTRIBUTE, status);
		return ViewConstants.STATUS_EDIT_ID;
	}
	
	/**
	 * Edit status.
	 * 
	 * @param status
	 */
	@PreAuthorize(MappingConstants.ACCESS_ONLY_ADMIN)
	@RequestMapping(value = MappingConstants.URL_STATUS_EDIT_ID, method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void editStatusPost(@RequestBody Status status) {
		statusService.save(status);
	}
	
	/**
	 * Show all statuses.
	 * 
	 * @param model
	 * @return
	 */
	@PreAuthorize(MappingConstants.ACCESS_ONLY_ADMIN)
	@RequestMapping(value = MappingConstants.URL_STATUSES)
	public String showAll(ModelMap model) {
		List<Status> statuses = statusService.findAll();
		model.addAttribute(AttributeConstants.STATUSES_ATTRIBUTE, statuses);
		return ViewConstants.STATUSES_LIST;
	}
	
}
