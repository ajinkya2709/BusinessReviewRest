package com.brs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brs.dao.BusinessDAO;
import com.brs.dao.ReviewsDAO;
import com.brs.domain.Business;
import com.brs.domain.Review;
import com.brs.mapper.BusinessMapper;
import com.brs.service.BusinessService;
import com.brs.vo.BusinessVO;

import static com.brs.constants.BRSConstants.*;

@Service
public class BusinessServiceImpl implements BusinessService{
	
	@Autowired
	private BusinessDAO businessDAO;
	
	@Autowired
	private ReviewsDAO reviewsDAO;
	
	@Autowired
	private BusinessMapper mapper;

	public List<BusinessVO> getBusinessesBasedOnCategory(String city,
			String category) {
		System.out.println("Parameters in service :"+city+"\t"+category);
		List<Business> domainList = businessDAO.fetchBusinessesBasedOnCategory(city, keyWordMapping.get(category));
		List<BusinessVO> result = mapper.mapList(domainList);
		return result;
	}

	public BusinessVO getBusinessDetails(String name) {
		Business business = businessDAO.fetchBusinessBasedOnName(name);
		BusinessVO result = mapper.mapObject(business);
		System.out.println("Business details fetched. Fetchiing Reviews");
		/*List<Review> reviews = reviewsDAO.getReviewsForBusiness(result.getId());
		result.setReviews(reviews);*/
		return result;
	}
	
	

}
