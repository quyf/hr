package cn.yjs.hr;

import java.io.StringWriter;
import java.io.Writer;
import java.net.URI;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.model.DateTime;
import net.fortuna.ical4j.model.Dur;
import net.fortuna.ical4j.model.TimeZone;
import net.fortuna.ical4j.model.TimeZoneRegistry;
import net.fortuna.ical4j.model.TimeZoneRegistryFactory;
import net.fortuna.ical4j.model.component.VAlarm;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.parameter.Cn;
import net.fortuna.ical4j.model.parameter.PartStat;
import net.fortuna.ical4j.model.parameter.Role;
import net.fortuna.ical4j.model.parameter.Rsvp;
import net.fortuna.ical4j.model.property.Action;
import net.fortuna.ical4j.model.property.Attendee;
import net.fortuna.ical4j.model.property.Description;
import net.fortuna.ical4j.model.property.Location;
import net.fortuna.ical4j.model.property.Method;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.Summary;
import net.fortuna.ical4j.model.property.Version;
import net.fortuna.ical4j.util.UidGenerator;

public class Email2 {  
    
    private static void getContent() throws Exception {
    	//------VEvent Start----------
    	//时区
    	TimeZoneRegistry registry = TimeZoneRegistryFactory.getInstance().createRegistry();
    	TimeZone timezone = registry.getTimeZone("Asia/Shanghai");
    	//会议地点
    	String location = "21-C";
    	//会议时间
    	java.util.Calendar cal = java.util.Calendar.getInstance();
    	cal.setTimeZone(timezone);
    	cal.set(2017, 4, 13, 18, 30);
    	DateTime start = new DateTime(cal.getTime());
    	cal.set(2017, 4, 13, 18, 30);
    	DateTime end = new DateTime(cal.getTime());
    	VEvent vevent = new VEvent(start, end, "面試啦");
    	vevent.getProperties().add(timezone.getVTimeZone().getTimeZoneId());//时区
    	vevent.getProperties().add(new Location(location));//会议地点
    	vevent.getProperties().add(new Summary("邮件主题啦"));//邮件主题
    	vevent.getProperties().add(new Description("内容<a href='www.xxx.com'>clic</a>"));//邮件内容
    	vevent.getProperties().add(new UidGenerator("meeting invite").generateUid());// 设置uid
    	//与会人
    	Attendee attendee = new Attendee(URI.create("mailto:" + "xx@xxx.com"));
    	attendee.getParameters().add(Role.CHAIR);
    	attendee.getParameters().add(PartStat.NEEDS_ACTION);
    	attendee.getParameters().add(Rsvp.TRUE);
    	attendee.getParameters().add(new Cn("xx@xx.com".substring(0, "xx@xx.com".indexOf("@"))));
    	vevent.getProperties().add(attendee);
    	//--------VEvent Over----------
    	//--------VAlarm Start----------
    	//提醒,提前10分钟
    	VAlarm valarm = new VAlarm(new Dur(0, 0, -10, 0));
    	//每5分钟提醒一次，提醒三次
//    	valarm.getProperties().add(new Repeat(3));
//    	valarm.getProperties().add(new Duration(new Dur(0, 0, 5, 0)));
    	//提醒窗口显示的文字信息
    	valarm.getProperties().add(Action.DISPLAY);
    	valarm.getProperties().add(new Description("Progress Meeting at 9:30am"));
    	vevent.getAlarms().add(valarm);//将VAlarm加入VEvent
    	//--------VAlarm Over-------------
    	//--------日历对象 Start---------------
    	net.fortuna.ical4j.model.Calendar icsCalendar = new net.fortuna.ical4j.model.Calendar();
    	icsCalendar.getProperties().add(new ProdId("-//Events Calendar//iCal4j 1.0//EN"));
    	icsCalendar.getProperties().add(Version.VERSION_2_0);
    	icsCalendar.getProperties().add(Method.REQUEST);
    	icsCalendar.getComponents().add(vevent);//将VEvent加入Calendar
    	//将日历对象转换为二进制流
    	CalendarOutputter co = new CalendarOutputter(false);
    	Writer wtr = new StringWriter();  
        co.output(icsCalendar, wtr);  
        String mailContent = wtr.toString();  
          
        sendEmail( "sss", mailContent);  
    }
    
    public static void sendEmail( String subject, String content) {  
        Properties properties = new Properties();  
        properties.put("mail.smtp.host", "mail.xx.com");  
        properties.put("mail.smtp.auth", "true");   
  
        final String username = "xx@xx.com";  
        final String password = "xxxx";  
        Authenticator authenticator = new Authenticator() {  
            protected PasswordAuthentication getPasswordAuthentication() {  
                return new PasswordAuthentication(username, password);  
            }  
        };  
  
        String fromEmail = "xx@xx.com";  
        String toEmail="xx@xx.com";  
        Transport transport = null;  
  
        try {  
            Session session = Session.getDefaultInstance(properties,authenticator);  
            MimeMessage mimeMessage = new MimeMessage(session);  
            mimeMessage.setSubject(subject);  
              
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));  
              
            mimeMessage.setFrom(new InternetAddress( fromEmail));  
  
            mimeMessage.setContent(content,"text/calendar;method=REQUEST;charset=UTF-8");  
  
            Transport.send(mimeMessage);  
            
        } catch (MessagingException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } finally {  
            if (transport != null)  
                try {  
                    transport.close();  
                } catch (MessagingException logOrIgnore) {  
                }  
        }  
    }  
    
    public static void main(String[] args) throws Exception {
    	Email2.getContent();
	}
  
}  