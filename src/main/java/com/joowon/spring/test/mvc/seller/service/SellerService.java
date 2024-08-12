package com.joowon.spring.test.mvc.seller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joowon.spring.test.mvc.seller.domain.Seller;
import com.joowon.spring.test.mvc.seller.repository.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository sellerRepository;
	
	
	public int addSeller(Seller seller) {
		
		return sellerRepository.addSellerOdject(seller);
	}
	
}
