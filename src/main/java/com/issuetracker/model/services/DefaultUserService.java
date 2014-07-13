package com.issuetracker.model.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.issuetracker.model.criterias.UserCriteria;
import com.issuetracker.model.domains.User;
import com.issuetracker.model.repositories.UserRepository;
import com.issuetracker.model.services.interfaces.UserService;
import com.issuetracker.model.services.security.ExtendedUserDetails;

/**
 * Default user service.
 * 
 * @author Illia Zharkou
 */
@Service("userService")
@Repository
@Transactional
public class DefaultUserService implements UserService, UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	/* (non-Javadoc)
	 * @see com.issuetracker.model.services.interfaces.UserService#findById(java.lang.Long)
	 */
	@Transactional(readOnly = true)
	@Override
	public User findById(Long id) {
		return userRepository.findOne(id);
	}
	
	/* (non-Javadoc)
	 * @see com.issuetracker.model.services.interfaces.UserService#findAll()
	 */
	@Transactional(readOnly = true)
	@Override
	public List<User> findAll() {
		return Lists.newArrayList(userRepository.findAll());
	}
	
	/* (non-Javadoc)
	 * @see com.issuetracker.model.services.interfaces.UserService#search(com.issuetracker.model.domains.User)
	 */
	@Transactional(readOnly = true)
	@Override
	public List<User> search(User template) {
		return userRepository.findAll(new UserCriteria(template));
	}
	
	/* (non-Javadoc)
	 * @see com.issuetracker.model.services.interfaces.UserService#getCurrentUser()
	 */
	@Transactional(readOnly = true)
	@Override
	public User getCurrentUser() {
		// get email from authenticated principal
		Authentication auth = SecurityContextHolder.
				getContext().getAuthentication();
        Object principal = auth.getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        // find user by this email
        return userRepository.findByEmail(username);
	}
	
	/* (non-Javadoc)
	 * @see com.issuetracker.model.services.interfaces.UserService#save(com.issuetracker.model.domains.User)
	 */
	@Override
	public User save(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {
		// try to user by email
		User user = userRepository.findByEmail(email);
		// populate list of permissions
		List<GrantedAuthority> authorites = new ArrayList<GrantedAuthority>();
		authorites.add(new SimpleGrantedAuthority(
				user.getRole().toString()));
		// fill extended user details
		return new ExtendedUserDetails(
				user.getEmail(), 
				user.getPassword(), 
				// enabled
				true, 
				// account non expired
				true, 
				// credentials non expired
				true, 
				// account non locked
				true, 
				authorites,
				// first name
				user.getFirstName(),
				// last name
				user.getLastName());
	}
	
}
