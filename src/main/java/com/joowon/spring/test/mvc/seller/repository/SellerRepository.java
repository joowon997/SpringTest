package com.joowon.spring.test.mvc.seller.repository;

import org.apache.ibatis.annotations.Mapper;

import com.joowon.spring.test.mvc.seller.domain.Seller;

@Mapper
public interface SellerRepository {
	
	public int addSellerOdject(Seller seller);
}
