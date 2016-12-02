package com.brs.vo;

public class ReviewVO {

	private String userId;
	private String businessId;
	private Integer stars;
	private String text;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
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
	
	@Override
	public String toString(){
		return "text:"+text+" stars:"+stars+" userId:"+userId+" businessId:"+businessId;
	}

}
