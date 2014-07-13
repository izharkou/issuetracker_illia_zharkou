package com.issuetracker.model.domains;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Metamodel for User class.
 * 
 * @author Illia Zharkou
 */
@StaticMetamodel(User.class)
public abstract class User_ {
	
	public static volatile SingularAttribute<User, Long> id;
	public static volatile SingularAttribute<User, String> firstName;
	public static volatile SingularAttribute<User, String> lastName;
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, Role> role;
	
}
