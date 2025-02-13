package org.jsp.College_Directory_Application.util;
import org.jsp.College_Directory_Application.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class OtpHelper {
	@Autowired
	private JavaMailSender javaMailSender;

	public void sendAccountCreationEmail(User user) {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
		try {
			helper.setTo(user.getEmail());
			helper.setSubject("Account Created Successfully");
			String mailContent = "<!DOCTYPE html>" + "<html lang='en'>" + "<head>" + "    <meta charset='UTF-8'>"
					+ "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>"
					+ "    <title>Account Creation</title>" + "    <style>" + "        body {"
					+ "            background-color: #f4f4f9;" + "            font-family: Arial, sans-serif;"
					+ "            color: #333;" + "            padding: 20px;" + "            text-align: center;"
					+ "        }" + "        .email-container {" + "            background-color: #ffffff;"
					+ "            padding: 30px;" + "            border-radius: 10px;"
					+ "            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);" + "            margin: 20px auto;"
					+ "            max-width: 600px;" + "        }" + "        h1 {" + "            color: #007BFF;"
					+ "        }" + "        .otp-code {" + "            font-size: 24px;"
					+ "            font-weight: bold;" + "            color: #28A745;" + "            margin-top: 20px;"
					+ "        }" + "        .footer {" + "            margin-top: 40px;"
					+ "            font-size: 12px;" + "            color: #999;" + "        }" + "    </style>"
					+ "</head>" + "<body>" + "    <div class='email-container'>" + "        <h1>Dear " + user.getName()
					+ ",</h1>" + "        <p>Your account has been created successfully! Welcome aboard.</p>"
					+ "        <p>Your One-Time Password (OTP) is:</p>" + "        <div class='otp-code'>"
					+ user.getOtp() + "</div>"
					+ "        <p>Please use this OTP to verify your account and complete the registration process.</p>"
					+ "        <p>Thank you for joining us!</p>" + "    </div>" + "    <div class='footer'>"
					+ "        <p>This is an automated email. Please do not reply to this message.</p>" + "    </div>"
					+ "</body>" + "</html>";
//			helper.setText("<html><body><h1>Dear "+user.getName()+", Your Account has been created Successfully, Your OTP is: 
//			"+user.getOtp()+"</h1></body</html>", true);
			helper.setText(mailContent, true);
			javaMailSender.send(mimeMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	public int generateOTP() {
		double otp = Math.random() * 10000;
		while (otp < 1000)
			otp = Math.random() * 10000;
		return ((int) otp);
	}

}
