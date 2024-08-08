package com.walk.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walk.user.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
