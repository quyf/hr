package com.demo.hr.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.demo.hr.entity.Interview;
import com.demo.hr.entity.Staff;
import com.demo.hr.service.InterviewService;
import com.demo.hr.service.StaffService;
import com.demo.hr.utils.Constants;
import com.demo.hr.utils.Result;
import com.demo.hr.utils.ResultCode;

@Controller
@RequestMapping("/interview")
public class InterviewController {
	
	@Autowired
	InterviewService interviewService;
	@Autowired
	StaffService staffService;
	
	/**
	 * HR查看面试邀请列表
	 * @param request
	 * @param session
	 * @param pageNo
	 * @param likeAccount
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Result list(HttpServletRequest request,HttpSession session,
			@RequestParam(value="pageNo",required = false,defaultValue="1") Integer pageNo,
			@RequestParam(value="account",required = false) String likeAccount
			) throws Exception {
		Result rt = new Result( ResultCode.DEFAULT_CODE );
		
		if( pageNo < 1 ){
			pageNo = Constants.PAGE_NO;
		}
		Integer offset = (pageNo-1) * Constants.PAGE_SIZE ;
		
		Object obj = session.getAttribute("u_id");
		if( obj == null ){
			rt.setErrorMessage("请先登录");
			return rt;
		}
		Integer hrId = (Integer) obj;
		
		Staff hr = staffService.getStaffById(hrId,true);
		if( hr==null ){
			rt.setErrorMessage("HR不存在");
			return rt;
		}
		
		List<Interview> list = interviewService.getList( likeAccount,offset,Constants.PAGE_SIZE );
		
		rt.setStatus( ResultCode.SUCCESS );
		if( list.size()>0 ){
			rt.setTotalCount( list.size() );
			rt.setContent( JSON.toJSONString(list));
		}else{
			rt.setTotalCount( 0 );
		}
		return rt;
	}
	
	/**
	 * HR查看面试邀请详情
	 * @param request
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Result info(HttpServletRequest request,HttpSession session,
			@PathVariable Integer id) throws Exception {
		Result rt = new Result( ResultCode.DEFAULT_CODE );
		
		if( id < 1 ){
			rt.setErrorMessage("参数不正确");
			return rt;
		}
		
		Object obj = session.getAttribute("u_id");
		if( obj == null ){
			rt.setErrorMessage("请先登录");
			return rt;
		}
		Integer hrId = (Integer) obj;
		
		Staff hr = staffService.getStaffById(hrId,true);
		if( hr==null ){
			rt.setErrorMessage("HR不存在");
			return rt;
		}
		Interview info = interviewService.getInterviewById( id );
		rt.setStatus( ResultCode.SUCCESS );
		if( info!=null ){
			rt.setTotalCount( 1 );
			rt.setContent( JSON.toJSONString(info));
		}else{
			rt.setTotalCount( 0 );
		}
		return rt;
	}
	
}
