package com.issuetracker.model.constants;

/**
 * Database schema constants.
 * 
 * @author Illia Zharkou
 */
public class DatabaseConstants {
	
	// common definitions
	public static final String COLUMN_IDENTITY = "id";
	public static final String COLUMN_NAME = "name";
	
	// table definitions..
	public static final String TABLE_USERS = "users";
	public static final String COLUMN_FIRST_NAME = "first_name";
	public static final String COLUMN_LAST_NAME = "last_name";
	public static final String COLUMN_EMAIL = "email";
	public static final String COLUMN_PASSWORD = "passwd";
	public static final String COLUMN_ROLE = "role";
	
	public static final String TABLE_STATUSES = "statuses";
	
	public static final String TABLE_RESOLUTIONS = "resolutions";
	
	public static final String TABLE_PRIORITIES = "priorities";
	
	public static final String TABLE_TYPES = "types";
	
	public static final String TABLE_PROJECTS = "projects";
	public static final String COLUMN_DESCRIPTION = "description";
	public static final String COLUMN_MANAGER = "manager";
	
	public static final String TABLE_BUILDS = "builds";
	public static final String COLUMN_PROJECT_IDENTITY = "project_id";
	public static final String COLUMN_VERSION = "version";
	public static final String COLUMN_IS_CURRENT = "is_current";
	public static final String FIELD_PROJECT = "project";
	
	public static final String TABLE_AUDIT = "audit";
	public static final String COLUMN_CREATED_DATE = "created_date";
	public static final String COLUMN_CREATED_BY = "created_by";
	public static final String COLUMN_MODIFIED_DATE = "modified_date";
	public static final String COLUMN_MODIFIED_BY = "modified_by";
	
	public static final String TABLE_ISSUES = "issues";
	public static final String COLUMN_AUDIT = "audit_id";
	public static final String COLUMN_SUMMARY = "summary";
	public static final String COLUMN_STATUS = "status_id";
	public static final String COLUMN_TYPE = "type_id";
	public static final String COLUMN_PRIORITY = "priority_id";
	public static final String COLUMN_BUILD = "build_id";
	public static final String COLUMN_ASSIGNEE = "assignee_id";
	public static final String COLUMN_RESOLUTION = "resolution_id";
	
	public static final String TABLE_COMMENTS = "comments";
	public static final String COLUMN_ADD_DATE = "add_date";
	public static final String COLUMN_ISSUE = "issue_id";
	public static final String COLUMN_ADDED_BY = "added_by";
	public static final String COLUMN_COMMENT = "comment";
	
	public static final String TABLE_ATTACHMENTS = "attachments";
	public static final String COLUMN_FILENAME = "filename";
	
}
