package com.foodtruck.vo;

public class OrderDetailVO {
	
	private int prodNo;		// ��ǰ ��ȣ
	private int ordNo;	// �ֹ���ȣ
	private int qty;		// ����
	private int ordPrice;	// �ֹ�����
	
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
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getOrdPrice() {
		return ordPrice;
	}
	public void setOrdPrice(int ordPrice) {
		this.ordPrice = ordPrice;
	}
}
