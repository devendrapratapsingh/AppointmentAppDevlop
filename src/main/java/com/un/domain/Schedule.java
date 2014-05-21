package com.un.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Parag Shrivastava
 * 
 */
@Entity
@Table(name = "Schedule")
@Document(collection = "Schedule")
public class Schedule implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Config config;
	private String duration;
	@Id
	private ObjectId durationId;
	private String status;
	private String threshold;
	private String resourceCount;

	/**
	 * @return the config
	 */
	public Config getConfig() {
		return config;
	}

	/**
	 * @param config
	 *            the config to set
	 */
	public void setConfig(Config config) {
		this.config = config;
	}

	/**
	 * @return the duration
	 */
	public String getDuration() {
		return duration;
	}

	/**
	 * @param duration
	 *            the duration to set
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}

	/**
	 * @return the durationId
	 */
	public ObjectId getDurationId() {
		return durationId;
	}

	/**
	 * @param durationId
	 *            the durationId to set
	 */
	public void setDurationId(ObjectId durationId) {
		this.durationId = durationId;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the threshold
	 */
	public String getThreshold() {
		return threshold;
	}

	/**
	 * @param threshold
	 *            the threshold to set
	 */
	public void setThreshold(String threshold) {
		this.threshold = threshold;
	}

	/**
	 * @return the resourceCount
	 */
	public String getResourceCount() {
		return resourceCount;
	}

	/**
	 * @param resourceCount
	 *            the resourceCount to set
	 */
	public void setResourceCount(String resourceCount) {
		this.resourceCount = resourceCount;
	}

}
