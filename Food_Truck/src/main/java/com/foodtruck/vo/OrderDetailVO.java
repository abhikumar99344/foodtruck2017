package com.foodtruck.vo;

public class OrderDetailVO {
   
   private int prodNo;          // ��ǰ ��ȣ
   private int ordNo;           // �ֹ� ��ȣ
   private String prodName;     // ��ǰ �̸�
   private int qty;            	// ����
   private int ordPrice;        // �ֹ�����
   private String sel_id;       // �Ǹ��ھ��̵�

   // getter & setter
   public String getSel_id() {
      return sel_id;
   }
   public void setSel_id(String sel_id) {
      this.sel_id = sel_id;
   }
   
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
   @Override
   public String toString() {
      return "OrderDetailVO [prodNo=" + prodNo + ", ordNo=" + ordNo + ", prodName=" + prodName + ", qty=" + qty
            + ", ordPrice=" + ordPrice + ", sel_id=" + sel_id + "]";
   }
}