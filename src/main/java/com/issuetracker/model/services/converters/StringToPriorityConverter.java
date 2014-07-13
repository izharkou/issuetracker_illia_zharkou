package com.issuetracker.model.services.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.issuetracker.model.domains.Priority;
import com.issuetracker.model.services.interfaces.PriorityService;

/**
 * String to priority converter.
 * 
 * @author Illia Zharkou
 */
public class StringToPriorityConverter implements
		Converter<String, Priority> {
	
	@Autowired
	private PriorityService priorityService;
	
	/* (non-Javadoc)
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	@Override
	public Priority convert(String id) {
		try {
			return priorityService.findById(Long.parseLong(id));
		} catch (NumberFormatException e) {
			return null;
		}
	}

}
