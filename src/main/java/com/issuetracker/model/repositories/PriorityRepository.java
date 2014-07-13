package com.issuetracker.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.issuetracker.model.domains.Priority;

/**
 * Priority repository.
 * 
 * @author Illia Zharkou
 */
public interface PriorityRepository extends CrudRepository<Priority, Long> {}