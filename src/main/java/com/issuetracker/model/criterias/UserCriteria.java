package com.issuetracker.model.criterias;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.issuetracker.model.constants.CriteriaConstants;
import com.issuetracker.model.domains.User;
import com.issuetracker.model.domains.User_;

/**
 * User search specification.
 * 
 * @author Illia Zharkou
 */
public class UserCriteria implements Specification<User> {
	
	private User user;
	
	/**
	 * Criteria constructor.
	 * 
	 * @param user
	 */
	public UserCriteria(User user) {
		this.user = user;
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.data.jpa.domain.Specification#toPredicate(javax.persistence.criteria.Root, javax.persistence.criteria.CriteriaQuery, javax.persistence.criteria.CriteriaBuilder)
	 */
	@Override
	public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query,
			CriteriaBuilder builder) {
		Predicate criteria = builder.conjunction();
		// search like first name
		if (user.getFirstName() != null) {
			Predicate p = builder.like(root.get(User_.firstName), 
				CriteriaConstants.ANY_SYMBOLS + user.getFirstName() +
				CriteriaConstants.ANY_SYMBOLS);
			criteria = builder.and(criteria, p);
		}
		// search like last name
		if (user.getLastName() != null) {
			Predicate p = builder.like(root.get(User_.lastName), 
				CriteriaConstants.ANY_SYMBOLS + user.getLastName() +
				CriteriaConstants.ANY_SYMBOLS);
			criteria = builder.and(criteria, p);
		}
		// search like email
		if (user.getEmail() != null) {
			Predicate p = builder.like(root.get(User_.email), 
				CriteriaConstants.ANY_SYMBOLS + user.getEmail() +
				CriteriaConstants.ANY_SYMBOLS);
			criteria = builder.and(criteria, p);
		}
		// search like role
		if (user.getRole() != null) {
			Predicate p = builder.equal(root.get(User_.role), user.getRole());
			criteria = builder.and(criteria, p);
		}
		return criteria;
	}
	
}
