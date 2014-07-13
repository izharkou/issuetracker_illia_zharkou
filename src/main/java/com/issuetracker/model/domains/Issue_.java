package com.issuetracker.model.domains;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Metamodel for Issue class.
 * 
 * @author Illia Zharkou
 */
@StaticMetamodel(Issue.class)
public abstract class Issue_ {
	
	public static volatile SingularAttribute<Issue, Long> id;
	public static volatile SingularAttribute<Issue, Audit> audit;
	public static volatile SingularAttribute<Issue, String> summary;
	public static volatile SingularAttribute<Issue, String> description;
	public static volatile SingularAttribute<Issue, Status> status;
	public static volatile SingularAttribute<Issue, Type> type;
	public static volatile SingularAttribute<Issue, Priority> priority;
	public static volatile SingularAttribute<Issue, Build> build;
	public static volatile SingularAttribute<Issue, User> assignee;
	public static volatile SingularAttribute<Issue, Resolution> resolution;
	
}
