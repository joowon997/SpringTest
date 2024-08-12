package com.joowon.spring.test.mvc.seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.joowon.spring.test.mvc.seller.domain.Seller;
import com.joowon.spring.test.mvc.seller.service.SellerService;

@Controller
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	@GetMapping("/mvc/seller/insert")
	public String createUser(Model model) {
		
		Seller createUser = new Seller();
		model.addAttribute("result", createUser);
		
		sellerService.addSeller(createUser);
		
		return "seller/addSeller";
	}
}
