package com.demo.hr.utils;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URI;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

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
import net.fortuna.ical4j.model.property.Version;
import net.fortuna.ical4j.util.UidGenerator;

public class CalendarEmailContent {

	public static String getContent(Map<String,Object> params) throws IOException{
		String viewerEmail = (String)params.get("viewer_email");
		//会议地点
    	String location = (String)params.get("ms_address");
		//------VEvent Start----------
    	//时区
    	TimeZoneRegistry registry = TimeZoneRegistryFactory.getInstance().createRegistry();
    	TimeZone timezone = registry.getTimeZone("Asia/Shanghai");
    	
    	//会议时间
    	java.util.Calendar cal = java.util.Calendar.getInstance();
    	cal.setTime((Date) params.get("ms_time"));
    	DateTime start = new DateTime(cal.getTime());
    	cal.add(Calendar.HOUR_OF_DAY, 1);
    	DateTime end = new DateTime(cal.getTime());
    	VEvent vevent = new VEvent(start, end, "面试会议邀请");
    	vevent.getProperties().add(timezone.getVTimeZone().getTimeZoneId());//时区
    	vevent.getProperties().add(new Location(location));//会议地点
    	//vevent.getProperties().add(new Summary("邮件主题啦"));//邮件主题
    	vevent.getProperties().add(new Description( getHtml(params) ));//邮件内容
    	vevent.getProperties().add(new UidGenerator("meeting invite").generateUid());// 设置uid
    	
    	//与会人
    	Attendee attendee = new Attendee(URI.create("mailto:" + viewerEmail));
    	attendee.getParameters().add(Role.CHAIR);
    	attendee.getParameters().add(PartStat.NEEDS_ACTION);
    	attendee.getParameters().add(Rsvp.TRUE);
    	attendee.getParameters().add(new Cn(viewerEmail.substring(0, viewerEmail.indexOf("@"))));
    	vevent.getProperties().add(attendee);
    	//--------VEvent Over----------
    	//--------VAlarm Start----------
    	//提醒,提前10分钟
    	VAlarm valarm = new VAlarm(new Dur(0, 0, -30, 0));
    	//每5分钟提醒一次，提醒三次
//    	valarm.getProperties().add(new Repeat(3));
//    	valarm.getProperties().add(new Duration(new Dur(0, 0, 5, 0)));
    	//提醒窗口显示的文字信息
    	valarm.getProperties().add(Action.DISPLAY);
    	valarm.getProperties().add(new Description("半小时后您有面试，请安排好时间"));
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
        return mailContent;
	}
	
	public static String getHtml(Map<String,Object> params){
		String viewerName = (String)params.get("viewer_name");
		String post = (String)params.get("post");
		String msTime = (String)params.get("ms_time_str");
		String msAddress = (String)params.get("ms_address");
		
		StringBuilder sb = new StringBuilder();
		sb.append(viewerName+"：\n        您好，人力资源部为您安排了 "+post+" 的面试，具体如下：\n        面试时间："+msTime);
		sb.append("\n        面试地点："+msAddress);
		sb.append("\n        面试结束后请及时在邮件中提交您的面试意见，非常感谢。\n");
		return sb.toString();
	}
}
