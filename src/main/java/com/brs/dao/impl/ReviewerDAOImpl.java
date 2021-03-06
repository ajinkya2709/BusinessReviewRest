package com.brs.dao.impl;

import static com.brs.constants.BRSQueries.GET_REVIWERNAME_FROM_ID;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.brs.dao.ReviewerDAO;
import com.brs.domain.Review;

@Component
public class ReviewerDAOImpl extends NamedParameterJdbcDaoSupport implements
		ReviewerDAO {

	@Autowired
	public ReviewerDAOImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public void findAndSetReviewerName(List<Review> reviews) {
		System.out.println("In Reviewer DAO. On track");
		if (reviews == null)
			return;
		List<String> userIds = new ArrayList<String>();
		for (Review review : reviews) {
			userIds.add(review.getReviwerId());
		}
		System.out.println("Printing User Ids for reviews");
		System.out.println(userIds);
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("userIDs", userIds);
		List<String> names = getNamedParameterJdbcTemplate().queryForList(
				GET_REVIWERNAME_FROM_ID,
				Collections.singletonMap("userIDs", userIds), null);
		System.out.println("Printing ID Name Mapping");
		for (int i = 0; i < reviews.size(); i++) {
			reviews.get(i).setReviewerName(names.get(i));
			System.out.println(reviews.get(i)+" "+names.get(i));
		}
	}
}
