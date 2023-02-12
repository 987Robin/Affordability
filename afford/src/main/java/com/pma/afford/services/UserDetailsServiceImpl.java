package com.pma.afford.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pma.afford.entities.UserDetailsClass;
import com.pma.afford.repositories.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetailsClass user = userRepo.findByUserMail(username).map(UserDetailsClass::new).orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
		return user;
	}

}
