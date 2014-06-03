package com.un.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 * @author Parag Shrivastava
 *
 */
@Entity
@Table(name = "Audit")
@Document(collection = "Audit")
public class Audit {
	
	@Id
	private ObjectId id;
	private String entityName;
	private String action;
	private String actionBy;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date actionCreationDate;
	private String description;
	
	/**
	 * @return the entityName
	 */
	public String getEntityName() {
		return entityName;
	}
	/**
	 * @param entityName the entityName to set
	 */
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}
	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}
	/**
	 * @return the actionBy
	 */
	public String getActionBy() {
		return actionBy;
	}
	/**
	 * @param actionBy the actionBy to set
	 */
	public void setActionBy(String actionBy) {
		this.actionBy = actionBy;
	}
	/**
	 * @return the actionCreationDate
	 */
	public Date getActionCreationDate() {
		return actionCreationDate;
	}
	/**
	 * @param actionCreationDate the actionCreationDate to set
	 */
	public void setActionCreationDate(Date actionCreationDate) {
		this.actionCreationDate = actionCreationDate;
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
	 * @return the id
	 */
	public ObjectId getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(ObjectId id) {
		this.id = id;
	}

	
}
