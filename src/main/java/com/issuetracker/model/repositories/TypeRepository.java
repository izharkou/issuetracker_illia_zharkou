package com.issuetracker.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.issuetracker.model.domains.Type;

/**
 * Type repository.
 * 
 * @author Illia Zharkou
 */
public interface TypeRepository extends CrudRepository<Type, Long> {}