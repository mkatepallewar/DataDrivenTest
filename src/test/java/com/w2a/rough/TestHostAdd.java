package com.w2a.rough;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.w2a.utilities.MonitoringMail;
import com.w2a.utilities.TestConfig;

public class TestHostAdd {

	public static void main(String[] args) throws UnknownHostException, AddressException, MessagingException {
		
		MonitoringMail mail=new MonitoringMail();
		String messageBody="http://" + InetAddress.getLocalHost().getHostAddress()+":8080/job/DataDrivenLiveProject/Extent_20Report/";
		System.out.println(messageBody);
		mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.password, TestConfig.to, TestConfig.subject, messageBody);
	}

}
