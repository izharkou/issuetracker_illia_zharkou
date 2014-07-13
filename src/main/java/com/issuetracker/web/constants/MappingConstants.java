package com.issuetracker.web.constants;

/**
 * Url mapping constants.
 * 
 * @author Illia Zharkou
 */
public class MappingConstants {
	
	// access
	public static final String ACCESS_ONLY_ADMIN = "hasRole('ROLE_ADMIN')";
	public static final String ACCESS_ANY_AUTHORIZED = "isAuthenticated()";
	
	// params
	public static final String PARAM_ID = "id";
	public static final String PARAM_PAGE = "page";
	public static final String PARAM_SUCCESS = "success";
	public static final String PARAM_FILENAME = "filename";
	
	// urls
	public static final String URL_DASHBOARD = "/dashboard";
	
	public static final String URL_USER_AUTH_FAILED = "/user/auth/failed";
	public static final String URL_USER_EDIT = "/user/edit";
	public static final String URL_USER_EDIT_PASSWD = "/user/edit/password";
	public static final String URL_USER_ADD = "/user/add";
	public static final String URL_USER_EDIT_ID = "/user/edit/{id}";
	public static final String URL_USER_EDIT_ID_PASSWD = "/user/edit/{id}/password";
	public static final String URL_USER_SEARCH = "/user/search";
	public static final String URL_USER_VIEW = "/user/{id}";
	
	public static final String URL_STATUS_EDIT_ID = "/status/edit/{id}";
	public static final String URL_STATUSES = "/status/list";
	
	public static final String URL_RESOLUTION_EDIT_ID = "/resolution/edit/{id}";
	public static final String URL_RESOLUTION_ADD = "/resolution/add";
	public static final String URL_RESOLUTIONS = "/resolution/list";
	
	public static final String URL_PRIORITY_EDIT_ID = "/priority/edit/{id}";
	public static final String URL_PRIORITY_ADD = "/priority/add";
	public static final String URL_PRIORITIES = "/priority/list";
	
	public static final String URL_TYPE_EDIT_ID = "/type/edit/{id}";
	public static final String URL_TYPE_ADD = "/type/add";
	public static final String URL_TYPES = "/type/list";
	
	public static final String URL_PROJECTS = "/project/list/{page}";
	public static final String URL_PROJECT_EDIT_ID = "/project/edit/{id}";
	public static final String URL_PROJECT_BUILD_ADD = "/project/build/add";
	public static final String URL_PROJECT_ADD = "/project/add";
	public static final String URL_GET_BUILDS = "/project/{id}/builds";
	
	public static final String URL_ISSUE_EDIT_ID = "/issue/edit/{id}";
	public static final String URL_ISSUE_ADD = "/issue/add";
	public static final String URL_ISSUES = "/issue/list/{page}";
	public static final String URL_ISSUE_VIEW = "/issue/{id}";
	public static final String URL_ISSUE_SEARCH = "/issue/search";
	public static final String URL_ISSUE_COMMENT = "/issue/comment";
	
	public static final String URL_UPLOAD_ATTACHMENT = "/issue/attachment";
	public static final String URL_DOWNLOAD_ATTACHMENT = "/issue/download";
	
}
