package com.demo.hr.helper;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.hr.utils.Constants;
import com.demo.hr.utils.HrUtils;

/**
 * 翻译 转换
 * @author lenovo
 *
 */
@Component
public class InitHelper {

	@Autowired
	MailSenderHelper mailSenderHelper;

	@PostConstruct
	public void init(){
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("person_name", "quyf");
//		params.put("post", "gaokai");
//		params.put("post_link", "www.baidu.ciom" );
//		params.put("ms_time", HrUtils.format(new Date()));//转换
//		params.put("ms_address", "home" );
//		
//		params.put("hr", "hrhr");
//		params.put("hr_mobile", "1343333333");
		//sendStaffFeedbackEmail();
		System.out.println("send over==");
	}
	
	public void sendStaffFeedbackEmail(){
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staff_name", "quyafeng");//面试官名字
		params.put("staff_id", 1);//面试官ID
		
		params.put("person_id", 25);//候选人ID
		params.put("person_name", "待分配");//候选人名字
		params.put("post", "高开");//岗位
		params.put("post_link", "www.baidu.com" );//岗位链接
		
		params.put("interview_id", 16);//面试邀请ID
		params.put("feedback_task_id", 24);//反馈任务ID
		String info = HrUtils.URLEncoder(HrUtils.mapToString(params) );
		params.put("click_url", Constants.HR_NODE_DOMAIN+"?info="+info);
		
		mailSenderHelper.sendFeedbackEmail("quyf@yonyou.com", params, 0);
		System.out.println("send over");
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staff_name", "quyafeng");//面试官名字
		params.put("staff_id", 1);//面试官ID
		
		params.put("person_id", 25);//候选人ID
		params.put("person_name", "待分配");//候选人名字
		params.put("post", "高开");//岗位
		params.put("post_link", "www.baidu.com" );//岗位链接
		
		params.put("interview_id", 16);//面试邀请ID
		params.put("feedback_task_id", 24);//反馈任务ID
		System.out.println(params.toString());
		System.out.println( URLEncoder.encode(params.toString(),"utf-8"));
	}
}
