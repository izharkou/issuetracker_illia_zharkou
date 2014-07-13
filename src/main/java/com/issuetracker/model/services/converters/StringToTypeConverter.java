package com.issuetracker.model.services.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.issuetracker.model.domains.Type;
import com.issuetracker.model.services.interfaces.TypeService;

/**
 * String to type converter.
 * 
 * @author Illia Zharkou
 */
public class StringToTypeConverter implements Converter<String, Type> {
	
	@Autowired
	private TypeService typeService;
	
	/* (non-Javadoc)
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	@Override
	public Type convert(String id) {
		try {
			return typeService.findById(Long.parseLong(id));
		}
		catch(NumberFormatException e) {
			return null;
		}
	}
	
}
