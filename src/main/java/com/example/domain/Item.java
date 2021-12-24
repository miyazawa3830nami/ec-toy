package com.example.domain;

import java.sql.Timestamp;

import java.util.List;

/**
 * 商品ドメイン
 * @author
 *
 */
public class Item {

	//	id
	private Integer id;
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
	//	いいね数
	private Integer good;
	//	削除フラグ
	private Boolean deleted;
	//	登録日
	private Timestamp createdAt;
	//	更新日
	private Timestamp updatedAt;
	
	//	引数なし
	public Item() {
	}

	//	引数あり
	public Item(Integer id, String name, String description, Integer price, String imagePath, String category,
			String userId, Integer stock, Integer good, Boolean deleted, Timestamp createdAt, Timestamp updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imagePath = imagePath;
		this.category = category;
		this.userId = userId;
		this.stock = stock;
		this.good = good;
		this.deleted = deleted;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	//	GetterとSetter
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public Integer getGood() {
		return good;
	}
	public void setGood(Integer good) {
		this.good = good;
	}
	public Boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", imagePath=" + imagePath + ", category=" + category + ", userId=" + userId + ", stock=" + stock
				+ ", good=" + good + ", deleted=" + deleted + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ "]";
	}

}
