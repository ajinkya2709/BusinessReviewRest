package com.brs.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.brs.dao.BusinessDAO;
import com.brs.domain.Business;

import static com.brs.constants.BRSQueries.*;

@Component
public class BusinessDAOImpl extends JdbcDaoSupport implements BusinessDAO {

	@Autowired
	public BusinessDAOImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	public List<String> fetchAllCityNames(){
		List<String> result = getJdbcTemplate().query(SELECT_CITY_NAMES_QUERY,
				new RowMapper<String>(){
			public String mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				return rs.getString("CITY");
			}
		});
		return result;
	}
	
	public List<Business> fetchBusinessesBasedOnCategory(String city,
			String category) {
		System.out.println("fetchBusinessesBasedOnCategory Parameters :" + city + "\t" + category);
		List<Business> result = getJdbcTemplate().query(
				SELECT_BUSINESS_BY_CATEGORY_QUERY,
				new Object[] { city, category },
				new int[] { Types.VARCHAR, Types.VARCHAR },
				new RowMapper<Business>() {
					public Business mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Business business = new Business();
						business.setId(rs.getString("BUSINESS_ID"));
						business.setName(rs.getString("NAME"));
						business.setReviewCount(rs.getInt("REVIEW_COUNT"));
						business.setStars(rs.getInt("STARS"));
						return business;
					}
					
				});
		for(Business business:result){
			System.out.println("Business ID:"+business.getId());
		}
		System.out.println(result.size());
		return result;
	}

	public Business fetchBusinessBasedOnName(String name) {
		System.out.println("Business Name :" + name);
		Business result = getJdbcTemplate().queryForObject(
				SELECT_BUSINESS_BY_NAME_QUERY, new Object[] { name },
				new int[] { Types.VARCHAR }, new RowMapper<Business>() {
					public Business mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Business business = new Business();
						business.setId(rs.getString("BUSINESS_ID"));
						business.setName(rs.getString("NAME"));
						business.setReviewCount(rs.getInt("REVIEW_COUNT"));
						business.setStars(rs.getInt("STARS"));
						business.setCity(rs.getString("CITY"));
						business.getAttributes().put("Outdoor Seating", rs.getString("ATTRIBUTES_OUTDOORSEATING"));
						business.getAttributes().put("Late Night", rs.getString("ATTRIBUTES_GOODFOR_LATENIGHT"));
						business.getAttributes().put("BYOB", rs.getString("ATTRIBUTES_BYOB"));
						business.getAttributes().put("Delivery", rs.getString("ATTRIBUTES_DELIVERY"));
						business.getAttributes().put("Good For Groups", rs.getString("ATTRIBUTES_GOODFOR_GROUPS"));
						business.getAttributes().put("Open 24 Hours", rs.getString("ATTRIBUTES_OPEN24HOURS"));
						business.getAttributes().put("Romantic", rs.getString("ATTRIBUTES_AMBIENCE_ROMANTIC"));
						business.getAttributes().put("Upscale", rs.getString("ATTRIBUTES_AMBIENCE_UPSCALE"));
						business.getAttributes().put("Reservations", rs.getString("ATTRIBUTES_TAKES_RESERVATIONS"));
						return business;
					}

				});

		return result;
	}
	
	public Business fetchBusinessBasedOnId(String Id) {
		System.out.println("Business Id :" + Id);
		Business result = getJdbcTemplate().queryForObject(
				SELECT_BUSINESS_BY_ID_QUERY, new Object[] { Id },
				new int[] { Types.VARCHAR }, new RowMapper<Business>() {
					public Business mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Business business = new Business();
						business.setId(rs.getString("BUSINESS_ID"));
						business.setName(rs.getString("NAME"));
						business.setReviewCount(rs.getInt("REVIEW_COUNT"));
						business.setStars(rs.getInt("STARS"));
						business.setCity(rs.getString("CITY"));
						business.getAttributes().put("ATTRIBUTES_TAKES_RESERVATIONS", rs.getString("ATTRIBUTES_TAKES_RESERVATIONS"));
						business.getAttributes().put("ATTRIBUTES_DELIVERY", rs.getString("ATTRIBUTES_DELIVERY"));
						business.getAttributes().put("Takeout", rs.getString("ATTRIBUTES_TAKEOUT"));
						business.getAttributes().put("Accept Credit Cards", rs.getString("ATTRIBUTES_ACCEPTSCREDITCARDS"));
						business.getAttributes().put("WheelChair", rs.getString("ATTRIBUTES_WHEELCHAIR"));
						business.getAttributes().put("GoodForKids", rs.getString("ATTRIBUTES_GOODFOR_KIDS"));
						business.getAttributes().put("Good For Groups", rs.getString("ATTRIBUTES_GOODFOR_GROUPS"));
						business.getAttributes().put("Alchohol", rs.getString("ATTRIBUTES_ALCOHOL"));
						business.getAttributes().put("NoiseLevel", rs.getString("ATTRIBUTES_NOISELEVEL"));
						business.getAttributes().put("ByAppointment", rs.getString("ATTRIBUTES_BYAPPOINTMENTONLY"));
						business.getAttributes().put("WaiterService", rs.getString("ATTRIBUTES_WAITERSERVICE"));
						business.getAttributes().put("Parking Lot", rs.getString("ATTRIBUTES_PARKINGLOT"));
						business.getAttributes().put("Parking Valet", rs.getString("ATTRIBUTES_PARKING_VALET"));
						
						return business;
					}

				});

		return result;
	}
	

}
