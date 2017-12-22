package com.foodtruck.dao;

import java.util.List;

import com.foodtruck.vo.ReviewVO;

public interface ReviewDAO {

		// ���� ����Ʈ
		public List<ReviewVO> getReviewList(String licenseNo);

		// ���� ���
		public int insertReview(ReviewVO vo);

		// ���� ����
		public int updateReview(ReviewVO vo);

		// ���� ����
		public int deleteReview(int revSeq);
}
