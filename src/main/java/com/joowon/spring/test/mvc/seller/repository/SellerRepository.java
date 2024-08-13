package com.joowon.spring.test.mvc.seller.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.joowon.spring.test.mvc.seller.domain.Seller;


@Mapper
public interface SellerRepository {
	
	// 닉네임, 매너온도, 프로필 이미지 경로 전달 받고 한행을 insert 하는기능
	public int insertSeller(
			@Param("nickName") String nickName
			,@Param("temperature") double temperature
			,@Param("profileImage") String profileImage);
	
	// 가장 최근에 추가된 seller의 정보를 찾기
	public Seller selectLastSeller();

	// 선택한 Id에 해당한 seller의 정보를 찾기
	public Seller selectIdSeller(@Param("id") int id);
	
	
}
