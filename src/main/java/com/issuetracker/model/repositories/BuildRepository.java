package com.issuetracker.model.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.issuetracker.model.constants.QueryConstants;
import com.issuetracker.model.domains.Build;
import com.issuetracker.model.domains.Project;

/**
 * Build repository.
 * 
 * @author Illia Zharkou
 */
public interface BuildRepository extends CrudRepository<Build, Long> {
	
	/**
	 * Reset current project build.
	 * 
	 * @param project
	 */
	@Modifying
	@Query(QueryConstants.RESET_CURRENT_BUILD)
	public void resetCurrentBuild(Project project);
	
}
