package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Company;
import com.example.repository.CompanyRepository;

@Service
@Transactional
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
	public Company login(String companyId) {
		Company company = companyRepository.findByCompanyId(companyId);
		if(company == null) {
			return null;
		}
		return company;
	}
}
