package com.issuetracker.model.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

import com.issuetracker.model.constants.DatabaseConstants;
import com.issuetracker.model.constants.GeneralConstants;

/**
 * Issue.
 * 
 * @author Illia Zharkou
 */
@Entity
@Table(name = DatabaseConstants.TABLE_ISSUES)
public class Issue implements Serializable {
	
	private static final long serialVersionUID = 7077492328891308487L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	@JoinColumn(name = DatabaseConstants.COLUMN_AUDIT)
	private Audit audit;
	@Column(name = DatabaseConstants.COLUMN_SUMMARY)
	private String summary;
	@Column(name = DatabaseConstants.COLUMN_DESCRIPTION)
	private String description;
	@ManyToOne
	@JoinColumn(name = DatabaseConstants.COLUMN_STATUS)
	private Status status;
	@ManyToOne
	@JoinColumn(name = DatabaseConstants.COLUMN_TYPE)
	private Type type;
	@ManyToOne
	@JoinColumn(name = DatabaseConstants.COLUMN_PRIORITY)
	private Priority priority;
	@ManyToOne
	@JoinColumn(name = DatabaseConstants.COLUMN_BUILD)
	private Build build;
	@ManyToOne
	@JoinColumn(name = DatabaseConstants.COLUMN_ASSIGNEE)
	private User assignee;
	@ManyToOne
	@JoinColumn(name = DatabaseConstants.COLUMN_RESOLUTION)
	private Resolution resolution;
	
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
	 * @return the audit
	 */
	public Audit getAudit() {
		return audit;
	}
	
	/**
	 * @param audit the audit to set
	 */
	public void setAudit(Audit audit) {
		this.audit = audit;
	}
	
	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}
	
	/**
	 * @param summary the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
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
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}
	
	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	
	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}
	
	/**
	 * @param type the type to set
	 */
	public void setType(Type type) {
		this.type = type;
	}
	
	/**
	 * @return the priority
	 */
	public Priority getPriority() {
		return priority;
	}
	
	/**
	 * @param priority the priority to set
	 */
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	
	/**
	 * @return the build
	 */
	public Build getBuild() {
		return build;
	}
	
	/**
	 * @param build the build to set
	 */
	public void setBuild(Build build) {
		this.build = build;
	}
	
	/**
	 * @return the assignee
	 */
	public User getAssignee() {
		return assignee;
	}
	
	/**
	 * @param assignee the assignee to set
	 */
	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}
	
	/**
	 * @return the resolution
	 */
	public Resolution getResolution() {
		return resolution;
	}
	
	/**
	 * @param resolution the resolution to set
	 */
	public void setResolution(Resolution resolution) {
		this.resolution = resolution;
	}
	
	/**
	 * @return short summary
	 */
	@Transient
	public String getShortSummary() {
		if(this.summary == null) {
			return null;
		}
		else if(this.summary.length() <= GeneralConstants.SUMMARY_MAX_LENGTH) {
			return this.summary;
		} else {
			// cut summary and add three dots
			StringBuilder sb = new StringBuilder(this.summary.substring(0, 
					GeneralConstants.SUMMARY_MAX_LENGTH - GeneralConstants.THREE_DOTS.length()));
			sb.append(GeneralConstants.THREE_DOTS);
			return sb.toString();
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Issue [id=" + id + ", audit=" + audit + ", summary=" + summary
				+ ", description=" + description + ", status=" + status
				+ ", type=" + type + ", priority=" + priority + ", build="
				+ build + ", assignee=" + assignee + ", resolution="
				+ resolution + "]";
	}
	
}
