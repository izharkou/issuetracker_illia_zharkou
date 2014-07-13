package com.issuetracker.model.services.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.issuetracker.model.domains.Resolution;
import com.issuetracker.model.services.interfaces.ResolutionService;

/**
 * String to resolution converter.
 * 
 * @author Illia Zharkou
 */
public class StringToResolutionConverter implements
		Converter<String, Resolution> {
	
	@Autowired
	private ResolutionService resolutionService;
	
	/* (non-Javadoc)
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	@Override
	public Resolution convert(String id) {
		try {
			return resolutionService.findById(Long.parseLong(id));
		} catch (NumberFormatException e) {
			return null;
		}
	}

}
