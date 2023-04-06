package com.ashokit.email;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.mail.Authenticator;
import jakarta.mail.BodyPart;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import jakarta.mail.util.ByteArrayDataSource;

@Component
public class EmailUtils {
	@Value("${email.username}")
	private String username;
	@Value("${email.password}")
	private String password;

	public void sendMail(byte[] fileByteArr, String filetype) throws Exception {
		System.out.println(username+" *************");
		System.out.println(password+" *************");
		String to = "soumyaranjanpanda.199@gmail.com";// change accordingly
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		properties.setProperty("mail.smtp.port", "25");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		//mail.smtp.host=smtp.gmail.com, mail.smtp.port=25, mail.smtp.auth=true mail.smtp.starttls.enable=true
		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		// 2) compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Citizen Records");

			// 3) create MimeBodyPart object and set your message text
			BodyPart messageBodyPart1 = new MimeBodyPart();
			messageBodyPart1.setText("Hello Xxx, \nPlease find below citizen attachment.");

			// 4) create new MimeBodyPart object and set DataHandler object to this object
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();

			// String filename = "SendAttachment.java";//change accordingly
			DataSource source = null;
			if (filetype.equalsIgnoreCase("excel")) {
				source = new ByteArrayDataSource(fileByteArr, "application/vnd.ms-excel");
				messageBodyPart2.setDataHandler(new DataHandler(source));
				messageBodyPart2.setFileName("Citizen.xlsx");
			} else {
				source = new ByteArrayDataSource(fileByteArr, "application/vnd.pdf");
				messageBodyPart2.setDataHandler(new DataHandler(source));
				messageBodyPart2.setFileName("Citizen.pdf");
			}
			// 5) create Multipart object and add MimeBodyPart objects to this object
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart1);
			multipart.addBodyPart(messageBodyPart2);

			// 6) set the multiplart object to the message object
			message.setContent(multipart);

			// 7) send message
			Transport.send(message);

			System.out.println("message sent....");
		} catch (MessagingException ex) {
			ex.printStackTrace();
			throw new Exception("Error in mail sending");
		}
	}
}
