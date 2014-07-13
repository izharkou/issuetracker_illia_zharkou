package com.issuetracker.model.constants;

/**
 * Queries.
 * 
 * @author Illia Zharkou
 */
public class QueryConstants {
	
	public final static String RESET_CURRENT_BUILD = 
			"update Build b set b.current = false where b.project = ?1";
	public final static String FIND_AUDIT_BY_ISSUE_ID =
			"select i.audit from Issue i where i.id = ?1";
}