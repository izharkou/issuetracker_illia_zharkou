package com.issuetracker.model.services.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.issuetracker.model.domains.Issue;

/**
 * Issue service.
 * 
 * @author Illia Zharkou
 */
public interface IssueService {
	
	/**
	 * Find issue by id.
	 * 
	 * @param id
	 * @return
	 */
	public Issue findById(Long id);
	
	/**
	 * Find all issues.
	 * 
	 * @return
	 */
	public List<Issue> findAll();
	
	/**
	 * Find all issues by page.
	 * 
	 * @param pageable
	 * @return
	 */
	public Page<Issue> findAllByPage(Pageable pageable);
	
	/**
	 * Search issues.
	 * 
	 * @param template
	 * @return
	 */
	public List<Issue> findAll(Issue template);
	
	/**
	 * Save issue.
	 * 
	 * @param issue
	 * @return
	 */
	public Issue save(Issue issue);
	
}
