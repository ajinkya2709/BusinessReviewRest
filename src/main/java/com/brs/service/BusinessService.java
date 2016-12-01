package com.brs.service;

import java.util.List;

import com.brs.vo.BusinessVO;

public interface BusinessService {
	
	public List<String> getAllCityNames(String s);
	
	public List<BusinessVO> getBusinessesBasedOnCategory(String city,String category);
	
	public BusinessVO getBusinessDetails(String name);
	
	public BusinessVO getBusinessDetailsById(String Id);
	
	public List<String> getAllCityNamesNoMemcached(String s);
	
	public List<BusinessVO> getBusinessesBasedOnCategoryNoMemcached(String city,String category);
	
	public BusinessVO getBusinessDetailsNoMemcached(String name);
	
	public BusinessVO getBusinessDetailsByIdNoMemcached(String Id);
	
}
