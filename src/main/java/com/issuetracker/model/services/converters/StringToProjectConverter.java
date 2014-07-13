package com.issuetracker.model.services.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.issuetracker.model.domains.Project;
import com.issuetracker.model.services.interfaces.ProjectService;

/**
 * String to project converter.
 * 
 * @author Illia Zharkou
 */
public class StringToProjectConverter implements Converter<String, Project> {
	
	@Autowired
	private ProjectService projectService;
	
	/* (non-Javadoc)
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	@Override
	public Project convert(String id) {
		try {
			return projectService.findById(Long.parseLong(id));
		}
		catch(NumberFormatException e) {
			return null;
		}
	}
	
}