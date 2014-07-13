package com.issuetracker.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.issuetracker.model.constants.QueryConstants;
import com.issuetracker.model.domains.Audit;

/**
 * Audit repository.
 * 
 * @author Illia Zharkou
 */
public interface AuditRepository extends CrudRepository<Audit, Long> {
	
	/**
	 * Find audit info by issue id.
	 * 
	 * @param issue
	 * @return
	 */
	@Query(QueryConstants.FIND_AUDIT_BY_ISSUE_ID)
	public Audit findAuditByIssueId(Long id);
	
}