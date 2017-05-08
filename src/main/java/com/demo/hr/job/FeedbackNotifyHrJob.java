package com.demo.hr.job;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.demo.hr.entity.Feedback;
import com.demo.hr.entity.Interview;
import com.demo.hr.helper.MailSenderHelper;
import com.demo.hr.helper.SpringHelper;
import com.demo.hr.utils.Constants;
import com.demo.hr.utils.NullUtils;

/**
 * 面试官提交完面试反馈后，在这里告知hr 面试官的反馈结果
 * @author quyf
 * @date 2017年5月5日
 * @since
 */
public class FeedbackNotifyHrJob implements Runnable {
	Logger log = LoggerFactory.getLogger( FeedbackNotifyHrJob.class );
	
	MailSenderHelper mailSenderHelper = (MailSenderHelper)SpringHelper.getBean( MailSenderHelper.class );
	
	private Feedback feedback;
	private Interview interview;
	
	public FeedbackNotifyHrJob(Feedback feedback, Interview interview) {
		this.feedback = feedback;
		this.interview = interview;
	}

	public void run() {
		String toEmail = interview.getHrEmail();
		if( !NullUtils.isEmpty( toEmail )){
			log.info("FeedbackNotifyHrJob.run()->toEmail={};interview={};begin",toEmail,JSON.toJSONString(interview));
			Map<String,Object> params = makeNotifyHrParams(interview, feedback );
			int rt = mailSenderHelper.feedbackNotifyHrResult(toEmail, params, feedback.getMsType());
			log.info("FeedbackNotifyHrJob.run()->toEmail={};rt={};end",toEmail,rt);
		}
	}

	private Map<String, Object> makeNotifyHrParams(Interview interview2, Feedback feedback2) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("hr_name", interview2.getHrName());//HR名字
		params.put("staff_name", feedback2.getStaffName());//面试官名字
		
		params.put("person_name", interview2.getName());//候选人名字
		params.put("post", interview2.getPost());//岗位
		params.put("post_link", interview2.getPostLink() );//岗位链接
		
		params.put("ms_type", feedback2.getMsType());//面试类型 0 初试 1复试
		
		params.put("ms_result", getMsResult(feedback2.getMsType(),feedback2.getResult()));// 面试官反馈结果 0 无 1通过 2存档备选 3不通过
		if( !NullUtils.isEmpty(feedback2.getContent())){
			params.put("ms_content", getContentMap(feedback2.getContent()));// 反馈结果的内容
		}
		return params;
	}

	private Map<String,Object> getContentMap(String content){
		Map<String, Object> map = new HashMap<String, Object>();
		ResultContent rt = JSON.parseObject(content, ResultContent.class);
		map.put("opinion", rt.getOpinion());
		map.put("tech_grade", rt.getTech_grade());
		map.put("score", rt.getScore());
		return map;
	}
	/**
	 * 获取相应描述
	 * @param msType
	 * @param result
	 * @return
	 * @author quyf
	 * @date 2017年5月6日 下午3:14:52
	 */
	private String getMsResult(Integer msType,Integer result){
		if( msType == 0 ){//初试
			return Constants.csResultMap.get(result);
		}else{//复试
			return Constants.fsResultMap.get(result);
		}
	}
	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

	public Interview getInterview() {
		return interview;
	}

	public void setInterview(Interview interview) {
		this.interview = interview;
	}

}

class ResultContent{
	//{"score":[5,5,4],"tech_grade":"中级","opinion":"房产税的方式发的撒"}
	List<Integer> score;
	String tech_grade;
	String opinion;
	
	public List<Integer> getScore() {
		return score;
	}
	public void setScore(List<Integer> score) {
		this.score = score;
	}
	public String getTech_grade() {
		return tech_grade;
	}
	public void setTech_grade(String tech_grade) {
		this.tech_grade = tech_grade;
	}
	public String getOpinion() {
		return opinion;
	}
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	
	
}