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
	
	// url추가하는 API
	public int addUrl(Url url) {
		
		return urlrepository.insertUrl(url);
	}
	
	// url 중복확인하는 API
	public boolean isDuplicateUrl(String url) {
		
		int count = urlrepository.selectCountByUrl(url);
		
		if (count == 0) {
			//중복하지 않음
			return false;
		}else {
			//중복됨
			return true;
		}
	}
	
	// url 삭제 API
	public boolean deleteUrl(int id) {
		
		return urlrepository.deleteUrl(id) != 0;
	}
	
	// 리스트 불어오는 기능
	public List<Url> selecturl() {
		
		return urlrepository.selectUrl();
	}
}
