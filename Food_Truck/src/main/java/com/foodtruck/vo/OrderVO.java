package com.foodtruck.vo;

public class OrderVO {
	
	private int ordNo;			// �ֹ� ��ȣ
	private String ordName;		// �̸�
	private String ordTel;		// ��ȭ ��ȣ
	private String ordDate;		// �ֹ� �ð�
	private String ordRsvDate;	// ���� �Ͻ�
	private String ordDlyYn;	// ��� ����(Y/N)
	private String memId;		// ȸ�� ���̵�
	
	// getter & setter
	
	public int getOrdNo() {
		return ordNo;
	}
	public void setOrdNo(int ordNo) {
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
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
}
