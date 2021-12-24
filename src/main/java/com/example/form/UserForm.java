package com.example.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

/**
 * ユーザー登録用フォーム
 * @author miyazawa
 *
 */
public class UserForm {

	//	名前
	@NotBlank(message="名前を入力してください")
	private String name;
	//	ユーザーid
	@NotBlank(message="ユーザーIDを入力してください")
	private String userId;
	//	パスワード
	@NotBlank(message="パスワードを入力してください")
	private String password;
	//	確認用パスワード
	private String ConfirmPassword;
	//	郵便番号
	private String zipcode;
	//	住所
	private String address;
	//	メール
	@NotBlank(message="メールアドレスを入力してください")
	@Email(message="メールアドレスの形式が不正です")
	private String email;
	//	性別
	private String gender;
	//	画像
	private MultipartFile imagePath;
	//	企業ID
	private String companyId;
	
	//	紹介コード
	private String havecode;
	private String usecode;
	
	//	利用区分
	private String purpose;
	
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
	public String getConfirmPassword() {
		return ConfirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		ConfirmPassword = confirmPassword;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public MultipartFile getImagePath() {
		return imagePath;
	}
	public void setImagePath(MultipartFile imagePath) {
		this.imagePath = imagePath;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	
	public String getHavecode() {
		return havecode;
	}
	public void setHavecode(String havecode) {
		this.havecode = havecode;
	}
	public String getUsecode() {
		return usecode;
	}
	public void setUsecode(String usecode) {
		this.usecode = usecode;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	@Override
	public String toString() {
		return "UserForm [name=" + name + ", userId=" + userId + ", password=" + password + ", zipcode=" + zipcode
				+ ", address=" + address + ", email=" + email + ", gender=" + gender + ", imagePath=" + imagePath
				+ ", havecode=" + havecode + ", usecode=" + usecode + "]";
	}
	
}
