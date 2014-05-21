package com.un.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Parag Shrivastava
 *
 */
@Entity
@Table(name = "Config")
@Document(collection = "Config")
public class Config implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String resources;
	private String minSlotPerResource;
	private String startHr;
	private String endHr;
	private String frequency;

	/**
	 * @return the resources
	 */
	public String getResources() {
		return resources;
	}

	/**
	 * @param resources
	 *            the resources to set
	 */
	public void setResources(String resources) {
		this.resources = resources;
	}

	/**
	 * @return the minSlotPerResource
	 */
	public String getMinSlotPerResource() {
		return minSlotPerResource;
	}

	/**
	 * @param minSlotPerResource
	 *            the minSlotPerResource to set
	 */
	public void setMinSlotPerResource(String minSlotPerResource) {
		this.minSlotPerResource = minSlotPerResource;
	}

	/**
	 * @return the startHr
	 */
	public String getStartHr() {
		return startHr;
	}

	/**
	 * @param startHr
	 *            the startHr to set
	 */
	public void setStartHr(String startHr) {
		this.startHr = startHr;
	}

	/**
	 * @return the endHr
	 */
	public String getEndHr() {
		return endHr;
	}

	/**
	 * @param endHr
	 *            the endHr to set
	 */
	public void setEndHr(String endHr) {
		this.endHr = endHr;
	}

	/**
	 * @return the frequency
	 */
	public String getFrequency() {
		return frequency;
	}

	/**
	 * @param frequency
	 *            the frequency to set
	 */
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

}
