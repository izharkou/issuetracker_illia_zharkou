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

import com.issuetracker.model.domains.Resolution;
import com.issuetracker.model.services.interfaces.ResolutionService;
import com.issuetracker.web.constants.AttributeConstants;
import com.issuetracker.web.constants.MappingConstants;
import com.issuetracker.web.constants.ViewConstants;

/**
 * Resolution controller.
 * 
 * @author Illia Zharkou
 */
@Controller
public class ResolutionController {
	
	@Autowired
	private ResolutionService resolutionService;
	
	/**
	 * Add resolution form.
	 * 
	 * @return
	 */
	@PreAuthorize(MappingConstants.ACCESS_ONLY_ADMIN)
	@RequestMapping(value = MappingConstants.URL_RESOLUTION_ADD, method = RequestMethod.GET)
	public String addResolutionGet() {
		return ViewConstants.RESOLUTION_ADD;
	}
	
	/**
	 * Add resolution.
	 * 
	 * @param resolution
	 */
	@PreAuthorize(MappingConstants.ACCESS_ONLY_ADMIN)
	@RequestMapping(value = MappingConstants.URL_RESOLUTION_ADD, method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void addResolutionPost(@RequestBody Resolution resolution) {
		resolutionService.save(resolution);
	}
	
	/**
	 * Edit resolution form.
	 * 
	 * @return
	 */
	@PreAuthorize(MappingConstants.ACCESS_ONLY_ADMIN)
	@RequestMapping(value = MappingConstants.URL_RESOLUTION_EDIT_ID, method = RequestMethod.GET)
	public String editResolutionGet(@PathVariable(MappingConstants.PARAM_ID) Resolution resolution,
			ModelMap model) {
		model.addAttribute(AttributeConstants.RESOLUTION_ATTRIBUTE, resolution);
		return ViewConstants.RESOLUTION_EDIT_ID;
	}
	
	/**
	 * Edit resolution.
	 * 
	 * @param resolution
	 */
	@PreAuthorize(MappingConstants.ACCESS_ONLY_ADMIN)
	@RequestMapping(value = MappingConstants.URL_RESOLUTION_EDIT_ID, method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void editResolutionPost(@RequestBody Resolution resolution) {
		resolutionService.save(resolution);
	}
	
	/**
	 * Resolutions list.
	 * 
	 * @param model
	 * @return
	 */
	@PreAuthorize(MappingConstants.ACCESS_ONLY_ADMIN)
	@RequestMapping(value = MappingConstants.URL_RESOLUTIONS)
	public String showAll(ModelMap model) {
		List<Resolution> resolutions = resolutionService.findAll();
		model.addAttribute(AttributeConstants.RESOLUTIONS_ATTRIBUTE, resolutions);
		return ViewConstants.RESOLUTIONS_LIST;
	}
	
}