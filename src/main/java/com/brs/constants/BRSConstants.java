package com.brs.constants;

import java.util.Hashtable;

public class BRSConstants {
	
	public static final String RESTAURANT_URL = "restaurants";
	
	public static final String YES = "Yes";
	
	public static final String NO = "No";
	
	public static final String TRUE = "TRUE";
	
	public static Hashtable<String, String> keyWordMapping = new Hashtable<String, String>();
	
	static{
		keyWordMapping.put("restaurants", "%Restaurant%");
		keyWordMapping.put("healthcare", "%Health and Medical%");
		keyWordMapping.put("nightlife", "%Nightlife%");
		keyWordMapping.put("shopping", "%Shopping%");
		keyWordMapping.put("activelife", "%Active Life%");
		keyWordMapping.put("localservices", "%Local Services%");
	}
	
}
