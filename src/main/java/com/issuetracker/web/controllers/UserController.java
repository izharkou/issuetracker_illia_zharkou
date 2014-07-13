package com.issuetracker.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.issuetracker.model.domains.User;
import com.issuetracker.model.services.interfaces.UserService;
import com.issuetracker.web.constants.AttributeConstants;
import com.issuetracker.web.constants.MappingConstants;
import com.issuetracker.web.constants.ViewConstants;

/**
 * User controller.
 * 
 * @author Illia Zharkou
 */
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * Error login page.
	 * 
	 * @return
	 */
	@RequestMapping(value = MappingConstants.URL_USER_AUTH_FAILED, method = RequestMethod.GET)
	public String loginFailed() {
		return ViewConstants.AUTH_FAILED;
	}
	
	/**
	 * View user profile.
	 * 
	 * @return
	 */
	@RequestMapping(value = MappingConstants.URL_USER_VIEW, method = RequestMethod.GET)
	public String userView(@PathVariable(MappingConstants.PARAM_ID) User user,
			ModelMap model) {
		model.addAttribute(AttributeConstants.USER_ATTRIBUTE, user);
		return ViewConstants.USER_VIEW;
	}
	
//////////////////////////////////////////////////////////////////////////
	
	/**
	 * User search form.
	 * 
	 * @return
	 */
	@RequestMapping(value = MappingConstants.URL_USER_SEARCH, method = RequestMethod.GET)
	public String userSearchGet() {
		return ViewConstants.USER_SEARCH;
	}
	
	/**
	 * User search.
	 * 
	 * @return
	 */
	@RequestMapping(value = MappingConstants.URL_USER_SEARCH, method = RequestMethod.POST)
	public @ResponseBody List<User> userSearchPost(@RequestBody User user) {
		System.out.println("\n\n" + user + "\n\n");
		return userService.search(user);
	}
	
//////////////////////////////////////////////////////////////////////////
	
	/**
	 * Edit self info form.
	 * 
	 * @return
	 */
	@PreAuthorize(MappingConstants.ACCESS_ANY_AUTHORIZED)
	@RequestMapping(value = MappingConstants.URL_USER_EDIT, method = RequestMethod.GET)
	public String editSelf(ModelMap model) {
		User user = userService.getCurrentUser();
		model.addAttribute(AttributeConstants.USER_ATTRIBUTE, user);
		return ViewConstants.USER_EDIT;
	}
	
	/**
	 * Update current user info.
	 * 
	 * @param user
	 * @return
	 */
	@PreAuthorize(MappingConstants.ACCESS_ANY_AUTHORIZED)
	@RequestMapping(value = MappingConstants.URL_USER_EDIT, method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void saveInfo(@RequestBody User user) {
		// load current user and replace required fields for him
		User currentUser = userService.getCurrentUser();
		currentUser.setFirstName(user.getFirstName());
		currentUser.setLastName(user.getLastName());
		currentUser.setEmail(user.getEmail());
		// update user info
		userService.save(currentUser);
	}

//////////////////////////////////////////////////////////////////////////

	/**
	 * Edit self password form.
	 * 
	 * @return
	 */
	@PreAuthorize(MappingConstants.ACCESS_ANY_AUTHORIZED)
	@RequestMapping(value = MappingConstants.URL_USER_EDIT_PASSWD, method = RequestMethod.GET)
	public String editSelfPassword(ModelMap model) {
		return ViewConstants.USER_EDIT_PASSWD;
	}

	/**
	 * Update current user password.
	 * 
	 * @param user
	 * @return
	 */
	@PreAuthorize(MappingConstants.ACCESS_ANY_AUTHORIZED)
	@RequestMapping(value = MappingConstants.URL_USER_EDIT_PASSWD, method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void savePassword(@RequestBody User user) {
		// load current user and replace password for him
		User currentUser = userService.getCurrentUser();
		currentUser.setPassword(user.getPassword());
		// update user info
		userService.save(currentUser);
	}
	
//////////////////////////////////////////////////////////////////////////
	
	/**
	 * Add new user form.
	 * Access only for administrator.
	 * 
	 * @return
	 */
	@PreAuthorize(MappingConstants.ACCESS_ONLY_ADMIN)
	@RequestMapping(value = MappingConstants.URL_USER_ADD, method = RequestMethod.GET)
	public String addUserGet() {
		return ViewConstants.USER_ADD;
	}
	
	/**
	 * Add new user.
	 * Access only for administrator.
	 * 
	 * @return
	 */
	@PreAuthorize(MappingConstants.ACCESS_ONLY_ADMIN)
	@RequestMapping(value = MappingConstants.URL_USER_ADD, method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void addUserPost(@RequestBody User user) {
		userService.save(user);
	}
	
//////////////////////////////////////////////////////////////////////////
	
	/**
	 * Edit user info.
	 * Access only for administrator.
	 * 
	 * @return
	 */
	@PreAuthorize(MappingConstants.ACCESS_ONLY_ADMIN)
	@RequestMapping(value = MappingConstants.URL_USER_EDIT_ID, method = RequestMethod.GET)
	public String editUser(@PathVariable(MappingConstants.PARAM_ID) User user,
			ModelMap model) {
		model.addAttribute(AttributeConstants.USER_ATTRIBUTE, user);
		return ViewConstants.USER_EDIT_ID;
	}
	
	/**
	 * Update any existing user.
	 * Access only for administrator.
	 * 
	 * @param user
	 * @return
	 */
	@PreAuthorize(MappingConstants.ACCESS_ONLY_ADMIN)
	@RequestMapping(value = MappingConstants.URL_USER_EDIT_ID, method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void saveInfoByAdmin(@RequestBody User user) {
		// we need to load user password before updating
		User tmpUser = userService.findById(user.getId());
		user.setPassword(tmpUser.getPassword());
		// update user
		userService.save(user);
	}
	
//////////////////////////////////////////////////////////////////////////
	
	/**
	 * Edit user's password form.
	 * Access only for administrator.
	 * 
	 * @return
	 */
	@PreAuthorize(MappingConstants.ACCESS_ONLY_ADMIN)
	@RequestMapping(value = MappingConstants.URL_USER_EDIT_ID_PASSWD, method = RequestMethod.GET)
	public String editUsersPasswordGet(@PathVariable(MappingConstants.PARAM_ID) User user, 
			ModelMap model) {
		model.addAttribute(AttributeConstants.USER_ATTRIBUTE, user);
		return ViewConstants.USER_EDIT_ID_PASSWD;
	}
	
	/**
	 * Update some user's password.
	 * Access only for administrator.
	 * 
	 * @param user
	 * @return
	 */
	@PreAuthorize(MappingConstants.ACCESS_ANY_AUTHORIZED)
	@RequestMapping(value = MappingConstants.URL_USER_EDIT_ID_PASSWD, method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void editUsersPasswordPost(@RequestBody User user) {
		// load user and replace password for him
		User tmpUser = userService.findById(user.getId());
		tmpUser.setPassword(user.getPassword());
		// update user info
		userService.save(tmpUser);
	}
	
}
