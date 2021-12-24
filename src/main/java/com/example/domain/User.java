package com.example.domain;

import java.sql.Timestamp;

/**
 * ユーザードメイン
 * @author miyazawa
 *
 */
public class User {

	//	ID
	private Integer id;
	//	名前
	private String name;
	//	ユーザーID
	private String userId;
	//	パスワード
	private String password;
	//	メール
	private String email;
	//	郵便番号
	private String zipcode;
	//	住所
	private String address;
	//	画像
	private String imagePath;
	//	企業ID
	private Integer companyId;
	//	ポイント
	private Integer point;
	//	削除
	private boolean deleted;
	//	登録日
	private Timestamp createdAt;
	//	更新日
	private Timestamp updatedAt;
	
	//	引数なし
	public User() {}
	//	引数あり
	public User(Integer id, String name, String userId, String password, String email, String zipcode, String address,
			String imagePath, Integer companyId, Integer point, boolean deleted, Timestamp createdAt,
			Timestamp updatedAt) {
		this.id = id;
		this.name = name;
		this.userId = userId;
		this.password = password;
		this.email = email;
		this.zipcode = zipcode;
		this.address = address;
		this.imagePath = imagePath;
		this.companyId = companyId;
		this.point = point;
		this.deleted = deleted;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	//	getterとsetter
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
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
		return "User [id=" + id + ", name=" + name + ", userId=" + userId + ", password=" + password + ", email="
				+ email + ", zipcode=" + zipcode + ", address=" + address + ", imagePath=" + imagePath + ", companyId="
				+ companyId + ", point=" + point + ", deleted=" + deleted + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + "]";
	}
	
}
