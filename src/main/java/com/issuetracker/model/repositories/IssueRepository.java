package com.issuetracker.model.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.issuetracker.model.domains.Issue;

/**
 * Issue repository.
 * 
 * @author Illia Zharkou
 */
public interface IssueRepository extends
		PagingAndSortingRepository<Issue, Long>,
		JpaSpecificationExecutor<Issue> {}