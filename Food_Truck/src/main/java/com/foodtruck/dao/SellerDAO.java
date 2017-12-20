package com.foodtruck.dao;

import java.util.List;

import com.foodtruck.vo.SellerVO;

public interface SellerDAO {

	// �Ǹ��� ����
	public SellerVO getSeller(String sellerId);

	// �Ǹ��� ����Ʈ
	public List<SellerVO> getSellerList();

	// �Ǹ��� ���
	public int insertSeller(SellerVO vo);

	// �Ǹ��� ����
	public int updateSeller(SellerVO vo);

	// �Ǹ��� ����
	public int deleteSeller(String sellerId);
}
