package com.w2a.utilities;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;



public class MonitoringMail
{
	//public static void sendMail(String mailServer, String from,String username, String password,String port, String[] to, String subject, String messageBody, String attachmentPath, String attachmentName) throws MessagingException, AddressException
	public void sendMail(String mailServer, String from, String from_pass, String to, String subject, String messageBody) throws MessagingException, AddressException
	{
		boolean debug = false;
		final String username = from;
		final String password = from_pass;

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "25");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); //TLS

		Session session = Session.getInstance(prop,
		        new javax.mail.Authenticator() {
		            protected PasswordAuthentication getPasswordAuthentication() {
		                return new PasswordAuthentication(username, password);
		            }
		        });

		try {

		    Message message = new MimeMessage(session);
		    message.setFrom(new InternetAddress(from));
		    message.setRecipients(
		            Message.RecipientType.TO,
		            InternetAddress.parse(to)
		    );
		    message.setSubject(subject);
		    message.setText(messageBody);

		    Transport.send(message);

		    System.out.println("Email Sent: Done");

		} catch (MessagingException e) {
		    e.printStackTrace();
		}
	
	} 
	
	
	
	private class SMTPAuthenticator extends javax.mail.Authenticator
	{

	    public PasswordAuthentication getPasswordAuthentication()
	    {
	        String username = TestConfig.from;
	        String password = TestConfig.password;
	        return new PasswordAuthentication(username, password);
	    }
	}
	
	
	
}



