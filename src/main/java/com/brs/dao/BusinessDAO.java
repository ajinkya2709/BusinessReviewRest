package com.brs.dao;

import java.util.List;

import com.brs.domain.Business;

public interface BusinessDAO {
	
	public List<String> fetchAllCityNames();
	
	public List<Business> fetchBusinessesBasedOnCategory(String city,
			String category);
	
	public Business fetchBusinessBasedOnName(String name);

}
