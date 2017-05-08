package com.demo.hr.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;

import com.demo.hr.dao.PostDao;
import com.demo.hr.entity.Post;
import com.demo.hr.entity.criteria.PostCriteria;
import com.demo.hr.service.PostService;


@Service
public class PostServiceImpl implements PostService {
	public static final Logger log = LoggerFactory.getLogger(PostServiceImpl.class);


	@Autowired
	PostDao postDao;

	@Autowired
	DataSourceTransactionManager transactionManager;

	public int addPost(Post post) {
	
		try {
			return postDao.insert(post);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<Post> getOkPostList() {
		PostCriteria crt = new PostCriteria();
		PostCriteria.Criteria subCrt = crt.createCriteria();
		subCrt.andStatusEqualTo( 1 );
		List<Post> posts = new ArrayList<Post>();
		try {
			posts =  postDao.select( crt );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return posts;
	}

	public Post getById(Integer id) {
		try {
			return postDao.selectById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int updateById(Post post) {
		try {
			return postDao.updateById(post);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
