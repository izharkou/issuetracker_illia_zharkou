package com.issuetracker.model.services.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.issuetracker.model.domains.User;
import com.issuetracker.model.services.interfaces.UserService;

/**
 * String to user converter.
 * 
 * @author Illia Zharkou
 */
public class StringToUserConverter implements Converter<String, User> {
	
	@Autowired
	private UserService userService;
	
	/* (non-Javadoc)
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	@Override
	public User convert(String id) {
		try {
			return userService.findById(Long.parseLong(id));
		} catch (NumberFormatException e) {
			return null;
		}
	}

}
