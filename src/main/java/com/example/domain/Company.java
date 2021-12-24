package com.example.domain;

public class Company {

	//	ID
	private Integer id;
	//	企業ID
	private Integer companyId;
	//	企業名
	private String companyName;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	@Override
	public String toString() {
		return "Company [id=" + id + ", company_id=" + companyId + ", company_name=" + companyName + "]";
	}
	
}
