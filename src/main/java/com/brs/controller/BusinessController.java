package com.brs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.brs.constants.BRSConstants;
import com.brs.service.BusinessService;
import com.brs.vo.BusinessVO;
import com.brs.vo.ReviewVO;

@CrossOrigin
@RestController
public class BusinessController {
	
	@Autowired
	private BusinessService businessService;
	
	@GetMapping("/city")
	public List<String> getCityNames(){
		return businessService.getAllCityNames("cityName");
	}
	
	@GetMapping("/city/{city}")
	public List<BusinessVO> getRestaurants(@PathVariable("city") String city){
		
		long startTime = System.currentTimeMillis();
		List<BusinessVO> bVOList = businessService.getBusinessesBasedOnCategory(city,city.replaceAll(" ","_") ,BRSConstants.RESTAURANT_URL);
		long endTime = System.currentTimeMillis();
		long runTime = endTime - startTime;
		if(bVOList.isEmpty())
			bVOList.add(new BusinessVO());
		bVOList.get(0).setRunTime(runTime);
		return bVOList;
	}
	
	@GetMapping("/city/{city}/{category}")
	public List<BusinessVO> getBusinessesBasedOnCategory(@PathVariable("city") String city,@PathVariable("category") String category){
		long startTime = System.currentTimeMillis();
		List<BusinessVO> bVOList = businessService.getBusinessesBasedOnCategory(city, city.replaceAll(" ","_"),category);
		long endTime = System.currentTimeMillis();
		long runTime = endTime - startTime;
		if(bVOList.isEmpty())
			bVOList.add(new BusinessVO());
		bVOList.get(0).setRunTime(runTime);
		return bVOList;
		
	}
	
	@GetMapping("/business/{Id}")
	public BusinessVO getBusinessDetails(@PathVariable("Id") String Id){
		long startTime = System.currentTimeMillis();
		BusinessVO businessVO = businessService.getBusinessDetailsById(Id);
		long endTime = System.currentTimeMillis();
		long runTime = endTime - startTime;
		businessVO.setRunTime(runTime);
		return businessVO;
	}
	
	@GetMapping("/off/city")
	public List<String> getCityNamesNoMemcached(){
		return businessService.getAllCityNamesNoMemcached("cityName");
	}
	
	@GetMapping("/off/city/{city}")
	public List<BusinessVO> getRestaurantsNoMemcached(@PathVariable("city") String city){
		
		long startTime = System.currentTimeMillis();
		List<BusinessVO> bVOList = businessService.getBusinessesBasedOnCategoryNoMemcached(city, BRSConstants.RESTAURANT_URL);
		long endTime = System.currentTimeMillis();
		long runTime = endTime - startTime;
		if(bVOList.isEmpty())
			bVOList.add(new BusinessVO());
		bVOList.get(0).setRunTime(runTime);
		return bVOList;
	}
	
	@GetMapping("/off/city/{city}/{category}")
	public List<BusinessVO> getBusinessesBasedOnCategoryNoMemcached(@PathVariable("city") String city,@PathVariable("category") String category){
		long startTime = System.currentTimeMillis();
		List<BusinessVO> bVOList = businessService.getBusinessesBasedOnCategoryNoMemcached(city, category);
		long endTime = System.currentTimeMillis();
		long runTime = endTime - startTime;
		if(bVOList.isEmpty())
			bVOList.add(new BusinessVO());
		bVOList.get(0).setRunTime(runTime);
		return bVOList;
		
	}
	
	@GetMapping("/off/business/{Id}")
	public BusinessVO getBusinessDetailsNoMemcached(@PathVariable("Id") String Id){
		long startTime = System.currentTimeMillis();
		BusinessVO businessVO = businessService.getBusinessDetailsByIdNoMemcached(Id);
		long endTime = System.currentTimeMillis();
		long runTime = endTime - startTime;
		businessVO.setRunTime(runTime);
		return businessVO;
	}
	
	@GetMapping("/postReview/{user_id}/{business_id}/{text}/{stars}")
	public BusinessVO setUserReview(@PathVariable("user_id") String user_id,@PathVariable("business_id") String business_id,@PathVariable("text") String text,@PathVariable("stars") int stars){
		return businessService.setUserReviewBasedOnBusiness(business_id, user_id, text, stars);
	}
	
	@PostMapping(value="/addReview")
	@ResponseBody
	public BusinessVO addReview(@RequestBody ReviewVO reviewVO){
		System.out.println("Add Review started");
		long startTime = System.currentTimeMillis();
		BusinessVO businessVO = null;
		if(reviewVO!=null){
			System.out.println("reviewVO is NOT null");
			System.out.println(reviewVO);
			businessVO = businessService.setUserReviewBasedOnBusiness(reviewVO.getBusinessId(), reviewVO.getUserId(), reviewVO.getText(), reviewVO.getStars());
		}
		long endTime = System.currentTimeMillis();
		long runTime = endTime - startTime;
		businessVO.setRunTime(runTime);
		return businessVO;
	}

}
