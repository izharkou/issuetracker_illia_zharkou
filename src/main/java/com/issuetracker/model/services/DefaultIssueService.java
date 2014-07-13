package com.issuetracker.model.services;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.issuetracker.model.criterias.IssueCriteria;
import com.issuetracker.model.domains.Audit;
import com.issuetracker.model.domains.Issue;
import com.issuetracker.model.domains.User;
import com.issuetracker.model.repositories.AuditRepository;
import com.issuetracker.model.repositories.IssueRepository;
import com.issuetracker.model.services.interfaces.IssueService;
import com.issuetracker.model.services.interfaces.UserService;

/**
 * Default issue service.
 * 
 * @author Illia Zharkou
 */
@Service("issueService")
@Repository
@Transactional
public class DefaultIssueService implements IssueService {
	
	@Autowired
	private IssueRepository issueRepository;
	@Autowired
	private AuditRepository auditRepository;
	@Autowired
	private UserService userService;
	
	/* (non-Javadoc)
	 * @see com.issuetracker.model.services.interfaces.IssueService#findById(java.lang.Long)
	 */
	@Transactional(readOnly = true)
	@Override
	public Issue findById(Long id) {
		return issueRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see com.issuetracker.model.services.interfaces.IssueService#findAll()
	 */
	@Transactional(readOnly = true)
	@Override
	public List<Issue> findAll() {
		return Lists.newArrayList(issueRepository.findAll());
	}

	/* (non-Javadoc)
	 * @see com.issuetracker.model.services.interfaces.IssueService#findAllByPage(org.springframework.data.domain.Pageable)
	 */
	@Transactional(readOnly = true)
	@Override
	public Page<Issue> findAllByPage(Pageable pageable) {
		return issueRepository.findAll(pageable);
	}
	
	/* (non-Javadoc)
	 * @see com.issuetracker.model.services.interfaces.IssueService#findAll(com.issuetracker.model.domains.Issue)
	 */
	@Transactional(readOnly = true)
	@Override
	public List<Issue> findAll(Issue template) {
		return issueRepository.findAll(new IssueCriteria(template));
	}
	
	/* (non-Javadoc)
	 * @see com.issuetracker.model.services.interfaces.IssueService#save(com.issuetracker.model.domains.Issue)
	 */
	@Override
	public Issue save(Issue issue) {
		// get current user and audit info
		User user = userService.getCurrentUser();
		Audit audit = auditRepository.findAuditByIssueId(issue.getId());
		DateTime now = new DateTime(System.currentTimeMillis());
		// if issue is new
		if(audit == null) {
			audit = new Audit();
			audit.setCreatedBy(user);
			audit.setCreatedDate(now);
		}
		// update who modified
		audit.setModifyedBy(user);
		audit.setModifiedDate(now);
		audit = auditRepository.save(audit);
		// update
		issue.setAudit(audit);
		return issueRepository.save(issue);
	}
	
}
