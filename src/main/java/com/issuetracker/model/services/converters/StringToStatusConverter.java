package com.issuetracker.model.services.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.issuetracker.model.domains.Status;
import com.issuetracker.model.services.interfaces.StatusService;

/**
 * String to status converter.
 * 
 * @author Illia Zharkou
 */
public class StringToStatusConverter implements Converter<String, Status> {
	
	@Autowired
	private StatusService statusService;
	
	/* (non-Javadoc)
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	@Override
	public Status convert(String id) {
		try {
			return statusService.findById(Long.parseLong(id));
		}
		catch(NumberFormatException e) {
			return null;
		}
	}
	
}
