package br.com.moacirlsj.enviando_email;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private String userName = "ricaom.sepol@gmail.com";
    private String passWord = "uneohqbnddgloggy";
	
	@org.junit.Test
    public void testEmail() {
		try {
		Properties prop = new Properties();
//		Properties prop = System.getProperties();
		
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
//		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.socketFactory.port", "465");
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		
//		prop.setProperty("mail.smtp.auth", "true");
//		prop.setProperty("mail.smtp.starttls", "true");
//		prop.setProperty("mail.smtp.host", "smtp.gmail.com");
//		prop.setProperty("mail.smtp.ssl.enable", "true");
//		prop.setProperty("mail.smtp.port", "587");
//		prop.setProperty("mail.smtp.socketFactory.port", "465");
//		prop.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		
		Session sess = Session.getInstance(prop, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				 
				return new PasswordAuthentication(userName, passWord);
			}
			
		});
		
			sess.setDebug(true);
		
			//Address[] toUsers = InternetAddress.parse("filho.ramos@marinha.mil.br, moaclope@gmail.com");
			Address[] toUsers = InternetAddress.parse("moaclope@gmail.com");
			Message message = new MimeMessage(sess);
			message.setFrom(new InternetAddress(userName));
			
			message.setRecipients(Message.RecipientType.TO, toUsers);
			message.setSubject("Teste de envio de email");
			message.setText("Teste com a ferramente automatizada de envio de email feita em Java.");
			Transport.send(message);
			System.out.println("Sent message successfully...");
		
		} catch (AddressException e) {
			e.printStackTrace();
		}catch (Exception e) {
		}
    }
}
