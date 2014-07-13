package com.issuetracker.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.issuetracker.model.domains.Attachment;
import com.issuetracker.model.domains.Issue;

/**
 * Attachment repository.
 * 
 * @author Illia Zharkou
 */
public interface AttachmentRepository extends CrudRepository<Attachment, Long> {
	
	/**
	 * Find list of attachments for issue.
	 * 
	 * @param issue
	 * @return
	 */
	public List<Attachment> findByIssueOrderByIdAsc(Issue issue);
	
}
