package com.foodtruck.vo;

public class MemberVO {
	
	private String memberId;	// ȸ�� ���̵�
	private String memberName;	// ȸ�� �̸�
	private String memberPw;	// ȸ�� ��й�ȣ
	private String memberTel;	// ȸ�� ��ȭ��ȣ
	private int memberAuth;		// ȸ�� ����
	
	// getter & setter
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberTel() {
		return memberTel;
	}
	public void setMemberTel(String memberTel) {
		this.memberTel = memberTel;
	}
	public int getMemberAuth() {
		return memberAuth;
	}
	public void setMemberAuth(int memberAuth) {
		this.memberAuth = memberAuth;
	}
}
