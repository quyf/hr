package com.demo.hr.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.hr.controller.cmd.AddPersonCmdTest;
import com.demo.hr.service.PersonService;
import com.demo.hr.service.StaffService;
import com.demo.hr.utils.NullUtils;
import com.demo.hr.utils.Result;
import com.demo.hr.utils.ResultCode;

@Controller
public class LoginController {

	@Autowired
	StaffService staffService;
	@Autowired
	PersonService personService;

	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Result login(HttpServletRequest request,
			@RequestParam(value="account",required = true) String account,	//登录帐号 手机号
			@RequestParam(value="pwd",required = false) String pwd,			//登录密码
			@RequestParam(value = "login_type", required = false, defaultValue = "0") Integer loginType,//登录类型，0 hr 1 应聘者
			@RequestParam(value="name",required = false) String name		//loginType=1时，需要这个参数
			) throws Exception {
		
		Result rt = new Result( ResultCode.DEFAULT_CODE );
		if( loginType==0 ){
			if( NullUtils.isEmpty(account) || NullUtils.isEmpty( pwd )){
				rt.setErrorMessage("参数不完整");
				return rt;
			}
			rt = staffService.hrLogin(account,pwd);
		}else{
			if( NullUtils.isEmpty(account) ){
				rt.setErrorMessage("参数不完整");
				return rt;
			}
			rt = personService.login(account,pwd,name);
		}
		if( rt.getStatus()== ResultCode.SUCCESS ){
			@SuppressWarnings("unchecked")
			Map<String,Object> data = (HashMap<String,Object>)rt.getData();
			HttpSession session = request.getSession();
			session.setAttribute("u_id", data.get("id"));
			session.setAttribute("u_name", data.get("name"));
		}
		return rt;
	}
	
	@ResponseBody
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public Result logout(HttpServletRequest request) throws Exception {
		Result rt = new Result( ResultCode.DEFAULT_CODE );
		HttpSession session = request.getSession();
		session.invalidate();
		rt.setStatus( ResultCode.SUCCESS );
		return rt;
	}
	
	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request,
			@RequestParam(value="page",required = true) String page
			) throws Exception {
		HttpSession session = request.getSession();
		session.setAttribute("id", "12");
		return page;
	}
	
	@ResponseBody
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public AddPersonCmdTest test(HttpServletRequest request,
			@RequestBody AddPersonCmdTest addPersonCmdTest
			) throws Exception {
		System.out.println( "syso:"+addPersonCmdTest.toString());
		return addPersonCmdTest;
		// return JSON.toJSONString(addPersonCmdTest);
	}
	
}
