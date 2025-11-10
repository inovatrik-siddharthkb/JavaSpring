package com.empmanage.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.empmanage.demo.dto.AuthRequestDTO;
import com.empmanage.demo.dto.AuthResponseDTO;
import com.empmanage.demo.entity.User;
import com.empmanage.demo.repository.UserRepo;
import com.empmanage.demo.util.JwtUtil;

import jakarta.validation.Valid;

@RestController
public class AuthController 
{
	@Autowired
	private UserRepo userRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/register")
	public String register(@Valid @RequestBody AuthRequestDTO authRequest)
	{
		User user = new User();
		user.setUsername(authRequest.getUsername());
		user.setPassword(encoder.encode(authRequest.getPassword()));
		userRepository.save(user);
		return "User registered successfully.";
	}
	
	@PostMapping("/authenticate")
	public AuthResponseDTO authenticate(@Valid @RequestBody AuthRequestDTO authRequest)
	{
		User dbUser = userRepository.findByUsername(authRequest.getUsername());
		if(dbUser != null && encoder.matches(authRequest.getPassword(), dbUser.getPassword()))
		{
			String token = jwtUtil.generateToken(authRequest.getUsername());
			return new AuthResponseDTO(token);
		}
		throw new RuntimeException("Invalid username or password.");
	}
}
