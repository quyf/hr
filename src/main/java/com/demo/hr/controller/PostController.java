package com.demo.hr.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.demo.hr.entity.Post;
import com.demo.hr.service.PostService;
import com.demo.hr.utils.Result;
import com.demo.hr.utils.ResultCode;

/**
 * 招聘岗位相关接口
 * @author quyf
 *
 */
@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	PostService postService;
	
	/**
	 * 查看岗位详情
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/info/{id}", method = RequestMethod.POST)
	public Result info(HttpServletRequest request,
			@PathVariable Integer id) throws Exception {
		Result rt = new Result( ResultCode.DEFAULT_CODE );
		
		Post info = postService.getById( id );
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
	 * 创建招聘岗位
	 * @param request
	 * @param postName
	 * @param postLink
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Result addInfo(HttpServletRequest request,
			@RequestParam(value="post",required = false) String postName,
			@RequestParam(value="post_link",required = false) String postLink) throws Exception {
		Result rt = new Result( ResultCode.DEFAULT_CODE );
		
		Post post = new Post();
		post.setPost( postName );
		post.setPostLink( postLink );
		post.setStatus( 1 );
		
		int row = postService.addPost( post );
		if( row>0 ){
			rt.setStatus( ResultCode.SUCCESS );
		}else{
			rt.setStatus( ResultCode.FAILED );
			rt.setErrorMessage("提交失败");
		}
		return rt;
	}
	
	/**
	 * 修改岗位详情
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/modify/{id}", method = RequestMethod.POST)
	public Result modify(HttpServletRequest request,
			@PathVariable Integer id,
			@RequestParam(value="post",required = false) String postName,
			@RequestParam(value="post_link",required = false) String postLink,
			@RequestParam(value="status",required = false,defaultValue="1") Integer status
			) throws Exception {
		Result rt = new Result( ResultCode.DEFAULT_CODE );
		
		Post post = new Post();
		post.setId(id);
		post.setPost( postName );
		post.setPostLink( postLink );
		post.setStatus( status );
		post.setModifyTime( new Date());
		
		int row = postService.updateById( post );
		if( row>0 ){
			rt.setStatus( ResultCode.SUCCESS );
		}else{
			rt.setStatus( ResultCode.FAILED );
			rt.setErrorMessage("提交失败");
		}
		return rt;
	}
	
	
}
