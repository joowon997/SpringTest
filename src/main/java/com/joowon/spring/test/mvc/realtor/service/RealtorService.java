package com.joowon.spring.test.mvc.realtor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joowon.spring.test.mvc.realtor.domain.Realtor;
import com.joowon.spring.test.mvc.realtor.repository.RealtorRepository;

@Service
public class RealtorService {
	
	@Autowired
	private RealtorRepository realtorRepository;
	
	public int addRealtor(Realtor realtor) {
		
		return realtorRepository.insertRealtor(realtor);
	}
}
