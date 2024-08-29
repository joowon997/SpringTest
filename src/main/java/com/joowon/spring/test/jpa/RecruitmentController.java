package com.joowon.spring.test.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joowon.spring.test.jpa.domain.Recruitment;
import com.joowon.spring.test.jpa.repository.RecruitmentRepository;

@Controller
@RequestMapping("/jpa/recruitment")
@ResponseBody
public class RecruitmentController {

	@Autowired
	private RecruitmentRepository recruitmentRepository;
	
	@GetMapping("/findById")
	public Recruitment selectById() {
//		id가 8인 공고를 조회하고 아래와 같이 출력하세요.
		Optional<Recruitment> optionalRecruitment = recruitmentRepository.findById(8);
		
		Recruitment result = optionalRecruitment.orElse(null);
		
		return result;
	}
	
	@GetMapping("/findByCompanyId")
	public List<Recruitment> selectByCompanyId(
			@RequestParam("companyId") int companyId){
//		Request Parameter로 전달 받은 company id로 해당하는 회사의 공고를 조회하세요.
		List<Recruitment> recruitmentList = new ArrayList<>();
		
		recruitmentList = recruitmentRepository.findTop1ByCompanyIdOrderByIdDesc(companyId);
		return recruitmentList;
	}
	
	@GetMapping("/selectByPositionAndType")
	public List<Recruitment> selectByPositionAndType(){
		List<Recruitment> recruitmentList = new ArrayList<>();
		recruitmentList = recruitmentRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
		
		return recruitmentList;
	}
	
	@GetMapping("/findByTypeOrSalaryAfter")
	public List<Recruitment> findByTypeOrSalaryAfter(){
		List<Recruitment> recruitmentList = new ArrayList<>();
		recruitmentList = recruitmentRepository.findByTypeOrSalaryAfter("정규직", 8999);
		
		return recruitmentList;
	}

	@GetMapping("/findTop3ByTypeOrderBySalaryDesc")
	public List<Recruitment> findTop3ByTypeOrderBySalaryDesc(){
		List<Recruitment> recruitmentList = new ArrayList<>();
		recruitmentList = recruitmentRepository.findTop3ByTypeOrderBySalaryDesc("계약직");
		
		return recruitmentList;
	}

	@GetMapping("/findByRegionAndSalaryBetween")
	public List<Recruitment> findByRegionAndSalaryBetween(){
		List<Recruitment> recruitmentList = new ArrayList<>();
		recruitmentList = recruitmentRepository.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8500);
		
		return recruitmentList;
	}
	
	@GetMapping("/nativeQuery")
	public List<Recruitment> nativeQuery(){
		List<Recruitment> recruitmentList = new ArrayList<>();
		recruitmentList = recruitmentRepository.selectBydeadlineAndsalary("2026-04-10 00:00:00", 8100);
		
		return recruitmentList;
	}
	
}
