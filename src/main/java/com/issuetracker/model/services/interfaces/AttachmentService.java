package com.issuetracker.model.services.interfaces;

import java.util.List;

import com.issuetracker.model.domains.Attachment;
import com.issuetracker.model.domains.Issue;

/**
 * Attachment service.
 * 
 * @author Illia Zharkou
 */
public interface AttachmentService {
	
	/**
	 * Find list of attachments for issue.
	 * 
	 * @param issue
	 * @return
	 */
	public List<Attachment> findByIssue(Issue issue);
	
	/**
	 * Save attachment.
	 * 
	 * @param attachment
	 * @return
	 */
	public Attachment save(Attachment attachment);
	
}
