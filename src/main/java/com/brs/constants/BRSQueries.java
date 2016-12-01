package com.brs.constants;

public class BRSQueries {
	
	
	public static final String SELECT_CITY_NAMES_QUERY = "Select CITY from business group by CITY";
	
	public static final String SELECT_BUSINESS_BY_CATEGORY_QUERY = "select NAME,BUSINESS_ID,REVIEW_COUNT,STARS	"
			+ "from business	"
			+ "where trim(CITY) = ?	"
			+ "and CATEGORIES like ?	"
			+ "group by REVIEW_COUNT,STARS	"
			+ "order by STARS desc	" + "limit 0,5";

	public static final String SELECT_BUSINESS_BY_NAME_QUERY = "select NAME,    "
			+ "REVIEW_COUNT,    "
			+ "BUSINESS_ID,    "
			+ "STARS,    "
			+ "ATTRIBUTES_OUTDOORSEATING,    "
			+ "ATTRIBUTES_GOODFOR_LATENIGHT,    "
			+ "ATTRIBUTES_BYOB,    "
			+ "ATTRIBUTES_DIETARY_VEGAN,    "
			+ "ATTRIBUTES_GOODFOR_GROUPS,    "
			+ "ATTRIBUTES_OPEN24HOURS,    "
			+ "ATTRIBUTES_AMBIENCE_ROMANTIC,    "
			+ "ATTRIBUTES_AMBIENCE_UPSCALE ,    "
			+ "ATTRIBUTES_TAKES_RESERVATIONS,    "
			+ "ATTRIBUTES_DELIVERY,    "
			+ "CITY    "
			+ "from business    "
			+ "where trim(NAME) = ?   "
			+ "group by NAME    ";
	
	
	public static final String SELECT_BUSINESS_BY_ID_QUERY = "select NAME,    "
			+ "REVIEW_COUNT,    "
			+ "BUSINESS_ID,    "
			+ "STARS,    "
			+ "ATTRIBUTES_TAKES_RESERVATIONS,    "
			+ "ATTRIBUTES_DELIVERY,    "
			+ "ATTRIBUTES_TAKEOUT,    "
			+ "ATTRIBUTES_ACCEPTSCREDITCARDS,    "
			+ "ATTRIBUTES_WHEELCHAIR,    "
			+ "ATTRIBUTES_GOODFOR_KIDS,    "
			+ "ATTRIBUTES_GOODFOR_GROUPS,    "
			+ "ATTRIBUTES_ALCOHOL,    "
			+ "ATTRIBUTES_NOISELEVEL,    "
			+ "ATTRIBUTES_BYAPPOINTMENTONLY ,    "
			+ "ATTRIBUTES_WAITERSERVICE,    "
			+ "ATTRIBUTES_PARKINGLOT,    "
			+ "ATTRIBUTES_PARKING_VALET,    "
			+ "CITY    "
			+ "from business    "
			+ "where BUSINESS_ID = ?   "+ "limit 0,1  ";
			
	
	
	public static final String SELECT_TOP_REVIEWS_FOR_BUSINESS = "select USER_ID,TEXT,REVIEW_DATE,STARS     "
			+ "from reviews     "
			+ "where BUSINESS_ID = ?    "
			+ "order by REVIEW_DATE desc    " + "limit 0,5";

	public static final String GET_REVIWERNAME_FROM_ID = "select NAME     "
			+ "from reviewer     " + "where USER_ID in (:userIDs)    ";

	public static final String SET_REVIEW_FOR_BUSINESS = "insert into reviews (user_id, business_id, text,stars) values "
			+ "(?,?,?,?)";

}
