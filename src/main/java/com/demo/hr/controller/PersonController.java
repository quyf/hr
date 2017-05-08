package com.demo.hr.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.demo.hr.controller.cmd.AddPersonInfoCmd;
import com.demo.hr.entity.Person;
import com.demo.hr.entity.PersonInfo;
import com.demo.hr.entity.Staff;
import com.demo.hr.helper.MailSenderHelper;
import com.demo.hr.service.PersonService;
import com.demo.hr.service.StaffService;
import com.demo.hr.utils.Result;
import com.demo.hr.utils.ResultCode;

/**
 * 求职者相关接口
 * @author quyf
 *
 */
@Controller
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	PersonService personService;
	@Autowired
	StaffService staffService;
	@Autowired
	MailSenderHelper mailSenderHelper;
	
	/**
	 * 求职者查看自己简历
	 * @param request
	 * @param pid	求职者的id
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public Result info(HttpServletRequest request,HttpSession session) throws Exception {
		Result rt = new Result( ResultCode.DEFAULT_CODE );
		
		Object obj = session.getAttribute("u_id");
		if( obj == null ){
			rt.setErrorMessage("请先登录");
			return rt;
		}
		Integer sessionPId = (Integer) obj;
		Person person = personService.getById(sessionPId);
		if( person==null ){
			rt.setErrorMessage("个人信息不存在");
			return rt;
		}
		PersonInfo info = personService.getInfoByPId( person.getId() );
		rt.setStatus( ResultCode.SUCCESS );
		if( info!=null ){
			rt.setTotalCount( 1 );
			rt.setContent( JSON.toJSONString(info));
		}else{
			rt.setTotalCount( 0 );
		}
		return rt;
	}
	/**
	 * 候选人更新提交自己简历
	 * @param request
	 * @param id
	 * @param addCmd
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/info", method = RequestMethod.POST)
	public Result addInfo(HttpServletRequest request,HttpSession session,
			@RequestBody AddPersonInfoCmd addCmd) throws Exception {
		
		Result rt = new Result( ResultCode.DEFAULT_CODE );
		
		Object obj = session.getAttribute("u_id");
		if( obj == null ){
			rt.setErrorMessage("请先登录");
			return rt;
		}
		Integer sessionPId = (Integer) obj;
		Person person = personService.getById(sessionPId);
		if( person==null ){
			rt.setErrorMessage("个人信息不存在");
			return rt;
		}
		int row = personService.addPersonInfo(person,addCmd);
		if( row>0 ){
			rt.setStatus( ResultCode.SUCCESS );
		}else{
			rt.setStatus( ResultCode.FAILED );
			rt.setErrorMessage("提交失败");
		}
		return rt;
	}
	@ResponseBody
	@RequestMapping(value = "/notifyHr", method = RequestMethod.POST)
	public Result notifyHr(HttpServletRequest request,HttpSession session,
			@RequestParam(value="hr_id",required=false,defaultValue="0") Integer hrId) throws Exception {
		Result rt = new Result( ResultCode.DEFAULT_CODE );
		
		if( hrId < 1){
			rt.setErrorMessage("参数不正确");
			return rt;
		}
		Object obj = session.getAttribute("u_id");
		if( obj == null ){
			rt.setErrorMessage("请先登录");
			return rt;
		}
		Integer sessionPId = (Integer) obj;
		Person person = personService.getById( sessionPId );
		if( person==null ){
			rt.setErrorMessage("信息不在");
			return rt;
		}
		Staff hr = staffService.getStaffById(hrId,true);
		if( hr==null ){
			rt.setErrorMessage("HR不在");
			return rt;
		}
		
		mailSenderHelper.personNofityHr(hr.getEmail(),person.getName());
		rt.setStatus( ResultCode.SUCCESS );
		return rt;
	}
	
	
	
	
}
