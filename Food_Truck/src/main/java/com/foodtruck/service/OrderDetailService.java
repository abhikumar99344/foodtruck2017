package com.foodtruck.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodtruck.dao.OrderDetailDAO;
import com.foodtruck.vo.OrderDetailVO;
import com.foodtruck.vo.ProductVO;

@Service
public class OrderDetailService {
	@Autowired
	private SqlSessionTemplate sessionTemplate;

	// �ֹ��� ����
	public OrderDetailVO getOrderDetail(int ordNo) {
		OrderDetailDAO dao = sessionTemplate.getMapper(OrderDetailDAO.class);
		return dao.getOrderDetail(ordNo);
	}

	// �ֹ��� ����Ʈ
	public List<OrderDetailVO> getOrderDetailList() {
		OrderDetailDAO dao = sessionTemplate.getMapper(OrderDetailDAO.class);
		return dao.getOrderDetailList();
	}
	
	// �ֹ��� �Է�
	public int insertOrderDetail(OrderDetailVO vo) {
		OrderDetailDAO dao = sessionTemplate.getMapper(OrderDetailDAO.class);
		return dao.insertOrderDetail(vo);
	}

	// �ֹ��� ����
	public int updateOrderDetail(OrderDetailVO vo) {
		OrderDetailDAO dao = sessionTemplate.getMapper(OrderDetailDAO.class);
		return dao.updateOrderDetail(vo);
	}

	// �ֹ��� ����
	public int deleteOrderDetail(int ordNo) {
		OrderDetailDAO dao = sessionTemplate.getMapper(OrderDetailDAO.class);
		return dao.deleteOrderDetail(ordNo);
	}

}
