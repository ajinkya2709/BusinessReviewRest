package com.brs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brs.dao.BusinessDAO;
import com.brs.dao.ReviewerDAO;
import com.brs.dao.ReviewsDAO;
import com.brs.domain.Business;
import com.brs.domain.Review;
import com.brs.mapper.BusinessMapper;
import com.brs.service.BusinessService;
import com.brs.vo.BusinessVO;
import com.google.code.ssm.api.ParameterValueKeyProvider;
import com.google.code.ssm.api.ReadThroughSingleCache;
import com.google.code.ssm.api.ReturnDataUpdateContent;
import com.google.code.ssm.api.UpdateSingleCache;

import static com.brs.constants.BRSConstants.*;

@Service
public class BusinessServiceImpl implements BusinessService{
	
	@Autowired
	private BusinessDAO businessDAO;
	
	@Autowired
	private ReviewsDAO reviewsDAO;
	
	@Autowired
	private ReviewerDAO reviewerDAO;
	
	@Autowired
	private BusinessMapper mapper;
	
	@ReadThroughSingleCache(namespace = "cityName", expiration = 3600)
	public List<String> getAllCityNames(@ParameterValueKeyProvider String s){
		List<String> domainList = businessDAO.fetchAllCityNames();
		return domainList;
	}
	
	@ReadThroughSingleCache(namespace = "businessCat", expiration = 3600)
	public List<BusinessVO> getBusinessesBasedOnCategory(String city,@ParameterValueKeyProvider(order=1) String cityWithoutSpaces,
			@ParameterValueKeyProvider(order=2) String category) {
		System.out.println("Parameters in service :"+city+"\t"+category);
		List<Business> domainList = businessDAO.fetchBusinessesBasedOnCategory(city, keyWordMapping.get(category));
		List<BusinessVO> result = mapper.mapList(domainList);
		if(result.size()==0)
		System.out.println("No Businesses found in getBusinessesBasedOnCategory");
		return result;
	}

	@ReadThroughSingleCache(namespace = "businessName", expiration = 3600)
	public BusinessVO getBusinessDetails(@ParameterValueKeyProvider String name) {
		Business business = businessDAO.fetchBusinessBasedOnName(name);
		BusinessVO result = mapper.mapObject(business);
		System.out.println("Business details fetched. Fetchiing Reviews");
		List<Review> reviews = reviewsDAO.getReviewsForBusiness(result.getId());
		reviewerDAO.findAndSetReviewerName(reviews);
		result.setReviews(reviews);
		return result;
	}
	
	@ReadThroughSingleCache(namespace = "businessId", expiration = 3600)
	public BusinessVO getBusinessDetailsById(@ParameterValueKeyProvider String Id) {
		Business business = businessDAO.fetchBusinessBasedOnId(Id);
		BusinessVO result = mapper.mapObject(business);
		System.out.println("Business details fetched. Fetchiing Reviews");
		List<Review> reviews = reviewsDAO.getReviewsForBusiness(result.getId());
		if(!reviews.isEmpty()){
		reviewerDAO.findAndSetReviewerName(reviews);
		}
		result.setReviews(reviews);

		return result;
	}
	
	
	public List<String> getAllCityNamesNoMemcached( String s){
		List<String> domainList = businessDAO.fetchAllCityNames();
		return domainList;
	}
	
	
	public List<BusinessVO> getBusinessesBasedOnCategoryNoMemcached(String city,
			 String category) {
		System.out.println("Parameters in service :"+city+"\t"+category);
		List<Business> domainList = businessDAO.fetchBusinessesBasedOnCategory(city, keyWordMapping.get(category));
		List<BusinessVO> result = mapper.mapList(domainList);
		return result;
	}

	
	public BusinessVO getBusinessDetailsNoMemcached(String name) {
		Business business = businessDAO.fetchBusinessBasedOnName(name);
		BusinessVO result = mapper.mapObject(business);
		System.out.println("Business details fetched. Fetchiing Reviews");
		List<Review> reviews = reviewsDAO.getReviewsForBusiness(result.getId());
		if(!reviews.isEmpty()){
			reviewerDAO.findAndSetReviewerName(reviews);
		}
		result.setReviews(reviews);
		return result;
	}
	
	
	public BusinessVO getBusinessDetailsByIdNoMemcached(String Id) {
		Business business = businessDAO.fetchBusinessBasedOnId(Id);
		BusinessVO result = mapper.mapObject(business);
		System.out.println("Business details fetched. Fetchiing Reviews");
		List<Review> reviews = reviewsDAO.getReviewsForBusiness(result.getId());

		if(!reviews.isEmpty()){
		reviewerDAO.findAndSetReviewerName(reviews);
		}
		result.setReviews(reviews);

		return result;
	}
	
	@UpdateSingleCache(namespace = "businessId")
	@ReturnDataUpdateContent
	public BusinessVO setUserReviewBasedOnBusiness(@ParameterValueKeyProvider String business_id, String user_id, String text, int stars) {
		System.out.println("setUserReviewBasedOnBusiness start");
		System.out.println("Business ID"+business_id);
		reviewsDAO.setReviewForBusiness(business_id,user_id,text,stars);
		BusinessVO businessVO = getBusinessDetailsByIdNoMemcached(business_id);
		System.out.println("setUserReviewBasedOnBusiness end");
		return businessVO;
	}	
	
}
