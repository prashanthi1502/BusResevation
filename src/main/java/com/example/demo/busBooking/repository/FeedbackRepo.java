package com.example.demo.busBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.busBooking.model.Feedback;

public interface FeedbackRepo extends JpaRepository<Feedback, Integer>{

}