
package com.foodtruck.vo;

public class ProductVO {
	
	private String prodNo;				// ��ǰ ��ȣ
	private String prodName;		// ��ǰ �̸�
	private String prodContent;		// ��ǰ ����
	private String prodImg;			// ��ǰ �̹���
	private int prodPrice;			// �ݾ�
	private String licenseNo;		// ����� ��ȣ
	
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
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdContent() {
		return prodContent;
	}
	public void setProdContent(String prodContent) {
		this.prodContent = prodContent;
	}
	public String getProdImg() {
		return prodImg;
	}
	public void setProdImg(String prodImg) {
		this.prodImg = prodImg;
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

