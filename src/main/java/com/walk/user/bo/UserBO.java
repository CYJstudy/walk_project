package com.walk.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walk.user.entity.UserEntity;
import com.walk.user.repository.UserRepository;

@Service
public class UserBO {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserEntity getUserEntityLoginId(String loginId) {
		return userRepository.findByLoginId(loginId);
	}

	public UserEntity addUser(String loginId, String password, String name, String email, Boolean admin) {
		return userRepository.save(UserEntity.builder()
				.loginId(loginId)
				.password(password)
				.name(name)
				.email(email)
				.admin(admin)
				.build());
	}
	
	public UserEntity getUserEntityLoginIdAndPassword(String loginId, String pasword) {
		return userRepository.findByLoginIdAndPassword(loginId, pasword);
	}
	
	public UserEntity getUserEntityByEmail(String email) {
		return userRepository.findLoginIdByEmail(email);
	}
	
	public UserEntity getUserEntityByLoginIdAndEmail(String loginId, String email) {
		return userRepository.findPasswordByLoginIdAndEmail(loginId, email);
	}
}
