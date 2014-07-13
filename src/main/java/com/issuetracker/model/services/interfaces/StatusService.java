package com.issuetracker.model.services.interfaces;

import java.util.List;

import com.issuetracker.model.domains.Status;

/**
 * Status interface.
 * 
 * @author Illia Zharkou
 */
public interface StatusService {
	
	/**
	 * Find status by id.
	 * 
	 * @param id
	 * @return
	 */
	public Status findById(Long id);
	
	/**
	 * Find all statuses.
	 * 
	 * @return
	 */
	public List<Status> findAll();
	
	/**
	 * Save status.
	 * 
	 * @param status
	 * @return
	 */
	public Status save(Status status);
	
}
