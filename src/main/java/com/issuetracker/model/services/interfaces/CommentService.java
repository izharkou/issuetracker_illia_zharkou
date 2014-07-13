package com.issuetracker.model.services.interfaces;

import java.util.List;

import com.issuetracker.model.domains.Comment;
import com.issuetracker.model.domains.Issue;

/**
 * Comment service.
 * 
 * @author Illia Zharkou
 */
public interface CommentService {
	
	/**
	 * Find comments by issue id.
	 * 
	 * @param issue
	 * @return
	 */
	public List<Comment> findByIssue(Issue issue);
	
	/**
	 * Save comment.
	 * 
	 * @return
	 */
	public Comment save(Comment comment);
	
}
