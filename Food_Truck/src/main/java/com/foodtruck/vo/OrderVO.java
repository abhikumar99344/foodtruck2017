package com.foodtruck.vo;

public class OrderVO {
	
	private String ordNo;			// �ֹ� ��ȣ
	private String ordName;		// �̸�
	private String ordTel;		// ��ȭ ��ȣ
	private String ordDate;		// �ֹ� �ð�
	private String ordRsvDate;	// ���� �Ͻ�
	private String ordDlyYn;	// ��� ����(Y/N)
	private int ordStat;
	private int cookStat;
	private String memId;		// ȸ�� ���̵�
	private String licenseNo;
	// getter & setter
	public String getOrdNo() {
		return ordNo;
	}
	public void setOrdNo(String ordNo) {
		this.ordNo = ordNo;
	}
	public String getOrdName() {
		return ordName;
	}
	public void setOrdName(String ordName) {
		this.ordName = ordName;
	}
	public String getOrdTel() {
		return ordTel;
	}
	public void setOrdTel(String ordTel) {
		this.ordTel = ordTel;
	}
	public String getOrdDate() {
		return ordDate;
	}
	public void setOrdDate(String ordDate) {
		this.ordDate = ordDate;
	}
	public String getOrdRsvDate() {
		return ordRsvDate;
	}
	public void setOrdRsvDate(String ordRsvDate) {
		this.ordRsvDate = ordRsvDate;
	}
	public String getOrdDlyYn() {
		return ordDlyYn;
	}
	public void setOrdDlyYn(String ordDlyYn) {
		this.ordDlyYn = ordDlyYn;
	}
	public int getOrdStat() {
		return ordStat;
	}
	public void setOrdStat(int ordStat) {
		this.ordStat = ordStat;
	}
	public int getCookStat() {
		return cookStat;
	}
	public void setCookStat(int cookStat) {
		this.cookStat = cookStat;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	
	
}
