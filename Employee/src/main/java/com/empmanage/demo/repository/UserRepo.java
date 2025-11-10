package com.empmanage.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empmanage.demo.entity.User;

public interface UserRepo extends JpaRepository<User, Long>
{
	User findByUsername(String username);
}
