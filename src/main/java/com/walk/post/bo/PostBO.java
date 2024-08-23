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
	
	// 신규 글 작성
	public void addPost(int userId, String userLoginId, String subject, String place, String distance,
			String time, String visitDate, String placeExplain, MultipartFile file) {
		
		String imagePath = null;
		
		if (file != null) {
			imagePath = fileManagerService.uploadFile(file, userLoginId);
		}
		
		postMapper.insertPost(userId, userLoginId, subject, place, distance,
				time, visitDate, placeExplain, imagePath);
	}
	
	// 글 목록 가져오기
	public List<Post> getPostList() {
		return postMapper.selectPostList();
	}
	
	// 게시글 하나 가져오기
	public Post getPostByPostId(int postId) {
		
		return postMapper.selectPostByPostId(postId);
	}
	
	// 게시글 내용 업데이트
	public void updatePostByPostIdUserId(int postId, int userId, String userLoginId, String subject, String place, 
			String distance, String time, String visitDate, String placeExplain) {
		
//		String imagePath = null;
//		
//		if (file == null) {
//			imagePath = fileManagerService.uploadFile(file, userLoginId);
//		}

		postMapper.updatePostByPostId(postId, subject, place, distance, time, visitDate, placeExplain);
	}
}
