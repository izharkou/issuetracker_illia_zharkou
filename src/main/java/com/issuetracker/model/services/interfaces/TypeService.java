package com.issuetracker.model.services.interfaces;

import java.util.List;

import com.issuetracker.model.domains.Type;

/**
 * Type service.
 * 
 * @author Illia Zharkou
 */
public interface TypeService {
	
	/**
	 * Find type by id.
	 * 
	 * @param id
	 * @return
	 */
	public Type findById(Long id);
	
	/**
	 * Find all types.
	 * 
	 * @return list of types
	 */
	public List<Type> findAll();
	
	/**
	 * Save type.
	 * 
	 * @param type
	 * @return
	 */
	public Type save(Type type);
	
}
