package com.joowon.spring.test.ajax;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joowon.spring.test.ajax.domain.Booking;
import com.joowon.spring.test.ajax.service.BookingService;

@Controller
@RequestMapping("/ajax/booking")
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	// view
	// 메인화면
	@GetMapping("/main")
	public String main() {
		return "ajax/booking/main";
	}

	// 예약목록
	@GetMapping("/list")
	public String reservationList(Model model) {
		
		List<Booking> bookingList = bookingService.bookingList();
		
		model.addAttribute("bookingList", bookingList);
		
		return "ajax/booking/reservationList";
	}

	//예약하기
	@GetMapping("/reservation")
	public String reservation() {
		return "ajax/booking/reservationInput";
	}
	

	//API
	// 리스트 삭제
	@GetMapping("/delete")
	@ResponseBody
	public Map<String, String> listDelete(
			@RequestParam("id") int id){
		
		 Map<String, String> deleteMap = new HashMap<>();
		 if (bookingService.bookingDelete(id)) {
			deleteMap.put("isDelete","success");
		}else {
			deleteMap.put("isDelete","fail");
		}
		 
		return deleteMap;
	}
	
	//예약 추가하기
	@GetMapping("/create")
	@ResponseBody
	public Map<String, Boolean> addReservation(
			@RequestParam("name") String name
			,@RequestParam("headcount") int headcount
			,@RequestParam("day") int day
			,@RequestParam("date") @DateTimeFormat(pattern = "yyyy년 M월 d일") LocalDate date
			,@RequestParam("phoneNumber") String phoneNumber
			,Model model){
		
		Booking reservation = new Booking();
		reservation.setName(name);
		reservation.setHeadcount(headcount);
		reservation.setDay(day);
		reservation.setDate(date);
		reservation.setPhoneNumber(phoneNumber);
		
		Map<String, Boolean> insertMap = new HashMap<>();
		
		if (bookingService.reservationInput(reservation)) {
			insertMap.put("isInput", true);
		}else {
			insertMap.put("isInput", false);
		}
		return insertMap;
	}
	
	// 예약확인
	@GetMapping("/serch")
	@ResponseBody
	public Booking serch(
			@RequestParam("name") String name
			,@RequestParam("phoneNember") String phoneNember
			,Model model){
		
		return bookingService.reservationSerch(name, phoneNember);
	}
	
}
