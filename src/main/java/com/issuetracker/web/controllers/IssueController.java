package com.issuetracker.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.issuetracker.model.constants.GeneralConstants;
import com.issuetracker.model.domains.Attachment;
import com.issuetracker.model.domains.Comment;
import com.issuetracker.model.domains.Issue;
import com.issuetracker.model.domains.Priority;
import com.issuetracker.model.domains.Project;
import com.issuetracker.model.domains.Resolution;
import com.issuetracker.model.domains.Status;
import com.issuetracker.model.domains.Type;
import com.issuetracker.model.domains.User;
import com.issuetracker.model.services.interfaces.AttachmentService;
import com.issuetracker.model.services.interfaces.CommentService;
import com.issuetracker.model.services.interfaces.IssueService;
import com.issuetracker.model.services.interfaces.PriorityService;
import com.issuetracker.model.services.interfaces.ProjectService;
import com.issuetracker.model.services.interfaces.ResolutionService;
import com.issuetracker.model.services.interfaces.StatusService;
import com.issuetracker.model.services.interfaces.TypeService;
import com.issuetracker.model.services.interfaces.UserService;
import com.issuetracker.web.constants.AttributeConstants;
import com.issuetracker.web.constants.MappingConstants;
import com.issuetracker.web.constants.ViewConstants;

/**
 * Issue controller.
 * 
 * @author Illia Zharkou
 */
@Controller
public class IssueController {
	
	@Autowired
	private IssueService issueService;
	@Autowired
	private StatusService statusService;
	@Autowired
	private ResolutionService resolutionService;
	@Autowired
	private TypeService typeService;
	@Autowired
	private PriorityService priorityService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private UserService userService;
	@Autowired
	private AttachmentService attachmentService;
	@Autowired
	private CommentService commentService;
	
	/**
	 * Issues list.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = MappingConstants.URL_ISSUES, method = RequestMethod.GET)
	public String issuesList(@PathVariable(MappingConstants.PARAM_PAGE) Integer page,
			ModelMap model) {
		if(page == null || page < 1) {
			page = 1;
		}
		// set sorting params
		Sort sort = new Sort(Sort.Direction.DESC, GeneralConstants.SORT_COLUMN_NAME);
		// set which page with issues to display
		PageRequest pageRequest = new PageRequest(page - GeneralConstants.PAGE_OFFSET, 
				GeneralConstants.ITEMS_PER_PAGE, sort);
		Page<Issue> issues = issueService.findAllByPage(pageRequest);
		model.addAttribute(AttributeConstants.ISSUES_ATTRIBUTE, issues);
		return ViewConstants.ISSUES_LIST;
	}
	
	/**
	 * View issue.
	 * 
	 * @param issue
	 * @param model
	 * @return
	 */
	@RequestMapping(value = MappingConstants.URL_ISSUE_VIEW, method = RequestMethod.GET)
	public String issueView(@PathVariable(MappingConstants.PARAM_ID) Issue issue, 
			ModelMap model) {
		model.addAttribute(AttributeConstants.ISSUE_ATTRIBUTE, issue);
		return ViewConstants.ISSUE_VIEW;
	}
	
	/**
	 * Add issue form.
	 * 
	 * @return
	 */
	@PreAuthorize(MappingConstants.ACCESS_ANY_AUTHORIZED)
	@RequestMapping(value = MappingConstants.URL_ISSUE_ADD, method = RequestMethod.GET)
	public String addIssueGet(ModelMap model) {
		List<Status> statues = statusService.findAll();
		List<Resolution> resolutions = resolutionService.findAll();
		List<Type> types = typeService.findAll();
		List<Priority> priorities = priorityService.findAll();
		List<Project> projects = projectService.findAll();
		List<User> users = userService.findAll();
		model.addAttribute(AttributeConstants.STATUSES_ATTRIBUTE, statues);
		model.addAttribute(AttributeConstants.RESOLUTIONS_ATTRIBUTE, resolutions);
		model.addAttribute(AttributeConstants.TYPES_ATTRIBUTE, types);
		model.addAttribute(AttributeConstants.PRIORITIES_ATTRIBUTE, priorities);
		model.addAttribute(AttributeConstants.PROJECTS_ATTRIBUTE, projects);
		model.addAttribute(AttributeConstants.USERS_ATTRIBUTE, users);
		return ViewConstants.ISSUE_ADD;
	}
	
	/**
	 * Add issue.
	 * 
	 * @param issue
	 */
	@PreAuthorize(MappingConstants.ACCESS_ANY_AUTHORIZED)
	@RequestMapping(value = MappingConstants.URL_ISSUE_ADD, method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void addIssuePost(@RequestBody Issue issue) {
		issueService.save(issue);
	}
	
	/**
	 * Edit issue form.
	 * 
	 * @return
	 */
	@PreAuthorize(MappingConstants.ACCESS_ANY_AUTHORIZED)
	@RequestMapping(value = MappingConstants.URL_ISSUE_EDIT_ID, method = RequestMethod.GET)
	public String editIssueGet(@PathVariable(MappingConstants.PARAM_ID) Issue issue,
			@RequestParam(value = MappingConstants.PARAM_SUCCESS, required = false) String success,
			ModelMap model) {
		List<Status> statues = statusService.findAll();
		List<Resolution> resolutions = resolutionService.findAll();
		List<Type> types = typeService.findAll();
		List<Priority> priorities = priorityService.findAll();
		List<Project> projects = projectService.findAll();
		List<User> users = userService.findAll();
		List<Attachment> attachments = attachmentService.findByIssue(issue);
		List<Comment> comments = commentService.findByIssue(issue);
		model.addAttribute(AttributeConstants.ISSUE_ATTRIBUTE, issue);
		model.addAttribute(AttributeConstants.STATUSES_ATTRIBUTE, statues);
		model.addAttribute(AttributeConstants.RESOLUTIONS_ATTRIBUTE, resolutions);
		model.addAttribute(AttributeConstants.TYPES_ATTRIBUTE, types);
		model.addAttribute(AttributeConstants.PRIORITIES_ATTRIBUTE, priorities);
		model.addAttribute(AttributeConstants.PROJECTS_ATTRIBUTE, projects);
		model.addAttribute(AttributeConstants.USERS_ATTRIBUTE, users);
		model.addAttribute(AttributeConstants.ATTACHMENTS_ATTRIBUTE, attachments);
		model.addAttribute(AttributeConstants.COMMENTS_ATTRIBUTE, comments);
		model.addAttribute(AttributeConstants.SUCCESS, success);
		return ViewConstants.ISSUE_EDIT_ID;
	}

	/**
	 * Edit issue.
	 * 
	 * @param issue
	 */
	@PreAuthorize(MappingConstants.ACCESS_ANY_AUTHORIZED)
	@RequestMapping(value = MappingConstants.URL_ISSUE_EDIT_ID, method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void editIssuePost(@RequestBody Issue issue) {
		issueService.save(issue);
	}
	
	/**
	 * Search issue form.
	 * 
	 * @param issue
	 * @return
	 */
	@RequestMapping(value = MappingConstants.URL_ISSUE_SEARCH, method = RequestMethod.GET)
	public String searchIssueGet(ModelMap model) {
		List<Status> statues = statusService.findAll();
		List<Resolution> resolutions = resolutionService.findAll();
		List<Type> types = typeService.findAll();
		List<Priority> priorities = priorityService.findAll();
		List<Project> projects = projectService.findAll();
		List<User> users = userService.findAll();
		model.addAttribute(AttributeConstants.STATUSES_ATTRIBUTE, statues);
		model.addAttribute(AttributeConstants.RESOLUTIONS_ATTRIBUTE, resolutions);
		model.addAttribute(AttributeConstants.TYPES_ATTRIBUTE, types);
		model.addAttribute(AttributeConstants.PRIORITIES_ATTRIBUTE, priorities);
		model.addAttribute(AttributeConstants.PROJECTS_ATTRIBUTE, projects);
		model.addAttribute(AttributeConstants.USERS_ATTRIBUTE, users);
		return ViewConstants.ISSUE_SEARCH;
	}
	
	/**
	 * Search issue.
	 * 
	 * @param issue
	 * @return
	 */
	@RequestMapping(value = MappingConstants.URL_ISSUE_SEARCH, method = RequestMethod.POST)
	public @ResponseBody List<Issue> searchIssuePost(@RequestBody Issue issue,
			ModelMap model) {
		return issueService.findAll(issue);
	}
	
	/**
	 * Save comment.
	 * 
	 * @param comment
	 */
	@RequestMapping(value = MappingConstants.URL_ISSUE_COMMENT, method = RequestMethod.POST)
	public @ResponseBody Comment commentPost(@RequestBody Comment comment) {
		return commentService.save(comment);
	}
	
}
