package com.esl.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;
	
	public void sendMail(String toEmail, String subject, String body) {
			
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom("1011@gmail.com");
		msg.setTo(toEmail);
		msg.setSubject(subject);
		msg.setText(body);
		
		mailSender.send(msg);
			
	}
}
