package com.demo.hr.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demo.hr.entity.Post;
import com.demo.hr.entity.criteria.PostCriteria;

public interface PostDao {
	int insert(Post post) throws Exception;
	
	int deleteById(Integer id) throws Exception;

	int delete(PostCriteria postCriteria) throws Exception;
	
	int updateById(Post post) throws Exception;
	
	int update(@Param("record") Post post,@Param("criteria")  PostCriteria postCriteria) throws Exception;
	
	int count(PostCriteria postCriteria) throws Exception;
	
	Post selectById(Integer id) throws Exception;
	
	List<Post> select(PostCriteria postCriteria) throws Exception;

}
