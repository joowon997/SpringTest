package com.joowon.spring.test.ajax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joowon.spring.test.ajax.domain.Url;
import com.joowon.spring.test.ajax.repository.UrlRepository;

@Service
public class UrlService {
	
	@Autowired
	private UrlRepository urlrepository;
	
	public int addUrl(Url url) {
		
		return urlrepository.insertUrl(url);
	}
	
	public List<Url> selecturl() {
		
		return urlrepository.selectUrl();
	}
}
