package com.example.form;

public class ItemForm {

	//	商品名
	private String name;
	//	商品説明
	private String description;
	//	価格
	private Integer price;
	//	商品画像
	private String imagePath;
	//	商品分類
	private String category;
	//	ユーザーID
	private String userId;
	//	在庫数
	private Integer stock;
	
	public ItemForm() {
	}

	//	GetterとSetter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
}
