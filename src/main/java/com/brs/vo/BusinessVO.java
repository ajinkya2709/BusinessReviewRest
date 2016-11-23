package com.brs.vo;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.brs.domain.Review;

public class BusinessVO {

	private String name;
	private String id;
	private Integer reviewCount;
	private Integer stars;
	private String city;
	private Hashtable<String, String> attributes = new Hashtable<String, String>();
	private List<Review> reviews= new ArrayList<Review>();

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Hashtable<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(Hashtable<String, String> attributes) {
		this.attributes = attributes;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
	

}
