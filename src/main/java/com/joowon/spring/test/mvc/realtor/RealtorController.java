package com.joowon.spring.test.mvc.realtor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joowon.spring.test.mvc.realtor.domain.Realtor;
import com.joowon.spring.test.mvc.realtor.service.RealtorService;

@Controller
@RequestMapping("/realtor")
public class RealtorController {
	
	// Service 연결
	@Autowired
	private RealtorService realtorService;
	
	// 입력화면
	@GetMapping("/creatRealtor")
	public String creatRealtor() {
		return "realtor/createRealtor";
	}
	
	// 받은 정보 저장 및 출력
	@PostMapping("/addRealtor")
	public String addRealtor(
			@RequestParam("name") String name
			, @RequestParam("phone") String phone
			, @RequestParam("address") String address
			, @RequestParam("grade") String grade
			, Model model) {
		
		Realtor realtor = new Realtor();
		realtor.setOffice(name);
		realtor.setPhoneNumber(phone);
		realtor.setAddress(address);
		realtor.setGrade(grade);
		
		// 받아온 파라메타 DB저장 후 id값 Realtor에 객체로 입력후 받아옴
		realtorService.addRealtor(realtor);
		
		// html로 Thymeleaf
		model.addAttribute("result", realtor);
		
		return "realtor/realtorInfo";
	}
	
	@GetMapping("/boot")
	public String bootstrap() {
		
		return "realtor/realtorInfo";
	}
}
