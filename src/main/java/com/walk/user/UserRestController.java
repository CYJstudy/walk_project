package com.walk.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.walk.user.bo.UserBO;
import com.walk.user.entity.UserEntity;

@RequestMapping("/user")
@RestController
public class UserRestController {

	@Autowired
	private UserBO userBO;
	
	// 아이디중복
	@PostMapping("/is-duplicated-id")
	public Map<String, Object> isDuplicatedId(
			@RequestParam("loginId") String loginId) {
		
		UserEntity user = userBO.getUserEntityLoginId(loginId);
		
		Map<String, Object> result = new HashMap<>();
		if (user != null) {
			result.put("is_duplicated_id", true);
		} else {
			result.put("is_duplicated_id", false);
		}
		
		return result;
	}
	
	// 회원가입
	@PostMapping("/sign-up")
	public Map<String, Object> signUp(
			@RequestParam("loginId") String loginId,
			@RequestParam("password") String password,
			@RequestParam("name") String name,
			@RequestParam("email") String email) {
		
		Boolean admin = false;
		
		//userBO.addUser
		UserEntity user = userBO.addUser(loginId, password, name, email, admin);
		
		Map<String, Object> result = new HashMap<>();
		if (user != null) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "회원가입에 실패했습니다");
		}
		
		return result;
	}
	
	// 로그인
	@PostMapping("/sign-in")
	public Map<String, Object> signIn(			
			@RequestParam("loginId") String loginId,
			@RequestParam("password") String password) {
	
		UserEntity user = userBO.getUserEntityLoginIdAndPassword(loginId, password);
		
		Map<String, Object> result = new HashMap<>();
		if (user != null) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "로그인에 실패했습니다");
		}
		
		return result;
	}
	
//	@PostMapping("/account-check-id")
//	public Map<String, Object> accountCheckId(
//			@RequestParam("email") String email) {
//		
//		UserEntity user = userBO.getUserEntityByEmail(email);
//		
//		Map<String, Object> result = new HashMap<>();
//		if (user != null) {
//			result.put("code", 200);
//			result.put("result", "성공");
//		} else {
//			result.put("code", 500);
//			result.put("error_message", "아이디가 없습니다.");
//		}
//		
//		return result;
//		
//	}

	
}














