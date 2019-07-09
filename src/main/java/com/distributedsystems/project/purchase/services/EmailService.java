package com.distributedsystems.project.purchase.services;

public interface EmailService {

	void sendEmail(String to, String subject, String text);
}
