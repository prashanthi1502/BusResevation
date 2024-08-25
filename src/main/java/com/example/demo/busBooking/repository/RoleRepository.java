package com.example.demo.busBooking.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.busBooking.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

	Role findByRole(String name);
}