package com.joowon.spring.test.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joowon.spring.test.jpa.domain.Company;
import com.joowon.spring.test.jpa.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
	public Company addCompany(String name, String business, String scale, int headcount) {
		
		Company company = Company.builder()
							.name(name)
							.business(business)
							.scale(scale)
							.headcount(headcount)
							.build();
		
		return companyRepository.save(company);
	}
	
	public Company updateCompany(int id, String scale, int headcount) {
		// 업데이트 할 id 정보 조회
		Optional<Company> optionalCompany = companyRepository.findById(id);
		Company company = optionalCompany.orElse(null);
		
		// 업데이트 기능 수행
		company = company.toBuilder()
					.scale(scale)
					.headcount(headcount)
					.build();
		// 업데이트 기능 저장
		company = companyRepository.save(company);
		
		return company;
	}
	
	public void deleteCompany(int id) {
		// 삭제할 id 조회
		Optional<Company> optionalCompany = companyRepository.findById(id);
		Company company = optionalCompany.orElse(null);
		
		// 조회정보 삭제
		
		companyRepository.delete(company);
	}
}
