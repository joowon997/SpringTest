package com.joowon.spring.test.store.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.joowon.spring.test.store.domain.Store;

@Mapper
public interface StoreRepository {
	
	public List<Store> getStroeList();
}
