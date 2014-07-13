package com.issuetracker.model.services.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.issuetracker.model.domains.Issue;
import com.issuetracker.model.services.interfaces.IssueService;

/**
 * String to issue converter.
 * 
 * @author Illia Zharkou
 */
public class StringToIssueConverter implements Converter<String, Issue> {
	
	@Autowired
	private IssueService issueService;
	
	/* (non-Javadoc)
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	@Override
	public Issue convert(String id) {
		try {
			return issueService.findById(Long.parseLong(id));
		} catch (NumberFormatException e) {
			return null;
		}
	}

}
