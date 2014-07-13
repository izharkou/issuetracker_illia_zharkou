package com.issuetracker.model.criterias;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.issuetracker.model.constants.CriteriaConstants;
import com.issuetracker.model.domains.Issue;
import com.issuetracker.model.domains.Issue_;

/**
 * Issue search specification.
 * 
 * @author Illia Zharkou
 */
public class IssueCriteria implements Specification<Issue> {
	
	private Issue issue;
	
	/**
	 * Criteria constructor.
	 * 
	 * @param issue
	 */
	public IssueCriteria(Issue issue) {
		this.issue = issue;
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.data.jpa.domain.Specification#toPredicate(javax.persistence.criteria.Root, javax.persistence.criteria.CriteriaQuery, javax.persistence.criteria.CriteriaBuilder)
	 */
	@Override
	public Predicate toPredicate(Root<Issue> root, CriteriaQuery<?> query,
			CriteriaBuilder builder) {
		Predicate criteria = builder.conjunction();
		// search like id
		if (issue.getId() != null) {
			Predicate p = builder.equal(root.get(Issue_.id), issue.getId());
			criteria = builder.and(criteria, p);
		}
		// search like status
		if (issue.getStatus() != null) {
			Predicate p = builder.equal(root.get(Issue_.status), issue.getStatus());
			criteria = builder.and(criteria, p);
		}
		// search like type
		if (issue.getType() != null) {
			Predicate p = builder.equal(root.get(Issue_.type), issue.getType());
			criteria = builder.and(criteria, p);
		}
		// search like priority
		if (issue.getPriority() != null) {
			Predicate p = builder.equal(root.get(Issue_.priority),
					issue.getPriority());
			criteria = builder.and(criteria, p);
		}
		// search like resolution
		if (issue.getResolution() != null) {
			Predicate p = builder.equal(root.get(Issue_.resolution),
					issue.getResolution());
			criteria = builder.and(criteria, p);
		}
		// search like assignee
		if (issue.getAssignee() != null) {
			Predicate p = builder.equal(root.get(Issue_.assignee),
					issue.getAssignee());
			criteria = builder.and(criteria, p);
		}
		// search like build
		if (issue.getBuild() != null) {
			Predicate p = builder.equal(root.get(Issue_.build),
					issue.getBuild());
			criteria = builder.and(criteria, p);
		}
		// search like summary
		if (issue.getSummary() != null) {
			Predicate p = builder.like(root.get(Issue_.summary),
					CriteriaConstants.ANY_SYMBOLS + issue.getSummary() 
						+ CriteriaConstants.ANY_SYMBOLS);
			criteria = builder.and(criteria, p);
		}
		// search like description
		if (issue.getDescription() != null) {
			Predicate p = builder.like(root.get(Issue_.summary),
					CriteriaConstants.ANY_SYMBOLS + issue.getDescription() 
						+ CriteriaConstants.ANY_SYMBOLS);
			criteria = builder.and(criteria, p);
		}
		return criteria;
	}
	
}
