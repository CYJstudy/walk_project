package com.walk.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.walk.user.bo.UserBO;
import com.walk.user.entity.UserEntity;

@RequestMapping("/user")
@Controller
public class UserController {
	
	@Autowired
	private UserBO userBO;

	@GetMapping("/sign-up-view")
	public String signUp() {
		
		return "user/signUp";
	}

	@GetMapping("/sign-in-view")
	public String signIn() {
		
		return "user/signIn";
	}
	
	@GetMapping("/account-check-view")
	public String accountCheck() {
		
		return "user/accountCheck";
	}
	
	@ResponseBody
	@PostMapping("/account-check-pw")
	public Map<String, Object> accountCheckPw(
			@RequestParam("loginId") String loginId,
			@RequestParam("email") String email,
			Model model) {
		
		UserEntity user = userBO.getUserEntityByLoginIdAndEmail(loginId, email);
		
		model.addAttribute("user", user);
		
		Map<String, Object> result = new HashMap<>();
		if (user != null) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "비밀번호가 없습니다.");
		}
		
		return result;
		
	}
}
