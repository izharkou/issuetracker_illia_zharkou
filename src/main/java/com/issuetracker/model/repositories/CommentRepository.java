package com.issuetracker.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.issuetracker.model.domains.Comment;
import com.issuetracker.model.domains.Issue;

/**
 * Comment repository.
 * 
 * @author Illia Zharkou
 */
public interface CommentRepository extends CrudRepository<Comment, Long> {
	
	/**
	 * Find comments by issue.
	 * 
	 * @param issue
	 * @return
	 */
	public List<Comment> findByIssueOrderByIdAsc(Issue issue);
	
}
