package com.foodtruck.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodtruck.dao.OrderDAO;
import com.foodtruck.vo.LicenseVO;
import com.foodtruck.vo.OrderVO;

@Service
public class OrderService {
	@Autowired
	private SqlSessionTemplate sessionTemplate;

	// ȸ�� ����
	public OrderVO getOrder(int ordNo) {
		OrderDAO dao = sessionTemplate.getMapper(OrderDAO.class);
		return dao.getOrder(ordNo);
	}

	// ȸ�� ����Ʈ
	public List<OrderVO> getOrderList(String licenseNo) {
		OrderDAO dao = sessionTemplate.getMapper(OrderDAO.class);
		return dao.getOrderList(licenseNo);
	}

	// ȸ�� �Է�
	public int insertOrder(OrderVO vo) {
		OrderDAO dao = sessionTemplate.getMapper(OrderDAO.class);
		return dao.insertOrder(vo);
	}

	// ȸ�� ����
	public int updateOrder(OrderVO vo) {
		OrderDAO dao = sessionTemplate.getMapper(OrderDAO.class);
		return dao.updateOrder(vo);
	}

	// ȸ�� ����
	public int deleteOrder(int ordNo) {
		OrderDAO dao = sessionTemplate.getMapper(OrderDAO.class);
		return dao.deleteOrder(ordNo);
	}
	
	public List<OrderVO> getLicense(String memberId) {
		OrderDAO dao = sessionTemplate.getMapper(OrderDAO.class);
		return dao.getLicense(memberId);
	}
	
	public List<OrderVO> getLicense2(String licenseNo) {
		OrderDAO dao = sessionTemplate.getMapper(OrderDAO.class);
		return dao.getLicense(licenseNo);
	}

}
