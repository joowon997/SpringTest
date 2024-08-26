package com.joowon.spring.test.ajax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joowon.spring.test.ajax.domain.Booking;
import com.joowon.spring.test.ajax.repository.BookingRepository;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	// 리스트 조회
	public List<Booking> bookingList(){
		return bookingRepository.selectBooking();
	}
	
	// 리스트 삭제
	public boolean bookingDelete(int id) {
		
		return bookingRepository.deleteBooking(id) != 0;
	}
	
	// 예약추가
	public boolean reservationInput(Booking booking) {
		booking.setState("대기중");
		return bookingRepository.insertBooking(booking) != 0;
	}

	// 예약 조회
	public Booking reservationSerch(String name, String phoneNember) {
		
		return bookingRepository.selectReservation(name, phoneNember);
	}
}
