package com.example.form;

import javax.validation.constraints.NotBlank;

/**
 * ログイン用フォーム
 * @author miyazawa
 *
 */
public class LoginForm {

	//	ユーザーid
	@NotBlank(message="ユーザーIDを入力してください")
	private String userId;
	//	パスワード
	@NotBlank(message="パスワードを入力してください")
	private String password;
	//	企業ID
	private String companyUse;
	private String companyId;
	
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
	public String getCompanyUse() {
		return companyUse;
	}
	public void setCompanyUse(String companyUse) {
		this.companyUse = companyUse;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	
	@Override
	public String toString() {
		return "LoginForm [userId=" + userId + ", password=" + password + ", companyUse=" + companyUse + ", companyId="
				+ companyId + "]";
	}
	
}
