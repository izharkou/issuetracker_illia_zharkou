package com.issuetracker.model.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.data.annotation.Transient;

import com.issuetracker.model.constants.DatabaseConstants;
import com.issuetracker.model.constants.GeneralConstants;

/**
 * Comment.
 * 
 * @author Illia Zharkou
 */
@Entity
@Table(name = DatabaseConstants.TABLE_COMMENTS)
public class Comment implements Serializable {
	
	private static final long serialVersionUID = 7864847358409104292L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = DatabaseConstants.COLUMN_IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = DatabaseConstants.COLUMN_ISSUE)
	private Issue issue;
	@ManyToOne
	@JoinColumn(name = DatabaseConstants.COLUMN_ADDED_BY)
	private User addedBy;
	@Column(name = DatabaseConstants.COLUMN_COMMENT)
	private String comment;
	@Column(name = DatabaseConstants.COLUMN_ADD_DATE)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime addDate;
	
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
	 * @return the issue
	 */
	public Issue getIssue() {
		return issue;
	}
	
	/**
	 * @param issue the issue to set
	 */
	public void setIssue(Issue issue) {
		this.issue = issue;
	}
	
	/**
	 * @return the addedBy
	 */
	public User getAddedBy() {
		return addedBy;
	}
	
	/**
	 * @param addedBy the addedBy to set
	 */
	public void setAddedBy(User addedBy) {
		this.addedBy = addedBy;
	}
	
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	/**
	 * @return the addDate
	 */
	public DateTime getAddDate() {
		return addDate;
	}
	
	/**
	 * @param addDate the addDate to set
	 */
	public void setAddDate(DateTime addDate) {
		this.addDate = addDate;
	}
	
	/**
	 * Get formatted date.
	 * 
	 * @return
	 */
	@Transient
	public String getFormattedAddDate() {
		DateTimeFormatter fmt = DateTimeFormat.forPattern(GeneralConstants.FORMAT_DATE);
	    return fmt.print(addDate);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Comment [id=" + id + ", issue=" + issue + ", addedBy="
				+ addedBy + ", comment=" + comment + ", addDate=" + addDate
				+ "]";
	}
	
}
