package com.issuetracker.model.services.interfaces;

import java.util.List;

import com.issuetracker.model.domains.User;

/**
 * 
 * @author Illia Zharkou
 */
public interface UserService {
	
	/**
	 * Find user by id.
	 * 
	 * @param id
	 * @return
	 */
	public User findById(Long id);
	
	/**
	 * Find all users.
	 * 
	 * @return list of users
	 */
	public List<User> findAll();
	
	/**
	 * Search users.
	 * 
	 * @return list of users
	 */
	public List<User> search(User template);
	
	/**
	 * Get current authenticated user.
	 * 
	 * @return
	 */
	public User getCurrentUser();
	
	/**
	 * Save user.
	 * 
	 * @param user
	 * @return
	 */
	public User save(User user);
	
}
