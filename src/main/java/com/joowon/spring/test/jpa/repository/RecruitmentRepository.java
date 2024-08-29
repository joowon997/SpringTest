package com.joowon.spring.test.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.joowon.spring.test.jpa.domain.Recruitment;

public interface RecruitmentRepository extends JpaRepository<Recruitment, Integer>{

	//	Request Parameter로 전달 받은 company id로 해당하는 회사의 공고를 조회하세요.
	public List<Recruitment> findTop1ByCompanyIdOrderByIdDesc(int compantId);
	
	// 웹 back-end 개발자 이고 정규직인 공고를 조회하고 아래와 같이 출력하세요
	public List<Recruitment> findByPositionAndType(String position, String type);

	// 정규직이거나 연봉이 9000 이상인 공고를 조회하고 아래와 같이 출력하세요.
	public List<Recruitment> findByTypeOrSalaryAfter(String type, int salary);
	
	// 계약직 목록을 연봉 기준으로 내림차순 정렬해서 3개만 조회하세요
	public List<Recruitment> findTop3ByTypeOrderBySalaryDesc(String type);	

	// 성남시 분당구가 지역인 연봉 7000 이상 8500 이하인 공고를 조회하고 아래와 같이 출력하세요.
	public List<Recruitment> findByRegionAndSalaryBetween(String region, int min, int max);

	// 마감일이 2026-04-10 이후이고 연봉이 8100 이상인 정규직 공고를 연봉 내림차순으로 조회하세요.
	@Query(value = "SELECT * FROM `recruitment` WHERE `deadline` > :deadline AND `salary` >= :salary ORDER BY `salary` DESC", nativeQuery = true)
	public List<Recruitment> selectBydeadlineAndsalary(
								@Param("deadline") String deadline
								, @Param("salary") int salary);
	
}