package com.joowon.spring.test.realEstate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joowon.spring.test.realEstate.domain.RealEstate;
import com.joowon.spring.test.realEstate.reporsitory.RealEstateReporsitory;

@Service
public class RealEstateService {

	@Autowired
	private RealEstateReporsitory realEstateReporsitory;
	
	public RealEstate getEstateIdInfo(int id) {
		return realEstateReporsitory.selectForId(id);
	}
	
	public List<RealEstate> getEstateRentPriceInfo(int rentPrice) {
		return realEstateReporsitory.selectForRentPrice(rentPrice);
	}
	
	public List<RealEstate> getEstateAreaAndPriceInfo(int area, int price){
		return realEstateReporsitory.selectForAreaAndPeice(area, price);
	}
	
	public int insertEstate(RealEstate realEstate) {
		
		int count = realEstateReporsitory.insertEstate(realEstate);
		
		return count;
	}
	
	public int insertParameterEstate(
			int realtorId
			, String address
			, int area
			, String type
			, int price
			,int rentPrice) {
		
		int count = realEstateReporsitory.insertParameterEstate(realtorId, address, area, type, price, rentPrice);
		return count;
	}
	
	public int updateRealEstate(int id, String type, int price){
		
		int count = realEstateReporsitory.updateRealEstate(id, type, price);
		return count;
	}
	
	public int deleteRealEstate(int id){
		
		int count = realEstateReporsitory.deleteRealEstate(id);
		return count;
	}
	
}
