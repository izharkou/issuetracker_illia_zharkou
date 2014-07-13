package com.issuetracker.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.issuetracker.model.domains.Resolution;

/**
 * Resolution repository.
 * 
 * @author Illia Zharkou
 */
public interface ResolutionRepository extends CrudRepository<Resolution, Long> {}
