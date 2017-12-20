package com.foodtruck.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodtruck.dao.SellerDAO;
import com.foodtruck.vo.SellerVO;

@Service
public class SellerService {
	@Autowired
	private SqlSessionTemplate sessionTemplate;

	// �Ǹ��� ����
	public SellerVO getSeller(String sellerId) {
		SellerDAO dao = sessionTemplate.getMapper(SellerDAO.class);
		return dao.getSeller(sellerId);
	}

	// �Ǹ��� ����Ʈ
	public List<SellerVO> getSellerList() {
		SellerDAO dao = sessionTemplate.getMapper(SellerDAO.class);
		return dao.getSellerList();
	}

	// �Ǹ��� �Է�
	public int insertSeller(SellerVO vo) {
		SellerDAO dao = sessionTemplate.getMapper(SellerDAO.class);
		return dao.insertSeller(vo);
	}

	// �Ǹ��� ����
	public int updateSeller(SellerVO vo) {
		SellerDAO dao = sessionTemplate.getMapper(SellerDAO.class);
		return dao.updateSeller(vo);
	}

	// �Ǹ��� ����
	public int deleteSeller(String sellerId) {
		SellerDAO dao = sessionTemplate.getMapper(SellerDAO.class);
		return dao.deleteSeller(sellerId);
	}

}
