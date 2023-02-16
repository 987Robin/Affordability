package com.pma.afford.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import com.pma.afford.entities.User;
import com.pma.afford.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	private final JwtEncoder jwtEncoder;

	@Autowired
	PasswordEncoder passwordEncoder;

	// constructor Injection
	public UserServiceImpl(JwtEncoder jwtEncoder) {
		this.jwtEncoder = jwtEncoder;
	}

	@Override
	public String saveNewUser(User user) {

		if(userRepo.existsByUserMail(user.getUserMail())) {
			return "User already exists";
		} else {
			user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
			userRepo.save(user);
			return "User Saved successfully";
		}
	}

	@Override
	public String generateToken(Authentication authentication) {

		Instant now = Instant.now();
		String scope = authentication.getAuthorities().stream()
				.map(GrantedAuthority::getAuthority)
				.findFirst()
				.map(authority -> authority.isEmpty() ? "USER" : authority)
				.orElse("USER");
		JwtClaimsSet claims = JwtClaimsSet.builder()
				.issuer("girisharanreddy")
				.issuedAt(now)
				.expiresAt(now.plus(5, ChronoUnit.MINUTES))
				.subject(authentication.getName())
				.claim("scope", scope)
				.build();
		// JwsHeader jwsHeader = JwsHeader.with(() -> "HS256").build();
		return this.jwtEncoder.encode( JwtEncoderParameters.from(claims)).getTokenValue();
	}
}