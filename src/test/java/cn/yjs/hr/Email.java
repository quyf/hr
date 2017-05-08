package cn.yjs.hr;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.UUID;

import javax.activation.DataHandler;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

public class Email {  
    private static String EMAIL_CONFIG = "mail.properties";  
    private Properties emailProp = new Properties();  
    
    public Email() {  
        InputStream is = getClass().getResourceAsStream("/"+EMAIL_CONFIG);  
        try {  
            emailProp.load(is);  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }  
  
    private class EmailAuthenticator extends Authenticator {  
        protected PasswordAuthentication getPasswordAuthentication() {  
            String userId = emailProp.getProperty("mail.username", "");  
            String password = emailProp.getProperty("mail.password", "");  
            return new PasswordAuthentication(userId, password);  
        }  
    }  
  
    public void send() throws Exception {  
  
        try {  
            String fromEmail = "quyf@xxx.com";  
            String toEmail="quyf@xxx.com";  
            Properties props = new Properties();  
            try {  
                props.put("mail.smtp.host", "mail.xxx.com");  
                props.put("mail.smtp.auth", "true");  
  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
  
            Session session;  
            Authenticator authenticator = new EmailAuthenticator();  
            session = Session.getInstance(props, authenticator);  
            MimeMessage message = new MimeMessage(session);  
            message.setFrom(new InternetAddress(fromEmail));  
            
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));  
            message.setSubject("高级开发-某某-面试提醒");  
            StringBuffer buffer = new StringBuffer();  
            buffer.append("BEGIN:VCALENDAR\n"  
                    + "PRODID:-//Microsoft Corporation//Outlook 9.0 MIMEDIR//EN\n"  	
                    + "VERSION:2.0\n"  
                    + "METHOD:REQUEST\n"  
                    + "BEGIN:VEVENT\n"  
                    + "ATTENDEE;ROLE=REQ-PARTICIPANT;RSVP=TRUE:MAILTO:"+toEmail+"\n"  
                    + "ORGANIZER:MAILTO:"+toEmail+"\n"  
                    + "DTSTART:20120302T060000Z\n"  
                    + "DTEND:20120302T070000Z\n"  
                    + "LOCATION:"+  "深圳市南山区科华路讯美科技。" +"\n"  ////会议地点
                    + "UID:"+UUID.randomUUID().toString()+"\n"//如果id相同的话，outlook会认为是同一个会议请求，所以使用uuid。  
                    + "CATEGORIES:SuccessCentral Reminder\n"  
                    + "DESCRIPTION:邮件内容\n\n"  //邮件内容
                    + "SUMMARY:Test meeting request\n" + "PRIORITY:5\n"  
                    + "CLASS:PUBLIC\n" + "BEGIN:VALARM\n"  
                    + "TRIGGER:-PT15M\n" + "ACTION:DISPLAY\n"  
                    + "DESCRIPTION:Reminder\n" + "END:VALARM\n"  
                    + "END:VEVENT\n" + "END:VCALENDAR");  
            BodyPart messageBodyPart = new MimeBodyPart();  
            // 测试下来如果不这么转换的话，会以纯文本的形式发送过去，  
            //如果没有method=REQUEST;charset=\"UTF-8\"，outlook会议附件的形式存在，而不是直接打开就是一个会议请求  
            messageBodyPart.setDataHandler(new DataHandler(new ByteArrayDataSource(buffer.toString(),   
                    "text/calendar;method=REQUEST;charset=\"UTF-8\"")));  
            Multipart multipart = new MimeMultipart();  
            multipart.addBodyPart(messageBodyPart);  
            message.setContent(multipart);  
            Transport.send(message);  
        } catch (MessagingException me) {  
            me.printStackTrace();  
        } catch (Exception ex) {  
            ex.printStackTrace();  
        }  
    }  
    public void send2() throws Exception {  
    	  
        try {  
            String fromEmail = "quyf@yonyou.com";  
            String toEmail="zhangpengs@yonyou.com";  
            Properties props = new Properties();  
            try {  
                props.put("mail.smtp.host", "mail.yonyou.com");  
                props.put("mail.smtp.auth", "true");  
  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
  
            Session session;  
            Authenticator authenticator = new EmailAuthenticator();  
            session = Session.getInstance(props, authenticator);  
            MimeMessage message = new MimeMessage(session);  
            message.setFrom(new InternetAddress(fromEmail));  
            
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));  
            message.setSubject("高级开发-某某-面试提醒");  
            
            Multipart multipart = Email3.getContent();  
            message.setContent(multipart);  
           // message.setText("<a href='aaa'>testttt</a>","utf-8","html");
            Transport.send(message);  
        } catch (MessagingException me) {  
            me.printStackTrace();  
        } catch (Exception ex) {  
            ex.printStackTrace();  
        }  
    }  
    public static void main(String[] args) {  
        try {  
            Email email = new Email();  
            email.send2();  
            System.out.println("success");  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
}  