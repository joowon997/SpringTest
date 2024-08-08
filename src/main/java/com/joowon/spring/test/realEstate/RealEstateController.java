package com.joowon.spring.test.realEstate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	
	
	
	
	
	
	
}
