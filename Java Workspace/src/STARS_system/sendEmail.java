package STARS_system;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class sendEmail implements sendNotifications {
	public void loginNotification(Student student)
	{
		
			System.out.println("System Processing......");	
			String sEmail = student.getEmail();
			final String username = "starsemailsender@gmail.com"; // to be added
			final String password = "Jacoblaw12"; // to be added

			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			Session session = Session.getInstance(props,
			  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			  });

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("STARS-Admin@gmail.com"));
				message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(sEmail)); // to be added an email addr
				message.setSubject("STARS Login");
				message.setText("Dear "+student.getName()+",\n\nYou have logged into STARS System as matric no: "+student.getMatricNo());

				Transport.send(message);

				System.out.println("Done");

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		
		
		
	}
	public void courseIndexRegNotification(Student student,String courseCode,String courseIndex)
	{
	
			System.out.println("System Processing......");	
			String sEmail = student.getEmail();
			final String username = "starsemailsender@gmail.com"; // to be added
			final String password = "Jacoblaw12"; // to be added

			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			Session session = Session.getInstance(props,
			  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			  });

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("STARS-Admin@gmail.com"));
				message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(sEmail)); // to be added an email addr
				message.setSubject("STARS Successful Registration");
				message.setText("Dear "+student.getName()+",\n\nYou have sucessfully registered for the Course "+courseCode+" Course Index "+courseIndex);

				Transport.send(message);

				System.out.println("Done");

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		}
		
	public void waitingListNotification(Student student,String courseCode,String courseIndex)
	{
	
			System.out.println("System Processing......");	
			String sEmail = student.getEmail();
			final String username = "starsemailsender@gmail.com"; // to be added
			final String password = "Jacoblaw12"; // to be added

			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			Session session = Session.getInstance(props,
			  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			  });

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("STARS-Admin@gmail.com"));
				message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(sEmail)); // to be added an email addr
				message.setSubject("STARS Waiting List notification");
				message.setText("Dear "+student.getName()+",\n\nYou have been placed on the waiting list for the Course "+courseCode+" Course Index "+courseIndex);

				Transport.send(message);

				System.out.println("Done");

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		}
	public void exitWaitingListNotification(Student student,String courseCode,String courseIndex)
	{
	
			System.out.println("System Processing......");	
			String sEmail = student.getEmail();
			final String username = "starsemailsender@gmail.com"; // to be added
			final String password = "Jacoblaw12"; // to be added

			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			Session session = Session.getInstance(props,
			  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			  });

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("STARS-Admin@gmail.com"));
				message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(sEmail)); // to be added an email addr
				message.setSubject("STARS STARS Successful Registration");
				message.setText("Dear "+student.getName()+",\n\nYou have successful registered for the Course "+courseCode+" Course Index "+courseIndex + " and taken off the waiting list");

				Transport.send(message);

				System.out.println("Done");

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		}
	
}
