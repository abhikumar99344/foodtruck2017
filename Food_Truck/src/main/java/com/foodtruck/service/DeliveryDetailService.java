package com.foodtruck.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodtruck.dao.DeliveryDetailDAO;
import com.foodtruck.vo.DeliveryDetailVO;

@Service
public class DeliveryDetailService {
	@Autowired
	private SqlSessionTemplate sessionTemplate;

	// ��޻� ����
	public DeliveryDetailVO getDeliveryDetail(int ordNo) {
		DeliveryDetailDAO dao = sessionTemplate.getMapper(DeliveryDetailDAO.class);
		return dao.getDeliveryDetail(ordNo);
	}

	// ��޻� ����Ʈ
	public List<DeliveryDetailVO> getDeliveryDetailList() {
		DeliveryDetailDAO dao = sessionTemplate.getMapper(DeliveryDetailDAO.class);
		return dao.getDeliveryDetailList();
	}

	// ��޻� �Է�
	public int insertDeliveryDetail(DeliveryDetailVO vo) {
		DeliveryDetailDAO dao = sessionTemplate.getMapper(DeliveryDetailDAO.class);
		return dao.insertDeliveryDetail(vo);
	}

	// ��޻� ����
	public int updateDeliveryDetail(DeliveryDetailVO vo) {
		DeliveryDetailDAO dao = sessionTemplate.getMapper(DeliveryDetailDAO.class);
		return dao.updateDeliveryDetail(vo);
	}

	// ��޻� ����
	public int deleteDeliveryDetail(int ordNo) {
		DeliveryDetailDAO dao = sessionTemplate.getMapper(DeliveryDetailDAO.class);
		return dao.deleteDeliveryDetail(ordNo);
	}

}
