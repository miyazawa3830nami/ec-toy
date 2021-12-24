package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Company;

@Repository
public class CompanyRepository {

	private static final RowMapper<Company> COMPANY_ROW_MAPPER = (rs,i) ->{
		Company company = new Company();
		company.setId(rs.getInt("id"));
		company.setCompanyId(rs.getInt("company_id"));
		company.setCompanyName(rs.getString("company_name"));
		return company;
	};
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	public Company findByCompanyId(String companyId) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("companyId", companyId);
		String findByCompanyIdSql = "SELECT * FROM companies WHERE company_id = :companyId;";
		try {
			Company company = template.queryForObject(findByCompanyIdSql, param, COMPANY_ROW_MAPPER);
			return company;
		} catch(Exception e) {
			return null;
		}
	}
}
