package com.issuetracker.model.domains;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

import com.issuetracker.model.constants.DatabaseConstants;
import com.issuetracker.model.constants.GeneralConstants;

/**
 * Project.
 * 
 * @author Illia Zharkou
 */
@Entity
@Table(name = DatabaseConstants.TABLE_PROJECTS)
public class Project implements Serializable {
	
	private static final long serialVersionUID = -1619666917082130563L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = DatabaseConstants.COLUMN_IDENTITY)
	private Long id;
	@Column(name = DatabaseConstants.COLUMN_NAME)
	private String name;
	@Column(name = DatabaseConstants.COLUMN_DESCRIPTION)
	private String description;
	@ManyToOne
	@JoinColumn(name = DatabaseConstants.COLUMN_MANAGER)
	private User manager;
	@OneToMany(mappedBy = DatabaseConstants.FIELD_PROJECT, fetch = FetchType.LAZY)
	private Set<Build> builds;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @return the manager
	 */
	public User getManager() {
		return manager;
	}
	
	/**
	 * @param manager the manager to set
	 */
	public void setManager(User manager) {
		this.manager = manager;
	}
	
	/**
	 * @return the builds
	 */
	public Set<Build> getBuilds() {
		return builds;
	}

	/**
	 * @param builds the builds to set
	 */
	public void setBuilds(Set<Build> builds) {
		this.builds = builds;
	}
	
	/**
	 * @return short project description
	 */
	@Transient
	public String getShortDescription() {
		if(this.description == null) {
			return null;
		}
		else if(this.description.length() <= GeneralConstants.DESCRIPTION_MAX_LENGTH) {
			return this.description;
		} else {
			// cut description and add three dots
			StringBuilder sb = new StringBuilder(this.description.substring(0, 
					GeneralConstants.DESCRIPTION_MAX_LENGTH - GeneralConstants.THREE_DOTS.length()));
			sb.append(GeneralConstants.THREE_DOTS);
			return sb.toString();
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", description="
				+ description + ", manager=" + manager + ", builds=" + builds
				+ "]";
	}
	
}
