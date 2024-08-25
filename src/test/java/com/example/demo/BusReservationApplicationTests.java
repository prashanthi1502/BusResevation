package com.example.demo;



import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import com.example.demo.busBooking.DTO.ReservationDTO;
import com.example.demo.busBooking.DTO.UserRegisteredDTO;
import com.example.demo.busBooking.model.BusData;
import com.example.demo.busBooking.repository.BusDataRepository;
import com.example.demo.busBooking.repository.UserRepository;
import com.example.demo.busBooking.service.DefaultUserService;

@SpringBootTest
class BusBookingSystemApplicationTests {

	@Autowired
	DefaultUserService userService;
	@Autowired
	UserRepository userRepo;
	@Autowired
	BusDataRepository busDataRepository;

	
	@Test
	public void registerAndLoginWithUserAccount() {
		UserRegisteredDTO userRegisteredDTO = new UserRegisteredDTO();
		userRegisteredDTO.setEmail_id("temp@gmail.com");
		userRegisteredDTO.setName("Temp");
		userRegisteredDTO.setPassword("12345");
		userRegisteredDTO.setRole("USER");
		userService.save(userRegisteredDTO);
		Assert.notNull(userRepo.findByEmail("temp@gmail.com"), "User found in DB");
		UserDetails user = userService.loadUserByUsername("temp@gmail.com");
		Assert.notNull(user, "Logined successfully");
	}
	
	@Test
	public void registerAndLoginAdminAccount() {
		UserRegisteredDTO userRegisteredDTO = new UserRegisteredDTO();
		userRegisteredDTO.setName("ABC");
		userRegisteredDTO.setEmail_id("temp1@gmail.com");
		userRegisteredDTO.setPassword("12345");
		userRegisteredDTO.setRole("ADMIN");
		userService.save(userRegisteredDTO);
		Assert.notNull(userRepo.findByEmail("temp1@gmail.com"), "Register successful");
		UserDetails user = userService.loadUserByUsername("temp1@gmail.com");
		Assert.notNull(user, "User Login Successful");
	} 
	
	
	@Test
	public void saveBusDataByAdminAccount() {
		UserRegisteredDTO userRegisteredDTO = new UserRegisteredDTO();
		userRegisteredDTO.setName("ABC");
		userRegisteredDTO.setEmail_id("temp12@gmail.com");
		userRegisteredDTO.setPassword("12345");
		userRegisteredDTO.setRole("ADMIN");
		userService.save(userRegisteredDTO);
		Assert.notNull(userRepo.findByEmail("temp12@gmail.com"), "Register successful");
		UserDetails user = userService.loadUserByUsername("temp12@gmail.com");
		Assert.notNull(user, "User Login Successful");
		BusData busData = new BusData();
		busData.setBusName("TestBus");
		busData.setFromDestination("ND");
		busData.setToDestination("AMT");
		busData.setFilterDate("2022-11-10");
		busData.setTime("11:25");
		busData.setPrice(40.0);
		BusData bs = busDataRepository.save(busData);
		Assert.notNull(bs, "Busdata Saved Successfully");
	} 

	
	@Test
	public void fetchBusData() {
		ReservationDTO rs = new ReservationDTO();
		rs.setFrom("ND");
		rs.setTo("AMT");
		rs.setFilterDate("2022-11-10");
		List<BusData> bs = busDataRepository.findByToFromAndDate(rs.getTo(), rs.getFrom(), rs.getFilterDate());
		Assert.notEmpty(bs, "Bus Data available with above filters ");
	}
	 
}