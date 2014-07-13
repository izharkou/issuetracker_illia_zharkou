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
 * Audit info for issue.
 * 
 * @author Illia Zharkou
 */
@Entity
@Table(name = DatabaseConstants.TABLE_AUDIT)
public class Audit implements Serializable {
	
	private static final long serialVersionUID = 1411095155342859238L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = DatabaseConstants.COLUMN_IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = DatabaseConstants.COLUMN_CREATED_BY)
	private User createdBy;
	@ManyToOne
	@JoinColumn(name = DatabaseConstants.COLUMN_MODIFIED_BY)
	private User modifiedBy;
	@Column(name = DatabaseConstants.COLUMN_CREATED_DATE)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime createdDate;
	@Column(name = DatabaseConstants.COLUMN_MODIFIED_DATE)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime modifiedDate;
	
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
	 * @return the createdBy
	 */
	public User getCreatedBy() {
		return createdBy;
	}
	
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
	
	/**
	 * @return the modifyedBy
	 */
	public User getModifyedBy() {
		return modifiedBy;
	}
	
	/**
	 * @param modifyedBy the modifyedBy to set
	 */
	public void setModifyedBy(User modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	/**
	 * @return the modifiedBy
	 */
	public User getModifiedBy() {
		return modifiedBy;
	}
	
	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(User modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	/**
	 * @return the createdDate
	 */
	public DateTime getCreatedDate() {
		return createdDate;
	}
	
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	/**
	 * @return the modifiedDate
	 */
	public DateTime getModifiedDate() {
		return modifiedDate;
	}
	
	/**
	 * @param modifiedDate the modifiedDate to set
	 */
	public void setModifiedDate(DateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	/**
	 * @return formatted modified date
	 */
	@Transient
	public String getFormattedModifiedDate() {
		DateTimeFormatter fmt = DateTimeFormat.forPattern(GeneralConstants.FORMAT_DATE);
	    return fmt.print(modifiedDate);
	}

	/**
	 * @return formatted created date
	 */
	@Transient
	public String getFormattedCreatedDate() {
		DateTimeFormatter fmt = DateTimeFormat.forPattern(GeneralConstants.FORMAT_DATE);
	    return fmt.print(createdDate);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Audit [id=" + id + ", createdBy=" + createdBy + ", modifiedBy="
				+ modifiedBy + ", createdDate=" + createdDate
				+ ", modifiedDate=" + modifiedDate + "]";
	}
	
}
