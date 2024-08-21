package com.walk.post.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.walk.post.domain.Post;

@Mapper
public interface PostMapper {

	public List<Map<String, Object>> selectPostListTest();
	
	public void insertPost(
			@Param("userId") int userId, 
			@Param("userLoginId") String userLoginId,
			@Param("subject") String subject, 
			@Param("place") String place, 
			@Param("distance") String distance,
			@Param("time") String time, 
			@Param("visitDate") String visitDate, 
			@Param("placeExplain") String placeExplain, 
			@Param("imagePath") String imagePath);
	
	public List<Post> selectPostList();
	
	public Post selectPostByPostIdUserId(
			@Param("postId") int postId, 
			@Param("userId") int userId);
}
