package com.demo.hr.service;

import java.util.List;

import com.demo.hr.entity.Post;

public interface PostService {

	/**
	 * 获取在线的招聘岗位
	 * @return
	 */
	List<Post> getOkPostList();

	Post getById(Integer id);

	int addPost(Post post);
	
	int updateById(Post post);

}
