package com.foodtruck.vo;

public class OrderDetailVO {

	private String prodNo; 	 // ��ǰ ��ȣ
	private String ordNo; 		 // �ֹ� ��ȣ
	private String prodName; // ��ǰ �̸�
	private int ordQty; 	 // ����
	private int ordPrice; 	 // �ֹ�����
	private String memId; 	 // �Ǹ��� ���̵�

	// getter & setter
	public String getProdName() {
		return prodName;
	}

	public String getProdNo() {
		return prodNo;
	}

	public void setProdNo(String prodNo) {
		this.prodNo = prodNo;
	}

	public String getOrdNo() {
		return ordNo;
	}

	public void setOrdNo(String ordNo) {
		this.ordNo = ordNo;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public int getOrdQty() {
		return ordQty;
	}

	public void setOrdQty(int ordQty) {
		this.ordQty = ordQty;
	}

	public int getOrdPrice() {
		return ordPrice;
	}

	public void setOrdPrice(int ordPrice) {
		this.ordPrice = ordPrice;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}
	
}
