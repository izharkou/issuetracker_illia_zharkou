package com.issuetracker.model.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.issuetracker.model.domains.User;

/**
 * User repository.
 * 
 * @author Illia Zharkou
 */
public interface UserRepository extends CrudRepository<User, Long>, 
		JpaSpecificationExecutor<User> {
	
	/**
	 * Find user by his email.
	 * 
	 * @param email
	 * @return user
	 */
	public User findByEmail(String email);
	
}
