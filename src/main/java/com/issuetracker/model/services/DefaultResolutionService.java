package com.issuetracker.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.issuetracker.model.domains.Resolution;
import com.issuetracker.model.repositories.ResolutionRepository;
import com.issuetracker.model.services.interfaces.ResolutionService;

/**
 * Default resolution service.
 * 
 * @author Illia Zharkou
 */
@Service("repositoryService")
@Repository
@Transactional
public class DefaultResolutionService implements ResolutionService {
	
	@Autowired
	private ResolutionRepository resolutionRepository;
	
	/* (non-Javadoc)
	 * @see com.issuetracker.model.services.interfaces.ResolutionService#findById(java.lang.Long)
	 */
	@Transactional(readOnly = true)
	@Override
	public Resolution findById(Long id) {
		return resolutionRepository.findOne(id);
	}
	
	/* (non-Javadoc)
	 * @see com.issuetracker.model.services.interfaces.ResolutionService#findAll()
	 */
	@Transactional(readOnly = true)
	@Override
	public List<Resolution> findAll() {
		return Lists.newArrayList(resolutionRepository.findAll());
	}
	
	/* (non-Javadoc)
	 * @see com.issuetracker.model.services.interfaces.ResolutionService#save(com.issuetracker.model.domains.Resolution)
	 */
	@Override
	public Resolution save(Resolution resolution) {
		return resolutionRepository.save(resolution);
	}
	
}
