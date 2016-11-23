package com.brs.domain;

import java.util.Hashtable;

public class Business {

	private String name;
	private String id;
	private Integer reviewCount;
	private Integer stars;
	private String city;
	private Hashtable<String, String> attributes = new Hashtable<String, String>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(Integer reviewCount) {
		this.reviewCount = reviewCount;
	}

	public Integer getStars() {
		return stars;
	}

	public void setStars(Integer stars) {
		this.stars = stars;
	}

	public Hashtable<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(Hashtable<String, String> attributes) {
		this.attributes = attributes;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
