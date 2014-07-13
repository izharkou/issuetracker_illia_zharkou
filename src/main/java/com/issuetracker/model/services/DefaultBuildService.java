package com.issuetracker.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.issuetracker.model.domains.Build;
import com.issuetracker.model.repositories.BuildRepository;
import com.issuetracker.model.services.interfaces.BuildService;

/**
 * Default build service.
 * 
 * @author Illia Zharkou
 */
@Service("buildService")
@Repository
@Transactional
public class DefaultBuildService implements BuildService {
	
	@Autowired
	private BuildRepository buildRepository;
	
	/* (non-Javadoc)
	 * @see com.issuetracker.model.services.interfaces.BuildService#save(com.issuetracker.model.domains.Build)
	 */
	@Override
	public Build save(Build build) {
		return buildRepository.save(build);
	}

}
