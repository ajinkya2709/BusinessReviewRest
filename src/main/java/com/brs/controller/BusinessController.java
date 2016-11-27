package com.brs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.brs.constants.BRSConstants;
import com.brs.service.BusinessService;
import com.brs.vo.BusinessVO;

@RestController
public class BusinessController {
	
	@Autowired
	private BusinessService businessService;
	
	@GetMapping("/city/{city}")
	public List<BusinessVO> getRestaurants(@PathVariable("city") String city){
		return businessService.getBusinessesBasedOnCategory(city, BRSConstants.RESTAURANT_URL);
	}
	
	@GetMapping("/city/{city}/{category}")
	public List<BusinessVO> getBusinessesBasedOnCategory(@PathVariable("city") String city,@PathVariable("category") String category){
		return businessService.getBusinessesBasedOnCategory(city, category);
		
	}
	
	@GetMapping("/business/{name}")
	public BusinessVO getBusinessDetails(@PathVariable("name") String name){
		return businessService.getBusinessDetails(name);
	}

}
