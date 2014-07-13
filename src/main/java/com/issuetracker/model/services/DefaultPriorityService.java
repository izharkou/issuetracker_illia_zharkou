package com.issuetracker.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.issuetracker.model.domains.Priority;
import com.issuetracker.model.repositories.PriorityRepository;
import com.issuetracker.model.services.interfaces.PriorityService;

/**
 * Default priority service.
 * 
 * @author Illia Zharkou
 */
@Service("priorityService")
@Repository
@Transactional
public class DefaultPriorityService implements PriorityService {
	
	@Autowired
	private PriorityRepository priorityRepository;
	
	/* (non-Javadoc)
	 * @see com.issuetracker.model.services.interfaces.PriorityService#findById(java.lang.Long)
	 */
	@Transactional(readOnly = true)
	@Override
	public Priority findById(Long id) {
		return priorityRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see com.issuetracker.model.services.interfaces.PriorityService#findAll()
	 */
	@Transactional(readOnly = true)
	@Override
	public List<Priority> findAll() {
		return Lists.newArrayList(priorityRepository.findAll());
	}

	/* (non-Javadoc)
	 * @see com.issuetracker.model.services.interfaces.PriorityService#save(com.issuetracker.model.domains.Priority)
	 */
	@Override
	public Priority save(Priority resolution) {
		return priorityRepository.save(resolution);
	}

}
