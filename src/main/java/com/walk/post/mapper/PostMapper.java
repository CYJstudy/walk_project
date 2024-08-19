package com.walk.post.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PostMapper {

	public List<Map<String, Object>> selectPostListTest();
	
	public void insertPost(
			@Param("userId") int userId, 
			@Param("subject") String subject, 
			@Param("place") String place, 
			@Param("distance") String distance,
			@Param("time") String time, 
			@Param("visitDate") String visitDate, 
			@Param("placeExplain") String placeExplain, 
			@Param("imagePath") String imagePath);
}
