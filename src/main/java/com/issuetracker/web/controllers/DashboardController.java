package com.issuetracker.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.issuetracker.model.constants.GeneralConstants;
import com.issuetracker.model.domains.Issue;
import com.issuetracker.model.services.interfaces.IssueService;
import com.issuetracker.web.constants.AttributeConstants;
import com.issuetracker.web.constants.MappingConstants;
import com.issuetracker.web.constants.ViewConstants;

/**
 * Dashboard controller.
 * 
 * @author Illia Zharkou
 */
@Controller
public class DashboardController {
	
	@Autowired
	private IssueService issueService;
	
	/**
	 * Index page.
	 * 
	 * @return
	 */
	@RequestMapping(value = MappingConstants.URL_DASHBOARD, method = RequestMethod.GET)
	public String dashboard(ModelMap model) {
		Sort sort = new Sort(Sort.Direction.DESC, GeneralConstants.SORT_COLUMN_NAME);
		PageRequest pageRequest = new PageRequest(0, 
				GeneralConstants.ITEMS_PER_PAGE, sort);
		Page<Issue> issues = issueService.findAllByPage(pageRequest);
		model.addAttribute(AttributeConstants.ISSUES_ATTRIBUTE, issues);
		return ViewConstants.DASHBOARD;
	}
	
}
