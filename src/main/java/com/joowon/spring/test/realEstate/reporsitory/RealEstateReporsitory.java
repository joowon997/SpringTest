package com.joowon.spring.test.realEstate.reporsitory;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.joowon.spring.test.realEstate.domain.RealEstate;

@Mapper
public interface RealEstateReporsitory {

	public RealEstate selectForId(@Param("id") int id); 
	
	public List<RealEstate> selectForRentPrice(@Param("rentPrice") int rentPrice);

	public List<RealEstate> selectForAreaAndPeice(
			@Param("area") int area
			, @Param("price") int price);

	public int insertEstate(RealEstate realEstate);

	public int insertParameterEstate(
			@Param("realtorId") int realtorId
			, @Param("address") String address
			, @Param("area") int area
			, @Param("type") String type
			, @Param("price") int price
			, @Param("rentPrice") int rentPrice);
	
	public int updateRealEstate(
			@Param("id") int id
			, @Param("type") String type
			, @Param("price") int price);
	
	public int deleteRealEstate(@Param("id") int id);
	
}
