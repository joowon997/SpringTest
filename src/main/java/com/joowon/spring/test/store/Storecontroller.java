package com.joowon.spring.test.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joowon.spring.test.store.domain.Store;
import com.joowon.spring.test.store.service.StoreService;

@Controller
public class Storecontroller {

	@Autowired
	private StoreService storeService;
	
	@RequestMapping("/store/listJson")
	@ResponseBody
	public List<Store> StoreList(){
		
		return storeService.getStoreList();
	}
}
