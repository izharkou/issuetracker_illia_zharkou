package com.issuetracker.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.issuetracker.model.domains.Status;
import com.issuetracker.model.repositories.StatusRepository;
import com.issuetracker.model.services.interfaces.StatusService;

/**
 * Default status service.
 * 
 * @author Illia Zharkou
 */
@Service("statusService")
@Repository
@Transactional
public class DefaultStatusService implements StatusService {
	
	@Autowired
	private StatusRepository statusRepository;
	
	/* (non-Javadoc)
	 * @see com.issuetracker.model.services.interfaces.StatusService#findById(java.lang.Long)
	 */
	@Transactional(readOnly = true)
	@Override
	public Status findById(Long id) {
		return statusRepository.findOne(id);
	}
	
	/* (non-Javadoc)
	 * @see com.issuetracker.model.services.interfaces.StatusService#findAll()
	 */
	@Transactional(readOnly = true)
	@Override
	public List<Status> findAll() {
		return Lists.newArrayList(statusRepository.findAll());
	}
	
	/* (non-Javadoc)
	 * @see com.issuetracker.model.services.interfaces.StatusService#save(com.issuetracker.model.domains.Status)
	 */
	@Override
	public Status save(Status status) {
		return statusRepository.save(status);
	}
	
}
