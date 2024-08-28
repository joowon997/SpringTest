package com.joowon.spring.test.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joowon.spring.test.jpa.domain.Company;
import com.joowon.spring.test.jpa.service.CompanyService;

@Controller
@RequestMapping("/jpa/company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	
	@GetMapping("/create")
	@ResponseBody
	public List<Company> createCompany(){
		
//		회사명 : 넥손
//		사업내용 : 컨텐츠 게임
//		규모 : 대기업
//		사원수 : 3585명
//		
//		회사명 : 버블팡
//		사업내용 : 여신 금융업
//		규모 : 대기업
//		사원수 : 6834명
		List<Company> companyList = new ArrayList<>();
		
		Company company = companyService.addCompany("넥손", "컨텐츠 게임", "대기업", 3585);
		companyList.add(company);
		
		company = companyService.addCompany("버블팡", "여신 금융업", "대기업", 6834);
		companyList.add(company);
		
		return companyList;
	}
	
	@GetMapping("/update")
	@ResponseBody
	public Company updateCompany() {
//		버블팡이 극심한 경영 악화로 회사 정보가 변경되었다.
//		규모를 중소기업, 사원수를 34명 으로 수정하세요. (버블팡의 pk id번호로 업데이트 - workbench에서 조회)
//		수정된 내용을 아래와 같이 출력 하세요
		
		Company company = companyService.updateCompany(12, "중소기업", 34);
		
		return company;
	}
	
	@GetMapping("/delete")
	@ResponseBody
	public String deleteCompany() {
		
		companyService.deleteCompany(9);
		
		return "삭제 완료!!";
	}
	
}
