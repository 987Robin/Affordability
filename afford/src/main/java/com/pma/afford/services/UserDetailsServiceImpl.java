package com.pma.afford.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pma.afford.entities.UserEntity;
import com.pma.afford.repositories.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		final UserEntity customer = userRepo.findByUserMail(username);
		
		if(customer == null) {
			throw new UsernameNotFoundException(username);
		}
		
		UserDetails user = User.withUsername(customer.getUserMail()) // checking for username
								.password(customer.getUserPassword()) // checking whether password
								.authorities("USER") //giving the role as user by default
								.build();
		
		return user;
	}
}
