package com.joowon.spring.test.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ajax/booking")
public class BookingController {

	@GetMapping("/main")
	public String main() {
		return "ajax/booking/main";
	}

	@GetMapping("/list")
	public String reservationList() {
		return "ajax/booking/reservationList";
	}

	@GetMapping("/reservation")
	public String reservationInput() {
		return "ajax/booking/reservationInput";
	}
	
	
}
