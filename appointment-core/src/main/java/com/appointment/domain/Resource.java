package com.appointment.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author UniqueNotion
 * 
 */
@Entity
@Table(name = "Resource")
@Document(collection = "Resource")
public class Resource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private long id;
	private String name;
	private int age;
	private String orgName;
	private String resourceType;
	private String department;
	private boolean showPrice;
	private int price;
	private ResourceDetail resourceDetail;

	public ResourceDetail getResourceDetail() {
		return resourceDetail;
	}

	public void setResourceDetail(ResourceDetail resourceDetail) {
		this.resourceDetail = resourceDetail;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public boolean isShowPrice() {
		return showPrice;
	}

	public void setShowPrice(boolean showPrice) {
		this.showPrice = showPrice;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
