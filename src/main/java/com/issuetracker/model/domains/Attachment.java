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
 * Attachment.
 * 
 * @author Illia Zharkou
 */
@Entity
@Table(name = DatabaseConstants.TABLE_ATTACHMENTS)
public class Attachment implements Serializable {
	
	private static final long serialVersionUID = 9163214437447373447L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = DatabaseConstants.COLUMN_IDENTITY)
	private Long id;
	
	@Column(name = DatabaseConstants.COLUMN_FILENAME)
	private String filename;
	
	@ManyToOne
	@JoinColumn(name = DatabaseConstants.COLUMN_ADDED_BY)
	private User addedBy;
	
	@ManyToOne
	@JoinColumn(name = DatabaseConstants.COLUMN_ISSUE)
	private Issue issue;
	
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
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}
	
	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
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
		return "Attachment [id=" + id + ", filename=" + filename + ", addedBy="
				+ addedBy + ", issue=" + issue + ", addDate=" + addDate
				+ "]";
	}
	
}
