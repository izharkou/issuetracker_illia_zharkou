package com.issuetracker.model.services.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.issuetracker.model.domains.Project;

/**
 * Project service.
 * 
 * @author Illia Zharkou
 */
public interface ProjectService {
	
	/**
	 * Find project by id.
	 * 
	 * @param id
	 * @return
	 */
	public Project findById(Long id);
	
	/**
	 * Find all projects.
	 * 
	 * @return
	 */
	public List<Project> findAll();
	
	/**
	 * Find all projects on certain page.
	 * 
	 * @param pageable
	 * @return
	 */
	public Page<Project> findAllByPage(Pageable pageable);
	
	/**
	 * Save project.
	 * 
	 * @param project
	 * @return
	 */
	public Project save(Project project);
	
}
