package cn.yjs.hr.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.demo.hr.helper.MailSenderHelper;
import com.demo.hr.helper.pojo.MailPojo;
import com.demo.hr.utils.HrUtils;

import cn.yjs.hr.BaseTest;

public class MailTest extends BaseTest {

	@Test
	public void testInviteEmail() throws Exception {
		MailSenderHelper mailSenderHelper = (MailSenderHelper)ac.getBean( "mailSenderHelper" );
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("person_name", "quyf");
		params.put("post", "gaokai");
		params.put("post_link", "www.baidu.ciom" );
		params.put("ms_time", HrUtils.format(new Date()));//转换
		params.put("ms_address", "home" );
		
		params.put("hr", "hrhr");
		params.put("hr_mobile", "xxxx");
		
		mailSenderHelper.sendInterviewInvite("quyf@xxx.com", params);
		
		System.out.println("send over");
	}
	
	
	//@Test
	public void testEmail() throws Exception {
		MailSenderHelper helper = (MailSenderHelper) ac.getBean(MailSenderHelper.class);
		MailPojo mailBean = new MailPojo();
		mailBean.setFrom("quyf@xxx.com");
		mailBean.setFromName("xxxxx");//发件人:  
		mailBean.setSubject("面试邀请");
		mailBean.setToEmails(new String[] { "quyf@xxx.com" });
		mailBean.setContent("<a href='www.baidu.com'><font color='red'>fdsfdsf</font></a>");
		//helper.sendSimpleMail(mailBean);
		
		Map<String,Object> map = new HashMap<String,Object>(); 
		map.put("user_name", "xx");
		map.put("post", "高级开发");
		helper.sendInterviewInvite("quyf@xxx.com", map);
		System.out.println("send over");
	}
	
	//@Test
	public void testMeetingEmail() throws Exception {
		MailSenderHelper helper = (MailSenderHelper) ac.getBean(MailSenderHelper.class);
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("viewer_email", "quyf@xxxx.com");//岗位
		params.put("ms_address", "eeeeesaasa" );//岗位链接
		Calendar cal = Calendar.getInstance();
		cal.set(2017, 4, 14, 8, 35);
		params.put("ms_time", cal.getTime());//面试时间
		helper.sendMeetingInvite("quyf@xxx.com", params);
		System.out.println("send over");
	}
}
