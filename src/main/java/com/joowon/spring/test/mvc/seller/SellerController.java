package com.joowon.spring.test.mvc.seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joowon.spring.test.mvc.seller.domain.Seller;
import com.joowon.spring.test.mvc.seller.service.SellerService;

@Controller
@RequestMapping("/mvc/seller")
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	// 데이터 저장 과정을 진행할 페이지
	@PostMapping("/creat")
	public String createSeller(
			@RequestParam("nickName") String nickName
			, @RequestParam("temperature") double temperature
			, @RequestParam("profileImage") String profileImage) {
		
		int count = sellerService.addSeller(nickName, temperature, profileImage);
		
		// redirect:/ 후 url 이동할 주소입력 
		return "redirect:/mvc/seller/info";
	}
	
	
	@GetMapping("/input")
	public String sellerInput() {

		return "seller/addSeller";
	}
	
	@GetMapping("/info")
	public String sellerInfo(Model model
			, @RequestParam(required = false, value = "id") Integer id) {
		
			Seller seller = sellerService.searchSeller(id);
			
			model.addAttribute("result", seller);
				
		return "seller/sellerInfo";
	}
}
