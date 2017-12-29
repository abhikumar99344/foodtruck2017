package com.foodtruck.dao;

import java.util.List;

import com.foodtruck.vo.LicenseVO;
import com.foodtruck.vo.MemberVO;

public interface MemberDAO {
	
	// ȸ�� ����
	public MemberVO getMember(String memberId);

	// ȸ�� ����Ʈ
	public List<MemberVO> getMemberList();

	// ȸ�� ���
	public int insertMember(MemberVO vo);

	// ȸ�� ����
	public int updateMember(MemberVO vo);

	// ȸ�� ����
	public int deleteMember(String memberId);
	
	//�Ǹ����� ���̼�����ȣ
	public List<LicenseVO> getLicenseNo(String selId);
}
