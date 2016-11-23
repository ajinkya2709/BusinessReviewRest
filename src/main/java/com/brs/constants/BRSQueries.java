package com.brs.constants;

public class BRSQueries {

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

	public static final String SELECT_TOP_REVIEWS_FOR_BUSINESS = "select t2.NAME,t1.STARS,t1.TEXT   "
			+ "from reviews t1 inner join reviewer t2    "
			+ "on t1.USER_ID = t2.USER_ID    "
			+ "where t1.BUSINESS_ID = ?   "
			+ "order by t1.STARS desc,t2.NAME     " + "limit 0,5;    ";

}
