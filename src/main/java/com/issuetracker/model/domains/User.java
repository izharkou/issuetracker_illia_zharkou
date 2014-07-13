package com.issuetracker.model.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.issuetracker.model.constants.DatabaseConstants;

/**
 * User.
 * 
 * @author Illia Zharkou
 */
@Entity
@Table(name = DatabaseConstants.TABLE_USERS)
public class User implements Serializable {
	
	private static final long serialVersionUID = 4743252410487646408L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = DatabaseConstants.COLUMN_IDENTITY)
	private Long id;
	@Column(name = DatabaseConstants.COLUMN_FIRST_NAME)
	private String firstName;
	@Column(name = DatabaseConstants.COLUMN_LAST_NAME)
	private String lastName;
	@Column(name = DatabaseConstants.COLUMN_EMAIL)
	private String email;
	@Column(name = DatabaseConstants.COLUMN_PASSWORD)
	private String password;
	@Enumerated(EnumType.ORDINAL)
	@Column(name = DatabaseConstants.COLUMN_ROLE)
	private Role role;
	
	/**
	 * @return user id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @param id user id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return user first name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @param firstName user first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * @return user last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * @param lastName user last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * @return user email address
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * @param email user email address
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return user password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * @param password user password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @return user role
	 */
	public Role getRole() {
		return role;
	}
	
	/**
	 * @param role user role
	 */
	public void setRole(Role role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", password=" + password
				+ ", role=" + role + "]";
	}
	
}
