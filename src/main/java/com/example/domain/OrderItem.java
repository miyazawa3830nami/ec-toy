package com.example.domain;

public class OrderItem {

	//	ID
	private Integer id;
	//	注文番号
	private Integer orderId;
	//	購入商品ID
	private Integer itemId;
	//	利用ポイント
	private Integer point;
	//	支払方法
	private Integer payment;
	//	支払金額
	private Integer totalPrice;
	// 	配送先
	private Integer address;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
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
		return "OrderItem [id=" + id + ", orderId=" + orderId + ", itemId=" + itemId + ", point=" + point + ", payment="
				+ payment + ", totalPrice=" + totalPrice + ", address=" + address + "]";
	}
}
