package com.walk.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.walk.common.FileManagerService;
import com.walk.post.domain.Post;
import com.walk.post.mapper.PostMapper;

@Service
public class PostBO {
	
	@Autowired
	private FileManagerService fileManagerService;
	
	@Autowired
	private PostMapper postMapper;
	
	public void addPost(int userId, String userLoginId, String subject, String place, String distance,
			String time, String visitDate, String placeExplain, MultipartFile file) {
		
		String imagePath = null;
		
		if (file != null) {
			imagePath = fileManagerService.uploadFile(file, userLoginId);
		}
		
		postMapper.insertPost(userId, userLoginId, subject, place, distance,
				time, visitDate, placeExplain, imagePath);
	}
	
	public List<Post> getPostList() {
		return postMapper.selectPostList();
	}
	
	public Post getPostByPostIdUserId(int postId, int userId) {
		
		return postMapper.selectPostByPostIdUserId(postId, userId);
	}
}
