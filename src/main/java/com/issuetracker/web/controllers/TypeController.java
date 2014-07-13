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

import com.issuetracker.model.domains.Type;
import com.issuetracker.model.services.interfaces.TypeService;
import com.issuetracker.web.constants.AttributeConstants;
import com.issuetracker.web.constants.MappingConstants;
import com.issuetracker.web.constants.ViewConstants;

/**
 * Type controller.
 * 
 * @author Illia Zharkou
 */
@Controller
public class TypeController {
	
	@Autowired
	private TypeService typeService;
	
	/**
	 * Add type form.
	 * 
	 * @return
	 */
	@PreAuthorize(MappingConstants.ACCESS_ONLY_ADMIN)
	@RequestMapping(value = MappingConstants.URL_TYPE_ADD, method = RequestMethod.GET)
	public String addTypeGet() {
		return ViewConstants.TYPE_ADD;
	}
	
	/**
	 * Add type.
	 * 
	 * @param type
	 */
	@PreAuthorize(MappingConstants.ACCESS_ONLY_ADMIN)
	@RequestMapping(value = MappingConstants.URL_TYPE_ADD, method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void addTypePost(@RequestBody Type type) {
		typeService.save(type);
	}
	
	/**
	 * Edit type form.
	 * 
	 * @return
	 */
	@PreAuthorize(MappingConstants.ACCESS_ONLY_ADMIN)
	@RequestMapping(value = MappingConstants.URL_TYPE_EDIT_ID, method = RequestMethod.GET)
	public String editTypeGet(@PathVariable(MappingConstants.PARAM_ID) Type type,
			ModelMap model) {
		model.addAttribute(AttributeConstants.TYPE_ATTRIBUTE, type);
		return ViewConstants.TYPE_EDIT_ID;
	}
	
	/**
	 * Edit type.
	 * 
	 * @param type
	 */
	@PreAuthorize(MappingConstants.ACCESS_ONLY_ADMIN)
	@RequestMapping(value = MappingConstants.URL_TYPE_EDIT_ID, method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void editTypePost(@RequestBody Type type) {
		typeService.save(type);
	}
	
	/**
	 * Type list.
	 * 
	 * @param model
	 * @return
	 */
	@PreAuthorize(MappingConstants.ACCESS_ONLY_ADMIN)
	@RequestMapping(value = MappingConstants.URL_TYPES)
	public String showAll(ModelMap model) {
		List<Type> types = typeService.findAll();
		model.addAttribute(AttributeConstants.TYPES_ATTRIBUTE, types);
		return ViewConstants.TYPES_LIST;
	}
	
}