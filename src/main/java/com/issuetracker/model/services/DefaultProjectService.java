package com.issuetracker.model.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.issuetracker.model.domains.Build;
import com.issuetracker.model.domains.Project;
import com.issuetracker.model.repositories.BuildRepository;
import com.issuetracker.model.repositories.ProjectRepository;
import com.issuetracker.model.services.interfaces.ProjectService;

/**
 * Default project service.
 * 
 * @author Illia Zharkou
 */
@Service("projectService")
@Repository
@Transactional
public class DefaultProjectService implements ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private BuildRepository buildRepository;
	
	/* (non-Javadoc)
	 * @see com.issuetracker.model.services.interfaces.ProjectService#findById(java.lang.Long)
	 */
	@Transactional(readOnly = true)
	@Override
	public Project findById(Long id) {
		return projectRepository.findOne(id);
	}
	
	/* (non-Javadoc)
	 * @see com.issuetracker.model.services.interfaces.ProjectService#findAll()
	 */
	@Transactional(readOnly = true)
	@Override
	public List<Project> findAll() {
		return Lists.newArrayList(projectRepository.findAll());
	}
	
	/* (non-Javadoc)
	 * @see com.issuetracker.model.services.interfaces.ProjectService#findAllByPage(org.springframework.data.domain.Pageable)
	 */
	@Transactional(readOnly = true)
	@Override
	public Page<Project> findAllByPage(Pageable pageable) {
		return projectRepository.findAll(pageable);
	}
	
	/* (non-Javadoc)
	 * @see com.issuetracker.model.services.interfaces.ProjectService#save(com.issuetracker.model.domains.Project)
	 */
	@Override
	public Project save(Project project) {
		Project updated = projectRepository.save(project);
		// set "current" field to false in builds
		buildRepository.resetCurrentBuild(updated);
		// find new current build in project
		Set<Build> builds = project.getBuilds();
		for(Build build : builds) {
			// update him if he is current
			if(build.isCurrent()) {
				build.setProject(updated);
				buildRepository.save(build);
				break;
			}
		}
		return updated;
	}
	
}
