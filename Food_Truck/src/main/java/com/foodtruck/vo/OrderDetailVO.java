package com.foodtruck.vo;

public class OrderDetailVO {

	private int prodNo; 	 // ��ǰ ��ȣ
	private int ordNo; 		 // �ֹ� ��ȣ
	private String prodName; // ��ǰ �̸�
	private int ordQty; 	 // ����
	private int ordPrice; 	 // �ֹ�����
	private String memId; 	 // �Ǹ��� ���̵�

	// getter & setter
	public int getProdNo() {
		return prodNo;
	}

	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}

	public int getOrdNo() {
		return ordNo;
	}

	public void setOrdNo(int ordNo) {
		this.ordNo = ordNo;
	}

	public String getProdName() {
		return prodName;
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