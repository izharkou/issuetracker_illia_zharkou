package com.issuetracker.model.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.issuetracker.model.domains.Project;

/**
 * Project repository.
 * 
 * @author Illia Zharkou
 */
public interface ProjectRepository extends
		PagingAndSortingRepository<Project, Long> {}