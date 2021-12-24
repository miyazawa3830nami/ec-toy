package com.example.form;

public class OrderForm {

	//	注文番号formに要る？
	
	//	購入商品
	private Integer itemId;
	//	利用ポイント
	private Integer point;
	//	支払方法
	private Integer payment;
	//	支払金額
	private Integer totalPrice;
	// 	配送先（新しい住所追加可能/姓名郵便番号住所電話番号で登録可能)
	private Integer address;
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	public Integer getPayment() {
		return payment;
	}
	public void setPayment(Integer payment) {
		this.payment = payment;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getAddress() {
		return address;
	}
	public void setAddress(Integer address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "OrderForm [itemId=" + itemId + ", point=" + point + ", payment=" + payment + ", totalPrice="
				+ totalPrice + ", address=" + address + "]";
	}
	
}
