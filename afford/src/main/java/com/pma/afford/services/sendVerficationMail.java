package com.pma.afford.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class sendVerficationMail {
	
	@Autowired
	JavaMailSender javaMailSender;
	
	private String generatedString;
	private int leftLimit = 48; // numeral '0'
	private int rightLimit = 122; // letter 'z'
	private int targetStringLength = 10;
	
	
	public Boolean sendMail(String eMail, String verfString) {
		
		SimpleMailMessage sMailMsg = new SimpleMailMessage();
		
		sMailMsg.setFrom("robinhob987@gmail.com");
		sMailMsg.setTo(eMail);
		sMailMsg.setSubject("Affordability Verification Mail");
		sMailMsg.setText("Verification Code : "+verfString);
		
		return true;
	}
	
	public String randomString() {
		
		Random random = new Random();
		String generatedString = random.ints(leftLimit, rightLimit + 1)
			      						.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
			      						.limit(targetStringLength)
			      						.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
			      						.toString();
				
		return generatedString;
	}
}
