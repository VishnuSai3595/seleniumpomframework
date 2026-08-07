package dmeo;

import java.io.File;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class EmailSender {
	
	public static void main(String[] args) {
		
		final String senderemail = "qalearningautomationtest@gmail.com";
		final String apppassword = "dsrcjfgiezgrybrw";
		final String recipientemail = "qalearningautomationtest@gmail.com";
		
//		adding SMTP server properties
		
		Properties prop = new Properties();
		
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.host","smtp.gmail.com");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.port", "587");
		
//		creating authentication session
		
		Session session = Session.getInstance(prop,new Authenticator() {
		
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication(senderemail, apppassword);
			}
		
		});
		
		session.setDebug(true);
		
//		creating an email
		
		try {
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(senderemail));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(recipientemail));
			message.setSubject("Test email from java selenium jakarta mail dependency");
//			message.setText("Hello\n\nThis is wonderful\n\nyou got your dream job");
//			email Bodypart
			MimeBodyPart textpart = new MimeBodyPart();
			textpart.setText("Hello\n\nCongratulations\n\nyou fot your dream job\n\nREgards\n\nXyZ company");
//			email attachmentpart
			MimeBodyPart attachmentpart = new MimeBodyPart();
			String filepath = System.getProperty("user.dir")+"/reports/ExtentReport2026-34-06_16-34-55.html";
			System.out.println("Attachment part is :"+filepath);
			attachmentpart.attachFile(new File(filepath));
			
//			combine bodypart and attachment part
			MimeMultipart multipart = new MimeMultipart();
			multipart.addBodyPart(textpart);
			multipart.addBodyPart(attachmentpart);
			message.setContent(multipart);
			
			
//			send mail
			Transport.send(message);
			System.out.println("email sent successfullyo");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		
	}

}
