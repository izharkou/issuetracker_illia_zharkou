package com.issuetracker.model.services.interfaces;

import java.util.List;

import com.issuetracker.model.domains.Priority;

/**
 * Priority service.
 * 
 * @author Illia Zharkou
 */
public interface PriorityService {
	
	/**
	 * Find priority by id.
	 * 
	 * @param id
	 * @return
	 */
	public Priority findById(Long id);
	
	/**
	 * Find all priorities.
	 * 
	 * @return list of priorities
	 */
	public List<Priority> findAll();
	
	/**
	 * Save priority.
	 * 
	 * @param priority
	 * @return
	 */
	public Priority save(Priority resolution);
	
}
