package com.issuetracker.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.issuetracker.model.domains.Type;
import com.issuetracker.model.repositories.TypeRepository;
import com.issuetracker.model.services.interfaces.TypeService;

/**
 * Default type service.
 * 
 * @author Illia Zharkou
 */
@Service("typeService")
@Repository
@Transactional
public class DefaultTypeService implements TypeService {
	
	@Autowired
	private TypeRepository typeRepository;
	
	/* (non-Javadoc)
	 * @see com.issuetracker.model.services.interfaces.TypeService#findById(java.lang.Long)
	 */
	@Transactional(readOnly = true)
	@Override
	public Type findById(Long id) {
		return typeRepository.findOne(id);
	}
	
	/* (non-Javadoc)
	 * @see com.issuetracker.model.services.interfaces.TypeService#findAll()
	 */
	@Transactional(readOnly = true)
	@Override
	public List<Type> findAll() {
		return Lists.newArrayList(typeRepository.findAll());
	}
	
	/* (non-Javadoc)
	 * @see com.issuetracker.model.services.interfaces.TypeService#save(com.issuetracker.model.domains.Type)
	 */
	@Override
	public Type save(Type type) {
		return typeRepository.save(type);
	}
	
}
