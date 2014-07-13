package com.issuetracker.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.issuetracker.model.domains.Status;

/**
 * Status repository.
 * 
 * @author Illia Zharkou
 */
public interface StatusRepository extends CrudRepository<Status, Long> {}
