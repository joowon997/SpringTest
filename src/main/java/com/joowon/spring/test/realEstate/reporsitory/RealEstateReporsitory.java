package com.joowon.spring.test.realEstate.reporsitory;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.joowon.spring.test.realEstate.domain.RealEstate;

@Mapper
public interface RealEstateReporsitory {

	public RealEstate selectForId(@Param("id") int id); 
	
	public List<RealEstate> selectForRentPrice(@Param("rentPrice") int rentPrice);

	public List<RealEstate> selectForAreaAndPeice(@Param("area") int area, @Param("price") int price);
}
