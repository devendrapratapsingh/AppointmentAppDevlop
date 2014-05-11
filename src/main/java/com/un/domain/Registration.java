package com.un.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.bson.types.BSONTimestamp;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Model object package un prefix stands for United Notions
 * 
 * @author pascal
 */
@Entity
@Table(name = "Registration")
@Document
public class Registration implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private ObjectId id;
	
	private String orgName;
	private String orgPrefix;
	private String contact;
	private String email;
	private String type;
	private BSONTimestamp createTimestamp;
	private String createdBy;
	private String message;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	/**
	 * @return the orgName
	 */
	public String getOrgName() {
		return orgName;
	}

	/**
	 * @param orgName
	 *            the orgName to set
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	/**
	 * @return the orgPrefix
	 */
	public String getOrgPrefix() {
		return orgPrefix;
	}

	/**
	 * @param orgPrefix
	 *            the orgPrefix to set
	 */
	public void setOrgPrefix(String orgPrefix) {
		this.orgPrefix = orgPrefix;
	}

	/**
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}

	/**
	 * @param contact
	 *            the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the createTimestamp
	 */
	public BSONTimestamp getCreateTimestamp() {
		return createTimestamp;
	}

	/**
	 * @param createTimestamp
	 *            the createTimestamp to set
	 */
	public void setCreateTimestamp(BSONTimestamp createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(final String message) {
		this.message = message;
	}
}
