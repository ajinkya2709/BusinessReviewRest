package com.brs.dao;

import java.util.List;

import com.brs.domain.Review;

public interface ReviewsDAO {
	
	public List<Review> getReviewsForBusiness(String businessId);

}
