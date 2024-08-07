package com.joowon.spring.test.lifecycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test03 {
	
	@RequestMapping("/lifecycle/test03/1")
	public String menuList() {
		return "lifecycle/test03";
	}
}
