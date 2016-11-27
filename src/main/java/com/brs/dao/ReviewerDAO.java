package com.brs.dao;

import java.util.List;

import com.brs.domain.Review;

public interface ReviewerDAO {
	
	public void findAndSetReviewerName(List<Review> reviews);

}
