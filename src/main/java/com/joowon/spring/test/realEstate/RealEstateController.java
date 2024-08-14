package com.joowon.spring.test.realEstate;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joowon.spring.test.realEstate.domain.RealEstate;
import com.joowon.spring.test.realEstate.service.RealEstateService;

@RestController
@RequestMapping("/realEstate")
public class RealEstateController {

	@Autowired
	private RealEstateService realEstateService;
	
	@RequestMapping("/id")
	public RealEstate selectID(@RequestParam("id") int id) {
		
		return realEstateService.getEstateIdInfo(id);
	}
	
	
	@RequestMapping("/rentPrice")
	public List<RealEstate> selectRentPrice(@RequestParam("rentPrice") int rentPrice) {
		
		return realEstateService.getEstateRentPriceInfo(rentPrice);
	}
	
	@RequestMapping("/areaAndPrice")
	public List<RealEstate> selectAreaAndPrice(@RequestParam("area") int area, @RequestParam("price") int price){
		return realEstateService.getEstateAreaAndPriceInfo(area, price);
	}
	
	@RequestMapping("/insert/1")
	public String insertEstate() {
//		realtorId : 3
//		address : 푸르지용 리버 303동 1104호
//		area : 89
//		type : 매매
//		price : 100000
		RealEstate realEstate = new RealEstate();
		
		realEstate.setRealtorId(3);
		realEstate.setAddress("푸르지용 리버 303동 1104호");
		realEstate.setArea(89);
		realEstate.setType("매매");
		realEstate.setPrice(100000);
		
		int count = realEstateService.insertEstate(realEstate);
		
		return "입력 성공 : " + count;
	}
	
	@RequestMapping("/insert/2")
	public String insertParameterEstate(@RequestParam("realtorId") int realtorId) {
		
//		address : 썅떼빌리버 오피스텔 814호
//		area : 45
//		type : 월세
//		price : 100000
//		rentPrice : 120
		int count = realEstateService.insertParameterEstate(realtorId, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
		
		return "입력 성공 : " + count;
	}
	
	@RequestMapping("/update")
	public String updateRealEstate() {
//		id가 22 인 행의 type 을 전세로 바꾸고 price 를 70000으로 변경하세요.
		
		int count = realEstateService.updateRealEstate(22, "전세", 70000);
		
		return "수정 성공 : " + count;
	}
	
	@RequestMapping("/delete")
	public String deletRealEstate(@RequestParam("id") int id) {
		int count = realEstateService.deleteRealEstate(id);
		
		return "삭제 개수 : " + count;
	}
	
	
}
