package com.demo.hr.helper;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.demo.hr.helper.pojo.MailPojo;
import com.demo.hr.utils.CalendarEmailContent;

@Component
public class MailSenderHelper {
	private static final Logger log = LoggerFactory.getLogger( MailSenderHelper.class );
	
	@Value("${mail.from_email}")
	String fromEmail;
	
	@Value("${mail.from_name}")
	String fromName;
	
	@Autowired
	JavaMailSender javaMailSender;
	@Autowired
	VelocityEngine velocityEngine;//spring配置中定义  
	
	public int feedbackNotifyHrResult(String toEmail, Map<String,Object> params, int msType) {
		String vm = "cs_feedback_notify_hr.vm";
		if( msType==1 ){
			vm = "cs_feedback_notify_hr.vm";
		}
		return sendVmMail(toEmail,"面试结果", params, vm);
	}
	
	/**
	 * 发送面试邀请
	 */
	public int sendInterviewInvite(String toEmail,Map<String,Object> params){
		return sendVmMail(toEmail,"面试邀请", params, "interview.vm");
	}
	
	/**
	 * 发送面试淘汰邮件
	 * @param toEmail
	 * @param params
	 */
	public int sendInterviewFailureEmail(String toEmail, Map<String, Object> params) {
		return sendVmMail(toEmail,"面试结果", params, "interview_failure.vm");
	}
	
	/**
	 * 给HR发送面试反馈邮件
	 */
	public int sendHrFeedbackEmail(String toEmail,Map<String,Object> params, Integer msType){
		String vm = "hr_cs_feedback.vm";
		if( msType==1 ){
			vm = "hr_fs_feedback.vm";
		}
		return sendVmMail(toEmail,"面试评估", params, vm);
	}
	
	/**
	 * 给面试官发送面试反馈邮件
	 */
	public int sendFeedbackEmail(String toEmail,Map<String,Object> params, Integer msType){
		String vm = "cs_feedback.vm";
		if( msType==1 ){
			vm = "fs_feedback.vm";
		}
		return sendVmMail(toEmail,"面试评估", params, vm);
	}
	
	/**
	 * 给面试官发送面试的会议邀请
	 */
	public void sendMeetingInvite(String toEmail,Map<String,Object> params){
		MailPojo mailBean = new MailPojo();
		mailBean.setFrom( fromEmail );
		mailBean.setFromName( fromName );//发件人: 
		mailBean.setSubject( (String)params.get("subject"));
		mailBean.setToEmails(new String[] { toEmail });
		try {
			String conetnt = CalendarEmailContent.getContent(params);
			sendMeetingMail(mailBean, conetnt);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("error in sendInterviewInvita "+toEmail+" "+e.getMessage());
		} 
	}
	/**
	 * 发送VM模板邮件
	 * @param mailBean
	 * @param model
	 * @param vm
	 */
	private int sendVmMail(String toEmail,String subject,Map<String,Object> model,String vm) {  
		MailPojo mailBean = new MailPojo();
		mailBean.setFrom( fromEmail );
		mailBean.setFromName( fromName );//发件人: 
		mailBean.setSubject( subject );
		mailBean.setToEmails(new String[] { toEmail });
		try {
			MimeMessage msg = createVmMessage(mailBean,model,vm);
			javaMailSender.send(msg);
			return 200;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("error in sendVmMail "+toEmail+" "+e.getMessage());
			return 0;
		}  
	}
	
	/**
	 * 发送会议邀请的模板邮件
	 * @param mailBean
	 * @param model
	 */
	private void sendMeetingMail(MailPojo mailBean,String content) {  
		try {
			MimeMessage msg = createMeetingMessage(mailBean,content);  
			javaMailSender.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	private MimeMessage createMeetingMessage(MailPojo mailBean,String content) throws MessagingException, UnsupportedEncodingException{  
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();  
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");  
        messageHelper.setFrom(mailBean.getFrom(), mailBean.getFromName());   
        messageHelper.setSubject(mailBean.getSubject());    
        messageHelper.setTo(mailBean.getToEmails()); 
        mimeMessage.setContent(content, "text/calendar;method=REQUEST;charset=UTF-8");
        return mimeMessage;  
    }
	 
    private MimeMessage createVmMessage(MailPojo mailBean,Map<String,Object> model,String vm) throws MessagingException, UnsupportedEncodingException{  
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();  
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");  
        messageHelper.setFrom(mailBean.getFrom(), mailBean.getFromName());   
        messageHelper.setSubject(mailBean.getSubject());    
        messageHelper.setTo(mailBean.getToEmails());    
        String result = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, vm, "UTF-8",model);
        messageHelper.setText(result, true); // html: true   
        return mimeMessage;  
    }

    /**
     * 候选人扫描二维码 通知HR 自己来面试了
     * @param email
     * @param name
     * @author quyf
     * @date 2017年5月6日 下午5:09:10
     */
	public int personNofityHr(String hrEemail, String name) {
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("name", name);
		return sendVmMail(hrEemail,"通知", model, "person_notify_hr.vm");
	}


}  
