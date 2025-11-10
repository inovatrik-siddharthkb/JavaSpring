package com.empmanage.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.empmanage.demo.entity.User;
import com.empmanage.demo.repository.UserRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService 
{
	@Autowired
    private UserRepo userRepo;
	
	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
        User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities(new ArrayList<>())
                .build();
    }
}
