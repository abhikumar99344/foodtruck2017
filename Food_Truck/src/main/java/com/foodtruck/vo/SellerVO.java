package com.foodtruck.vo;

public class SellerVO {
	
	private String selId;		// �Ǹ��� ���̵�
	private String selPw;		// �Ǹ��� ��й�ȣ
	private String selName;		// �Ǹ��� �̸�
	private String selTel;		// �Ǹ��� ����ó
	private String licenseNo;	// ����� ��ȣ
	
	// getter & setter
	public String getSelId() {
		return selId;
	}
	public void setSelId(String selId) {
		this.selId = selId;
	}
	public String getSelPw() {
		return selPw;
	}
	public void setSelPw(String selPw) {
		this.selPw = selPw;
	}
	public String getSelName() {
		return selName;
	}
	public void setSelName(String selName) {
		this.selName = selName;
	}
	public String getSelTel() {
		return selTel;
	}
	public void setSelTel(String selTel) {
		this.selTel = selTel;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
}
