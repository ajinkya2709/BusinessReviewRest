package com.brs.service;

import java.util.List;

import com.brs.vo.BusinessVO;

public interface BusinessService {
	
	public List<BusinessVO> getBusinessesBasedOnCategory(String city,String category);
	
	public BusinessVO getBusinessDetails(String name);
	
}
