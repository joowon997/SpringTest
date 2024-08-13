package com.joowon.spring.test.mvc.seller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joowon.spring.test.mvc.seller.domain.Seller;
import com.joowon.spring.test.mvc.seller.repository.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository sellerRepository;
	
	// 닉네임, 매너온도, 프로필 이미지 경로 전달 받고 판매자 정보 저장
	public int addSeller(
			String nickName
			, double temperature
			, String profileImage) {
		
		int count = sellerRepository.insertSeller(nickName, temperature, profileImage);
		
		return count;
	}
	
	// 선택된 id seller의 정보를 찾기
	public Seller searchSeller(Integer id) {
		
		if (id != null) {
			return sellerRepository.selectIdSeller(id);
		}else {
			return sellerRepository.selectLastSeller();
		}
	}
	
}
