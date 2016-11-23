package com.brs.dao.impl;

import static com.brs.constants.BRSQueries.SELECT_TOP_REVIEWS_FOR_BUSINESS;

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
						review.setReviewerName(rs.getString("NAME"));
						review.setStars(rs.getInt("STARS"));
						review.setText(rs.getString("TEXT"));	//Not sure about this
						return review;
					}

				});
		System.out.println("Review List size:"+result.size());
		return result;
	}
}