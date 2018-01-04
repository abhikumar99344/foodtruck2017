package com.foodtruck.dao;

import java.util.List;

import com.foodtruck.vo.DeliveryDetailVO;

public interface DeliveryDetailDAO {

	// ��޻� ����
	public DeliveryDetailVO getDeliveryDetail(int prodNo);

	// ��޻� ����Ʈ
	public List<DeliveryDetailVO> getDeliveryDetailList();

	// ��޻� ���
	public int insertDeliveryDetail(DeliveryDetailVO vo);

	// ��޻� ����
	public int updateDeliveryDetail(DeliveryDetailVO vo);

	// ��޻� ����
	public int deleteDeliveryDetail(int prodNo);
}
