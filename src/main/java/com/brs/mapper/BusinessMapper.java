package com.brs.mapper;

import static com.brs.constants.BRSConstants.NO;
import static com.brs.constants.BRSConstants.TRUE;
import static com.brs.constants.BRSConstants.YES;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.brs.domain.Business;
import com.brs.vo.BusinessVO;

@Component
public class BusinessMapper {

	public List<BusinessVO> mapList(List<Business> businesses) {
		List<BusinessVO> voList = new ArrayList<BusinessVO>();
		if (businesses == null)
			return voList;

		for (Business business : businesses) {
			BusinessVO vo = new BusinessVO();
			vo.setName(business.getName());
			vo.setId(business.getId());
			vo.setStars(business.getStars());
			vo.setCity(business.getCity());
			voList.add(vo);
		}

		return voList;
	}

	public BusinessVO mapObject(Business business) {
		BusinessVO vo = new BusinessVO();
		if (business == null)
			return vo;

		if (StringUtils.isNotBlank(business.getName()))
			vo.setName(business.getName());
		else
			vo.setName(StringUtils.EMPTY);

		if (StringUtils.isNotBlank(business.getId()))
			vo.setId(business.getId());
		else
			vo.setId(StringUtils.EMPTY);

		if (StringUtils.isNotBlank(business.getCity()))
			vo.setCity(business.getCity());
		else
			vo.setCity(StringUtils.EMPTY);

		if (business.getReviewCount() != null)
			vo.setReviewCount(business.getReviewCount());
		else
			vo.setReviewCount(0);

		if (business.getStars() != null)
			vo.setStars(business.getStars());
		else
			vo.setStars(0);

		for (String key : business.getAttributes().keySet()) {
			if (StringUtils.isNotBlank(business.getAttributes().get(key))
					&& business.getAttributes().get(key).equalsIgnoreCase(TRUE))
				vo.getAttributes().put(key, YES);
			else
				vo.getAttributes().put(key, NO);
		}

		return vo;

	}
	
}
