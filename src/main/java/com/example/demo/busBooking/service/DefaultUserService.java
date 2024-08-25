package com.example.demo.busBooking.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.busBooking.DTO.BookingsDTO;
import com.example.demo.busBooking.DTO.UserRegisteredDTO;
import com.example.demo.busBooking.model.Bookings;
import com.example.demo.busBooking.model.User;

public interface DefaultUserService extends UserDetailsService{

	User save(UserRegisteredDTO userRegisteredDTO);

	Bookings updateBookings(BookingsDTO bookingDTO,UserDetails user);
	
	void sendEmail(BookingsDTO bookingDTO, User users, String nameGenrator);


	
}
