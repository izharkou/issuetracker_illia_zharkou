package com.issuetracker.model.services.interfaces;

import java.util.List;

import com.issuetracker.model.domains.Resolution;

/**
 * Resolution service.
 * 
 * @author Illia Zharkou
 */
public interface ResolutionService {
	
	/**
	 * Find resolution by id.
	 * 
	 * @param id
	 * @return
	 */
	public Resolution findById(Long id);
	
	/**
	 * Find all resolutions.
	 * 
	 * @return list of resolutions
	 */
	public List<Resolution> findAll();
	
	/**
	 * Save resolution.
	 * 
	 * @param resolution
	 * @return
	 */
	public Resolution save(Resolution resolution);
	
}
