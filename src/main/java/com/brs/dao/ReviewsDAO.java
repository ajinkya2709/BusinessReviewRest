package com.brs.dao;

import java.util.List;

import com.brs.domain.Review;

public interface ReviewsDAO {
	
	public List<Review> getReviewsForBusiness(String businessId);
	public boolean setReviewForBusiness(String business_id, String user, String text, int stars);

}
