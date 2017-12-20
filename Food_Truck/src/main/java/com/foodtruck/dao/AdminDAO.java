package com.foodtruck.dao;

import java.util.List;

import com.foodtruck.vo.AdminVO;

public interface AdminDAO {

	// ������ ����
	public AdminVO getAdmin(String AdminId);

	// ������ ����Ʈ
	public List<AdminVO> getAdminList();

	// ������ ���
	public int insertAdmin(AdminVO vo);

	// ������ ����
	public int updateAdmin(AdminVO vo);

	// ������ ����
	public int deleteAdmin(String AdminId);
}
