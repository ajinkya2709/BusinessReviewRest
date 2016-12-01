package com.brs.dao.impl;

import static com.brs.constants.BRSQueries.SELECT_TOP_REVIEWS_FOR_BUSINESS;
import static com.brs.constants.BRSQueries.SET_REVIEW_FOR_BUSINESS;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.brs.dao.ReviewsDAO;
import com.brs.domain.Review;
import com.mysql.jdbc.PreparedStatement;

@Component
public class ReviewsDAOImpl extends JdbcDaoSupport implements ReviewsDAO {

	public ReviewsDAOImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public List<Review> getReviewsForBusiness(String businessId) {
		System.out.println("Review DAO parameter :"+businessId);
		//Check query
		List<Review> result = getJdbcTemplate().query(
				SELECT_TOP_REVIEWS_FOR_BUSINESS, new Object[] { businessId },
				new int[] { Types.VARCHAR }, new RowMapper<Review>() {
					public Review mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Review review = new Review();
						review.setStars(rs.getInt("STARS"));
						review.setText(rs.getString("TEXT"));	//Not sure about this
						review.setReviewDate(rs.getDate("REVIEW_DATE"));
						review.setReviwerId(rs.getString("USER_ID"));
						return review;
					}

				});
		System.out.println("Review List size:"+result.size());
		return result;
	}
	
	public boolean setReviewForBusiness(String business_id, String user, String text, int stars){
		 return getJdbcTemplate().update(SET_REVIEW_FOR_BUSINESS, business_id, user, text, stars)==0 ? false : true; 
	}
}
