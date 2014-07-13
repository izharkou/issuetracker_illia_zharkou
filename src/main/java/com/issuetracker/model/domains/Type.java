package com.issuetracker.model.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.issuetracker.model.constants.DatabaseConstants;

/**
 * Type.
 * 
 * @author Illia Zharkou
 */
@Entity
@Table(name = DatabaseConstants.TABLE_TYPES)
public class Type implements Serializable {
	
	private static final long serialVersionUID = -1873134634284211862L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = DatabaseConstants.COLUMN_IDENTITY)
	private Long id;
	@Column(name = DatabaseConstants.COLUMN_NAME)
	private String name;
	
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Type [id=" + id + ", name=" + name + "]";
	}
	
}
