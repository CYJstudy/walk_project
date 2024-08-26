package com.walk.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.walk.post.bo.PostBO;
import com.walk.post.domain.Post;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/post")
@Controller
public class PostController {

	@Autowired
	private PostBO postBO;
	
	@GetMapping("/post-create-view")
	public String postCreate() {
		
		return "post/postCreate";
	}
	
	@GetMapping("/post-list-view")
	public String postList(Model model, HttpSession session) {
		// 로그인 여부 확인
		Integer userId = (Integer) session.getAttribute("userId");
		if (userId == null) {
			return "redirect=/user/sign-in-view";
		}
		
		List<Post> postList = postBO.getPostList();
		
		model.addAttribute("postList", postList);
		
		return "post/postList";
	}
	
	@GetMapping("/post-update-view")
	public String postUpdate(
			@RequestParam("postId") int postId,
			Model model,
			HttpSession session) {
		
		Integer userId = (Integer) session.getAttribute("userId");
		if (userId == null) {
			return "redirect=/user/sign-in-view";
		}
		
		Post post = postBO.getPostByPostId(postId);
		
		model.addAttribute("post", post);
		
		return "post/postUpdate";
	}
	
	@GetMapping("/photo-list-view")
	public String photoList() {
		
		return "post/photoList";
	}
}
