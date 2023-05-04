package com.esl.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.esl.ecommerce.entity.Orders;
import com.esl.ecommerce.entity.Users;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;
	
	public void sendMail(String toEmail, String subject, String body) {
			
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom("admin@gmail.com");
		msg.setTo(toEmail);
		msg.setSubject(subject);
		msg.setText(body);
		
		mailSender.send(msg);
			
	}

	public void sendOrderConfirmed(Users users, Orders order) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom("admin@gmail.com");
		msg.setTo(users.getEmail());
		msg.setSubject(order.getOrderId()+"Confirmed");
		msg.setText("Dear "+users.getFirstName()+" "+users.getLastName()+", Your order has been confirmed" );
		mailSender.send(msg);
		
	}
}
