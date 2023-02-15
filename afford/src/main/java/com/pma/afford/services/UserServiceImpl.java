package com.pma.afford.services;

import com.nimbusds.jose.jwk.source.ImmutableSecret;
import com.nimbusds.jose.jwk.source.JWKSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

import com.pma.afford.entities.UserEntity;
import com.pma.afford.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	JwtEncoder jwtEncoder;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public String saveNewUser(UserEntity user) {

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
				.collect(Collectors.joining(" "));
		JwtClaimsSet claims = JwtClaimsSet.builder()
				.issuer("girisharanreddy")
				.issuedAt(now)
				.expiresAt(now.plus(1, ChronoUnit.MINUTES))
				.subject(authentication.getName())
				.claim("scope", scope)
				.build();
		JwsHeader jwsHeader = JwsHeader.with(() -> "HS256").build();
		return this.jwtEncoder.encode( JwtEncoderParameters.from(jwsHeader,claims)).getTokenValue();
	}
}