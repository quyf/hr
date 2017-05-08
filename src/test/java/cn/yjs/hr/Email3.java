package cn.yjs.hr;

import java.io.ByteArrayOutputStream;
import java.net.URI;
import java.util.GregorianCalendar;

import javax.mail.BodyPart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.model.DateTime;
import net.fortuna.ical4j.model.TimeZone;
import net.fortuna.ical4j.model.TimeZoneRegistry;
import net.fortuna.ical4j.model.TimeZoneRegistryFactory;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.parameter.Cn;
import net.fortuna.ical4j.model.parameter.Role;
import net.fortuna.ical4j.model.property.Attendee;
import net.fortuna.ical4j.model.property.CalScale;
import net.fortuna.ical4j.model.property.Description;
import net.fortuna.ical4j.model.property.Location;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.Uid;
import net.fortuna.ical4j.util.UidGenerator;

public class Email3 {

	public static MimeMultipart getContent() throws Exception{
		// 创建一个时区（TimeZone）
		TimeZoneRegistry registry = TimeZoneRegistryFactory.getInstance().createRegistry(); 
		TimeZone timezone = registry.getTimeZone("Asia/Shanghai"); 

		// 起始时间是：2008 年 4 月 1 日 上午 9 点
		java.util.Calendar startDate = new GregorianCalendar(); 
		startDate.setTimeZone(timezone); 
		startDate.set(2017, 4, 13, 18, 30);
//		startDate.set(java.util.Calendar.MONTH, java.util.Calendar.APRIL); 
//		startDate.set(java.util.Calendar.DAY_OF_MONTH, 1); 
//		startDate.set(java.util.Calendar.YEAR, 2008); 
//		startDate.set(java.util.Calendar.HOUR_OF_DAY, 9); 
//		startDate.set(java.util.Calendar.MINUTE, 0); 
//		startDate.set(java.util.Calendar.SECOND, 0); 
		
		// 结束时间是：2008 年 4 月 1 日 下午 1 点
		java.util.Calendar endDate = new GregorianCalendar(); 
//		endDate.setTimeZone(timezone); 
//		endDate.set(java.util.Calendar.MONTH, java.util.Calendar.APRIL); 
//		endDate.set(java.util.Calendar.DAY_OF_MONTH, 1); 
//		endDate.set(java.util.Calendar.YEAR, 2008); 
//		endDate.set(java.util.Calendar.HOUR_OF_DAY, 13); 
//		endDate.set(java.util.Calendar.MINUTE, 0); 	
//		endDate.set(java.util.Calendar.SECOND, 0); 
		endDate.set(2017, 4, 13, 18, 50);
		// 创建事件
		String eventName = "Progress Meeting"; //subjectname
		DateTime start = new DateTime(startDate.getTime()); 
		DateTime end = new DateTime(endDate.getTime()); 
		VEvent meeting = new VEvent(start, end, eventName); 

		// 添加时区信息
		meeting.getProperties().add(timezone.getVTimeZone().getTimeZoneId()); 

		// 生成唯一标志符
		UidGenerator ug = new UidGenerator("uidGen"); 
		Uid uid = ug.generateUid(); 
		meeting.getProperties().add(uid); 
		
		meeting.getProperties().add(new Location("深圳市南山区科"));//会议地点
		// 添加参加者 . 
		Attendee dev1 = new Attendee(URI.create("mailto:xxx@xx.com")); 
		dev1.getParameters().add(Role.REQ_PARTICIPANT); 
		dev1.getParameters().add(new Cn("Developer 1")); 
		meeting.getProperties().add(dev1); 
		
//		Attendee dev2 = new Attendee(URI.create("mailto:dev2@mycompany.com")); 
//		dev2.getParameters().add(Role.OPT_PARTICIPANT); 
//		dev2.getParameters().add(new Cn("Developer 2")); 
//		meeting.getProperties().add(dev2); 

		Description desc = new Description();
		meeting.getProperties().add(new Description("youjian 内容<a href='www.xxx.com'>clic</a>"));//邮件内容
		// 创建日历
		net.fortuna.ical4j.model.Calendar icsCalendar = new net.fortuna.ical4j.model.Calendar(); 
		icsCalendar.getProperties().add(new ProdId("-//Events Calendar//iCal4j 1.0//EN")); 
		icsCalendar.getProperties().add(CalScale.GREGORIAN); 
		
		// 添加事件
		icsCalendar.getComponents().add(meeting);
		
		CalendarOutputter co = new CalendarOutputter(false);
    	ByteArrayOutputStream os = new ByteArrayOutputStream();
    	co.output(icsCalendar, os);
    	byte[] mailbytes = os.toByteArray();
    	//--------日历对象 Over------------------
    	MimeMultipart mm = new MimeMultipart();
    	mm.setSubType("related");
    	BodyPart mbp = new MimeBodyPart();
    	mbp.setContent(mailbytes, "text/calendar;method=REQUEST;charset=UTF-8");
    	mm.addBodyPart(mbp);
    	return mm;
	}
}
