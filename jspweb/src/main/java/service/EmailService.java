package service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {
	
	// 1. 필드 
	private String fromEmail = "rlacksgml99@naver.com";
	private String fromEmailPwd = "";
	

	// 2. 생성자
	public EmailService() {
		// TODO Auto-generated constructor stub
	}
	// 3. 메소드
	public boolean send(String contentHTML) {
		
		
		// 호스팅 설정 [ 네이버 기준 ] 
		Properties properties = new Properties(); // Properties : 키와 값으로 구성된 map 컬렉션 중 하나
		properties.put("mail.smtp.host", "smtp.naver.com"); 
		properties.put("mail.smtp.port", 587);
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
		
		
		Authenticator authenticator = new Authenticator() {
			// 패스워드 검증 함수
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(fromEmail, fromEmailPwd);
			}
		};
		
		Session session = Session.getDefaultInstance(properties, authenticator);
		
		try {

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromEmail));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress());
			message.setSubject("Ezen JSP회원가입 인증코드 발송");
			message.setText("이메일 인증 코드 : " + contentHTML);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
