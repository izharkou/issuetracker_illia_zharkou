package com.issuetracker.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.issuetracker.model.domains.Attachment;
import com.issuetracker.model.domains.Issue;
import com.issuetracker.model.repositories.AttachmentRepository;
import com.issuetracker.model.services.interfaces.AttachmentService;

/**
 * Default attachment service.
 * 
 * @author Illia Zharkou
 */
@Service("attachmentService")
@Repository
@Transactional
public class DefaultAttachmentService implements AttachmentService {
	
	@Autowired
	private AttachmentRepository attachmentRepository;
	
	/* (non-Javadoc)
	 * @see com.issuetracker.model.services.interfaces.AttachmentService#findByIssue(com.issuetracker.model.domains.Issue)
	 */
	@Transactional(readOnly = true)
	@Override
	public List<Attachment> findByIssue(Issue issue) {
		return attachmentRepository.findByIssueOrderByIdAsc(issue);
	}
	
	/* (non-Javadoc)
	 * @see com.issuetracker.model.services.interfaces.AttachmentService#save(com.issuetracker.model.domains.Attachment)
	 */
	@Override
	public Attachment save(Attachment attachment) {
		return attachmentRepository.save(attachment);
	}
	
}
