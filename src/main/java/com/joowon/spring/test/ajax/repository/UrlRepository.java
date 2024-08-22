package com.joowon.spring.test.ajax.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.joowon.spring.test.ajax.domain.Url;

@Mapper
public interface UrlRepository {

	public List<Url> selectUrl();
	
	public int insertUrl(Url url);
}
