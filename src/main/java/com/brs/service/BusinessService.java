package com.brs.service;

import java.util.List;

import com.brs.vo.BusinessVO;

public interface BusinessService {
	
	public List<String> getAllCityNames();
	
	public List<BusinessVO> getBusinessesBasedOnCategory(String city,String category);
	
	public BusinessVO getBusinessDetails(String name);
	
	public BusinessVO getBusinessDetailsById(String Id);
	
	public boolean setUserReviewBasedOnBusiness(String business_id, String user_id, String text, int stars);
	
}
