package com.foodtruck.dao;

import java.util.List;

import com.foodtruck.vo.OrderDetailVO;

public interface OrderDetailDAO {

	// �ֹ��� ����
	public OrderDetailVO getOrderDetail(int ordNo);

	// �ֹ��� ����Ʈ
	public List<OrderDetailVO> getOrderDetailList();

	// �ֹ��� ���
	public int insertOrderDetail(OrderDetailVO vo);

	// �ֹ��� ����
	public int updateOrderDetail(OrderDetailVO vo);

	// �ֹ��� ����
	public int deleteOrderDetail(int ordNo);
}
