package com.walk.post;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.walk.post.bo.PostBO;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/post")
@RestController
public class PostRestController {

	@Autowired
	private PostBO postBO;
	
	@PostMapping("/post-create")
	public Map<String, Object> postCreate(
			@RequestParam("subject") String subject,
			@RequestParam("place") String place,
			@RequestParam("distance") String distance,
			@RequestParam("time") String time,
			@RequestParam("visitDate") String visitDate,
			@RequestParam("placeExplain") String placeExplain,
			@RequestParam("file") MultipartFile file,
			HttpSession session) {
		
		int userId = (int)session.getAttribute("userId");
		String userLoginId = (String)session.getAttribute("userLoginId");
		
		postBO.addPost(userId, userLoginId, subject, place, distance, time, visitDate, placeExplain, file);
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		
		return result;
		
	}
	
	@PutMapping("/post-update")
	public Map<String, Object> postUpdate(
			@RequestParam("postId") int postId,
			@RequestParam("subject") String subject,
			@RequestParam("place") String place,
			@RequestParam("distance") String distance,
			@RequestParam("time") String time,
			@RequestParam("visitDate") String visitDate,
			@RequestParam("placeExplain") String placeExplain,
			HttpSession session) {
		
		int userId = (int)session.getAttribute("userId");
		String userLoginId = (String)session.getAttribute("userLoginId");
		
		postBO.updatePostByPostIdUserId(postId, userId, userLoginId, subject, place, distance, time, visitDate, placeExplain);
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		
		return result;
	}
	

	
}
