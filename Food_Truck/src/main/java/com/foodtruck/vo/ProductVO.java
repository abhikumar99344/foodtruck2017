package com.foodtruck.vo;

public class ProductVO {
	
	private int prodNo;				// ��ǰ ��ȣ
	private String prodName;		// ��ǰ �̸�
	private String prodContent;		// ��ǰ ����
	private int prodPrice;			// �ݾ�
	private String licenseNo;		// ����� ��ȣ
	
	// getter & setter
	public int getProdNo() {
		return prodNo;
	}
	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdContent() {
		return prodContent;
	}
	public void setProdContent(String prodContent) {
		this.prodContent = prodContent;
	}
	public int getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
}
