package com.joowon.spring.test.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joowon.spring.test.store.domain.Store;
import com.joowon.spring.test.store.repository.StoreRepository;

@Service
public class StoreService {

	@Autowired
	private StoreRepository storeRepository;
	
	public List<Store> getStoreList() {
		
		return storeRepository.getStroeList();
	}
}
