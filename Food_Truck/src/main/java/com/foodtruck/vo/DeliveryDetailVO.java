package com.foodtruck.vo;

public class DeliveryDetailVO {
	
	private int ordNo;			// �ֹ� ��ȣ
	private String dlvState;	// ��� ����
	private String dlvAddr;		// ��� �ּ�
	private String dlvDate;		// ��� �ð�
	
	// getter & setter
	public int getOrdNo() {
		return ordNo;
	}
	public void setOrdNo(int ordNo) {
		this.ordNo = ordNo;
	}
	public String getDlvState() {
		return dlvState;
	}
	public void setDlvState(String dlvState) {
		this.dlvState = dlvState;
	}
	public String getDlvAddr() {
		return dlvAddr;
	}
	public void setDlvAddr(String dlvAddr) {
		this.dlvAddr = dlvAddr;
	}
	public String getDlvDate() {
		return dlvDate;
	}
	public void setDlvDate(String dlvDate) {
		this.dlvDate = dlvDate;
	}
	
}
