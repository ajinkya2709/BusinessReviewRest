package com.brs.domain;

import java.util.Date;

public class Review {

	private String reviewerName;
	private Integer stars;
	private String text;
	private String reviwerId;
	private Date reviewDate;

	public String getReviewerName() {
		return reviewerName;
	}

	public void setReviewerName(String reviewerName) {
		this.reviewerName = reviewerName;
	}

	public Integer getStars() {
		return stars;
	}

	public void setStars(Integer stars) {
		this.stars = stars;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getReviwerId() {
		return reviwerId;
	}

	public void setReviwerId(String reviwerId) {
		this.reviwerId = reviwerId;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

}
