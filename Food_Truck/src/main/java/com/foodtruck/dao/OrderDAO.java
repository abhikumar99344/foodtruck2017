package com.foodtruck.dao;

import java.util.List;

import com.foodtruck.vo.OrderVO;

public interface OrderDAO {

	// �ֹ� ����
	public OrderVO getOrder(int ordNo);

	// �ֹ� ����Ʈ
	public List<OrderVO> getOrderList();

	// �ֹ� ���
	public int insertOrder(OrderVO vo);

	// �ֹ� ����
	public int updateOrder(OrderVO vo);

	// �ֹ� ����
	public int deleteOrder(int ordNo);
}
