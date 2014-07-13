package com.issuetracker.model.services.interfaces;

import com.issuetracker.model.domains.Build;

/**
 * Build service.
 * 
 * @author Illia Zharkou
 */
public interface BuildService {
	
	/**
	 * Save build.
	 * 
	 * @param build
	 * @return
	 */
	public Build save(Build build);
	
}
