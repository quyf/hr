package com.demo.hr.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.demo.hr.controller.cmd.AddPersonCmd;
import com.demo.hr.controller.cmd.CreateInterviewCmd;
import com.demo.hr.entity.Person;
import com.demo.hr.entity.Post;
import com.demo.hr.entity.Staff;
import com.demo.hr.service.InterviewService;
import com.demo.hr.service.PersonService;
import com.demo.hr.service.PostService;
import com.demo.hr.service.StaffService;
import com.demo.hr.utils.Constants;
import com.demo.hr.utils.NullUtils;
import com.demo.hr.utils.Result;
import com.demo.hr.utils.ResultCode;

/**
 * HR | 面试官相关的操作
 * @author quyf
 *
 */
@Controller
@RequestMapping("/hr")
public class HrController {
	private static final Logger log = LoggerFactory.getLogger( HrController.class );
	@Autowired
	StaffService staffService;
	@Autowired
	PersonService personService;
	@Autowired
	InterviewService interviewService;
	@Autowired
	PostService postService;

	/**
	 * HR创建面试邀请
	 * @param request
	 * @param session
	 * @param createCmd
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/intervire/create", method = RequestMethod.POST)
	public Result createInterview(HttpServletRequest request,
			@RequestBody  CreateInterviewCmd createCmd) throws Exception {
		log.debug("createInterview==>"+ JSON.toJSONString(createCmd));
		Result rt = new Result( ResultCode.DEFAULT_CODE );
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("u_id");
		if( obj == null ){
			rt.setStatus( ResultCode.UN_LOGIN );
			rt.setErrorMessage("请先登录");
			return rt;
		}
		
		Integer hrId = (Integer) obj;
		Staff hr = staffService.getStaffById(hrId, true);
		if( hr==null ){
			rt.setErrorMessage("HR信息不存在");
			return rt;
		}
		Person person = personService.getByMobile(createCmd.getMobile() );
		//TODO 参数判断
		interviewService.createInterview(person, createCmd );
		
		rt.setStatus( ResultCode.SUCCESS );
		return rt;
	}
	
	
	/**
	 * 候选人列表
	 * @param request
	 * @param pageNo
	 * @param likeAccount
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/person/list", method = RequestMethod.POST)
	public Result list(HttpServletRequest request,
			@RequestParam(value="pageNo",required = false,defaultValue="1") Integer pageNo,
			@RequestParam(value="account",required = false) String likeAccount
			) throws Exception {
		Result rt = new Result( ResultCode.DEFAULT_CODE );
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("u_id");
		if( obj == null ){
			rt.setStatus( ResultCode.UN_LOGIN );
			rt.setErrorMessage("请先登录");
			return rt;
		}
		
		if( pageNo < 1 ){
			pageNo = Constants.PAGE_NO;
		}
		Integer offset = (pageNo-1) * Constants.PAGE_SIZE ;
		
		List<Person> infoList = personService.getPersonList( likeAccount,offset,Constants.PAGE_SIZE );
		
		rt.setStatus( ResultCode.SUCCESS );
		if( infoList.size()>0 ){
			rt.setTotalCount( infoList.size() );
			rt.setContent( JSON.toJSONString(infoList));
		}else{
			rt.setTotalCount( 0 );
		}
		return rt;
	}
	
	/**
	 * HR添加候选人
	 * @param request
	 * @param session
	 * @param addCmd
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/person/add", method = RequestMethod.POST)
	public Result addPerson(HttpServletRequest request,
			@RequestBody AddPersonCmd addCmd) throws Exception {
		log.debug("addPerson==>"+ JSON.toJSONString(addCmd));
		Result rt = new Result( ResultCode.DEFAULT_CODE );
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("u_id");
		if( obj == null ){
			rt.setStatus( ResultCode.UN_LOGIN );
			rt.setErrorMessage("请先登录");
			return rt;
		}
		
		Integer hrId = (Integer) obj;
		Staff hr = staffService.getStaffById(hrId, true);
		if( hr==null ){
			rt.setErrorMessage("HR信息不存在");
			return rt;
		}
		personService.addPerson(hr, addCmd );
		
		rt.setStatus( ResultCode.SUCCESS );
		return rt;
	}
	
	/**
	 * 面试官列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/staff/list", method = RequestMethod.POST)
	public Result staffList(HttpServletRequest request,
			@RequestParam(value="type",required = false,defaultValue="2") Integer type,//0 面试官 1 HR 2默认查所有
			@RequestParam(value="pageNo",required = false,defaultValue="1") Integer pageNo
			) throws Exception {
		Result rt = new Result( ResultCode.DEFAULT_CODE );
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("u_id");
		if( obj == null ){
			rt.setStatus( ResultCode.UN_LOGIN );
			rt.setErrorMessage("请先登录");
			return rt;
		}
		
		List<Staff> staffList = staffService.getStaffList( type );
		
		rt.setStatus( ResultCode.SUCCESS );
		if( staffList!=null && staffList.size()>0 ){
			rt.setTotalCount( staffList.size() );
			rt.setContent( JSON.toJSONString(staffList));
		}else{
			rt.setTotalCount( 0 );
		}
		return rt;
	}
	
	/**
	 * 面试官列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/post/list", method = RequestMethod.POST)
	public Result postList(HttpServletRequest request) throws Exception {
		Result rt = new Result( ResultCode.DEFAULT_CODE );
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("u_id");
		if( obj == null ){
			rt.setStatus( ResultCode.UN_LOGIN );
			rt.setErrorMessage("请先登录");
			return rt;
		}
		List<Post> postList = postService.getOkPostList();
		
		rt.setStatus( ResultCode.SUCCESS );
		if( postList!=null && postList.size()>0 ){
			rt.setTotalCount( postList.size() );
			rt.setContent( JSON.toJSONString(postList));
		}else{
			rt.setTotalCount( 0 );
		}
		return rt;
	}
	
	@ResponseBody
	@RequestMapping(value = "/modify/pwd", method = RequestMethod.POST)
	public Result modifyPwd(HttpServletRequest request,
			@RequestParam(value="old_pwd",required = false) String oldPwd,
			@RequestParam(value="new_pwd",required = false) String newPwd
			) throws Exception {
		Result rt = new Result( ResultCode.DEFAULT_CODE );
		if( NullUtils.isEmpty( oldPwd ) || NullUtils.isEmpty(newPwd) ){
			rt.setErrorMessage("参数不能为空");
			return rt;
		}
		if( newPwd.equals(oldPwd) ){
			rt.setErrorMessage("新旧密码一致");
			return rt;
		}
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("u_id");
		if( obj == null ){
			rt.setStatus( ResultCode.UN_LOGIN );
			rt.setErrorMessage("请先登录");
			return rt;
		}
		
		Integer hrId = (Integer) obj;
		Staff hr = staffService.getStaffById(hrId, true);
		if( hr==null ){
			rt.setErrorMessage("HR信息不存在");
			return rt;
		}
		if( !hr.getPwd().equals(oldPwd)){
			rt.setErrorMessage("旧密码不正确，请确认");
			return rt;
		}
		int resultCode = staffService.modifyPwd(hr,newPwd.trim());
		if( resultCode>0 ){
			rt.setStatus( ResultCode.SUCCESS );
		}
		return rt;
	}
}
